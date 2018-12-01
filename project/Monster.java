import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Monster here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Monster extends Enemy
{
    //Basic Physics Variables  
    private double positionX =400;  
    private double positionY = 180;
    private double speedX = 0.5;
    private double velocityX = - speedX;  
    private double velocityY = 0;  
    private double accelerationX = 0;  
    private double accelerationY = 0;  
    GreenfootSound clicked = new GreenfootSound("Clicked.wav");
    //Force Values  
    private double gravityY = 0.1;  
    private double jumpForce = 2;   //originally 3.5

    private boolean knockedOver = false;

    private Score score;
    
    
    public Monster(Score scr)
    {
        score = scr;
    }
    
//    public Monster(){}

    /**
     * Act - do whatever the Enemy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(MarioWorld.class.isInstance(getWorld())){
            if(((MarioWorld) getWorld()).isRunning)
            {applyGravity();  
            teleport();
            hitSide();
            checkIfHit();
            move();
            if(knockedOver)
            {
                checkIfKicked(); 
            }
            }
        }else{
            if(((MarioWorld2) getWorld()).isRunning){
                applyGravity();  
                teleport();
                hitSide();
                checkIfHit();
                move();
                if(knockedOver)
                {
                    checkIfKicked(); 
                }
            }
        }
    }   

    /**
     * checkIfKicked - checks whether the knocked over turtle has been kicked
     */
    public void checkIfKicked()
    {
        Actor mario = getOneIntersectingObject(Person.class);
        if(mario != null)
        {
            score.addScore();
            getWorld().removeObject(this);
        }
    }

    /**
     * knockedOver - returns wether the turtle is knocked over or not
     */

    public boolean knockedOver()
    {
        return knockedOver;
    }

    /**
     * move - moves the turtle based on physics variables
     */
    public void move()
    {
        //Basic Physics  
        if(!knockedOver)
        {
            velocityX += accelerationX;  
            velocityY += accelerationY;  
            positionX += velocityX;  
            positionY += velocityY;  
            accelerationX = 0;  
            accelerationY = 0;  
            setLocation((int)positionX,(int)positionY); 
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

        }  
    } 

    
    /**
     * hitSide - determines if the turtle hits another turtle and turns if it does
     */
    private void hitSide()
    {
        Actor coll = getOneObjectAtOffset(5, 0, Monster.class);
        if(coll != null)
        {
            velocityX = -velocityX;
        }
    }

    
    /**
     * checkIfHit - checks whether the block it is on has been hit from below
     */
    public void checkIfHit()
    {
        Actor coll = getOneIntersectingObject(Block.class);
        if(coll!= null)
        {
            Block block = (Block) coll;
            if(!block.normal())
            {
                getKnockedOver();
            }
        }
    }

    
    /**
     * getKnockedOver - knocks over the turtle, making it vulnerable
     */
    public void getKnockedOver()
    {
        setImage("deadgoomba.png");
        accelerationY -=jumpForce;
        accelerationX = -velocityX;
        knockedOver = true;
        clicked.play();
    }

    /**
     * onGround - determines if the actor is on the ground
     */
    public boolean onGround()
    {
        Actor coll = getOneObjectAtOffset(0, 8, Platform.class);
        if(coll != null)
        {
            return true;
        }
        return false;
    }

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
    
}
