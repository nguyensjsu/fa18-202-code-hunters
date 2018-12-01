import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)  

/** 
 * The person who will move about platforms. 
 * @author - Michael "webmessia"  (modified by Noah Pederson)
 */  
public class Person  extends Actor  
{  
   iPersonState personAliveState, personDeadState, personState;
    //Basic Physics Variables  
    private double positionX = 130;  
    private double positionY = 100;  
    private double velocityX = 0;  
    private double velocityY = 0;  
    private double accelerationX = 0;  
    private double accelerationY = 0;  

    //Force Values  
    private double gravityY = 0.1;  
    private double jumpForce = 4;   //originally 3.5

    public World world;
    public Score score;

    private boolean isFacingRight = true;
    private int timer = 0;

    private boolean hitBlock = false;
    Originator originator;
    CareTaker careTaker;
    /**
     * Person - constructs the person (mario) class
     */
    public Person(World w, Score scr)
    {
        world = w;
        score = scr;
        originator = new Originator();
        careTaker = new CareTaker();
        personAliveState = new PersonAliveState(this); // * state pattern 1*
        personDeadState = new PersonDeadState(this); // * state pattern 1*
        personState = personAliveState; // * state pattern 1*
    }

    
    /**
     * addedToWorld - unused
     */
    public void addedToWorld(World w){  
        //We set our position to the position which we were added to the world at.  
        positionX = getX();
        positionY = getY();
    }  

    /** 
     * Act - do whatever the Person wants to do. This method is called whenever 
     * the 'Act' or 'Run' button gets pressed in the environment. 
     */  
    public void act()   
    {  
        //Apply Forces to change acceleration to move the person
       if(MarioWorld.class.isInstance(getWorld())){
       if(((MarioWorld)getWorld()).isRunning)
       {
        applyGravity();  
        applyJumpForce();  
        //move left or right
        runTimer();
        moveRightAndLeft();
        teleport();
        hitTop();
        hitSide();
        checkIfDead();

        move();
       }}else{
        if(((MarioWorld2)getWorld()).isRunning){
        applyGravity();  
        applyJumpForce();  

        //move left or right
        runTimer();
        moveRightAndLeft();
        teleport();
        hitTop();
        hitSide();
        checkIfDead();
        
        move();
       }
    }
    }
    /**
     * move - moves the actor based on physics varibles
     */
    public void move()
    {
        //Basic Physics  
        velocityX += accelerationX;  
        velocityY += accelerationY;  
        positionX += velocityX;  
        positionY += velocityY;  
        accelerationX = 0;  
        accelerationY = 0;  
        setLocation((int)positionX,(int)positionY);
    }

    
    
    /**
     * checkIfDead - checks whether the person has collided with a turtle that hasn't been knocked over
     */
    private void checkIfDead()
    {
        Actor turtle = getOneIntersectingObject(Duck.class);
        Actor monster = getOneIntersectingObject(Monster.class);
        Actor wizard = getOneIntersectingObject(Wizard.class);
        Actor hammerboy = getOneIntersectingObject(HammerBoy.class);
        if(turtle != null || monster != null || wizard != null || hammerboy != null)
        {
            
            originator.setState(getWorld());
            careTaker.setMemento(originator.saveStateToMemento());
            if(score.getLife() == 0){
                personState.setState();
                getWorld().addObject(new GameOver(score), getWorld().getWidth() / 2,
                getWorld().getHeight() /  2);
                Greenfoot.stop();
            }else{                
                originator.getStateFromMemento(careTaker.getMemento());
                if (getWorld() instanceof MarioWorld)
                {
                    score.decreaseLife();
                    MarioWorld myWorld = (MarioWorld)originator.getState();
                    myWorld.rebuildWorld();
                }
                if (getWorld() instanceof MarioWorld2)
                {
                    score.decreaseLife();
                    MarioWorld2 worldTwo = (MarioWorld2)originator.getState();
                    worldTwo.rebuildWorld();
                }
            }

            
        }
    }

    /**
     * runTimer - runs the timer that runs the animations
     */
    private void runTimer()
    {
        timer++;
        if(timer == 15)
            timer = 0;
    }

    /**
     * animate - animates mario running
     */
    private void animate()
    {
        if(onGround())
        {
            if(timer == 0)
            {
                if(isFacingRight)
                    setImage("marioRight1.png");
                else
                    setImage("mario1.png");
            }
            else if(timer == 5)
            {
                if(isFacingRight)
                    setImage("marioRight2.png");
                else
                    setImage("mario2.png");
            }
            else if(timer == 10)
            {
                if(isFacingRight)
                    setImage("marioRight3.png");
                else
                    setImage("mario3.png");
            }
        }
    }

    /** 
     * Accelerates the person downwards except for when they are on a platform 
     */  
    private void applyGravity(){  
        // Check For collision with platform  
        //Actor coll = getOneIntersectingObject(Platform.class);  
        if(!onGround()){   
            //This is run when the person is not touching a platform  
            //This code adds gravity to our total acceleration.  
            accelerationY += gravityY;  
        } else {   
            //This is run once we hit a platform  
            //We make our person stop moving in the y direction. (up/down direction).  
            velocityY = 0;  
            hitBlock = false;
        }  
    }  

    /**
     * hitTop - checks if mario has hit block
     */
    public void hitTop()
    {
        Actor coll = getOneObjectAtOffset(1, -11, Platform.class);
        if(coll != null)
        {
            velocityY = 0;
            if(coll instanceof Block && !hitBlock)
            {
                Block actor = (Block) coll;
                actor.directHit();
                hitBlock = true;
            }
        }
    }

    /**
     * hitSide - checks if mario has hit the side of a platform
     */
    private void hitSide()
    {
        Actor coll = getOneObjectAtOffset(10, 0, Platform.class);
        if(coll != null)
        {
            velocityX = 0;
        }
    }

    /**
     * moveRightAndLeft - moves mario right or left based on the arrow keys pressed
     */
    public void moveRightAndLeft()
    {
        if(Greenfoot.isKeyDown("right"))
        {
            velocityX = 1.5;
            isFacingRight = true;
            animate();
        }
        else if(Greenfoot.isKeyDown("left"))
        {
            velocityX = -1.5;
            isFacingRight = false;
            animate();
        }
        else if(!Greenfoot.isKeyDown("left") || !Greenfoot.isKeyDown("right"))
        {
            velocityX = 0;
            if(onGround())
            {
                if(isFacingRight)
                    setImage("marioRight0.png");
                else
                    setImage("mario0.png");
            }
            else
            {
                if(isFacingRight)
                    setImage("marioRight5.png");
                else
                    setImage("mario5.png");
            }
        }
    }

    /** 
     * Accelerates the person upwards if space is pressed and we are on a platform 
     */  
    public void applyJumpForce(){  
        //Actor coll = getOneIntersectingObject(Platform.class);  
        if(onGround()){  
            //This is run when the person is touching a platform  
            if(Greenfoot.isKeyDown("up")){  
                accelerationY -= jumpForce;  
                jumpAnimate();
            }  
        }  
    }  

    /**
     * jumpAnimate - changes the picture of mario if he is in the air
     */
    public void jumpAnimate()
    {
        if(isFacingRight)
            setImage("marioRight5.png");
        else
            setImage("mario5.png");
    }

    /**
     * onGround - determines if the actor is on the ground
     */
    public boolean onGround()
    {
        Actor coll = getOneObjectAtOffset(0, 11, Platform.class);
        if(coll != null)
        {
            return true;
        }
        return false;
    }

    /**
     * teleport - puts mario on the oposite side of the map if he walks off
     */
    public void teleport()
    {
        //if you go to the side of the world, you get put on the opposite side at the same level
        if(positionX >= getWorld().getWidth()-5)
        {
            positionX = 6;
        }
        else if(positionX <= 5)
        {
            positionX = getWorld().getWidth() - 5;
        }

    
    }
//staet pattern    
     public void display() {
        personState.display();
    }
    void setState(iPersonState state) {
        System.out.println("received"+state);
        this.personState = state;
    }
    iPersonState getPersonAliveState()
    {
        return personAliveState;
    }    
    iPersonState getPersonDeadState()
    {
        return personDeadState;
    }
    
    
    
}
  