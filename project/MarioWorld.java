import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
 * Write a description of class MarioWorld here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class MarioWorld extends World implements Observer
{

    public Block blocks1[] = new Block[32];
    public Block blocks2[] = new Block[4];
    public Block blocks3[] = new Block[15];
    public Block blocks4[] = new Block[20];
    public Block blocks5[] = new Block[12];
    public Block blocks6[] = new Block[18];
    public Block blocks7[] = new Block[15];
    public boolean isRunning=true;
    PauseScreen pp=new PauseScreen();
    public Score score;

    /**
     * Constructor for objects of class MarioWorld.
     *
     */
    public MarioWorld()
    {
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(500, 1080/2, 1);
        this.score = new Score(0);
        GreenfootImage background = getBackground();
        background.setColor(Color.BLACK);
        background.fill();
        this.score.attach(new MarioWorld2(this.score));
        createBlocks();

        //concretesubject.setState(mw);
        addObject(score, 10, 10);
        addObject(new Floor(),250, 524 );
        addObject(new Person(this, score), 98, 219);
        addObject(new Enemy(score), 60, 60);


    }

    /**
     * act - randomly spawns more enemies
     */
    public void act()
    {
        int random = Greenfoot.getRandomNumber(300);
        if(isRunning)
        {if(random == 10)
        {
            addObject(new Enemy(score), 60, 60);
        }
    }
          if(Greenfoot.mouseClicked(this))
    {
        if(isRunning)
         {   isRunning = false;
            addObject(pp,100,100);
        }
        else if(!isRunning)
            {isRunning = true;
            removeObject(pp);}
    }

    }

    /**
     * createBlocks - adds the blocks/platforms
     */
    public void createBlocks()
    {
         //32 blocks - Block set #1
        int x = 100;
        for(int i = 0; i < 32; i++)
        {
           blocks1[i] = new Block();
           addObject(blocks1[i], x, 330);
           x+=7;
            }
        //4 blocks - Block set #2
        int x2 = 3;
        for(int i = 0; i< 4; i++)
        {
            blocks2[i] = new Block();
            addObject(blocks2[i], x2, 350);
            x2+=7;
        }

        //15 blocks - Block set #3
        int x3 = getWidth() - 400;
        for(int i = 0; i < 15; i++)
        {
            blocks3[i] = new Block();
            addObject(blocks3[i], x3, 450);
            x3+=7;
        }

        //20 blocks - Block set #4
        int x4 = 30;
        for(int i = 0; i < 20; i++)
        {
            blocks4[i] = new Block();
            addObject(blocks4[i], x4, 270);
            x4+=7;
        }

        //12 blocks - Block set #5
        int x5 = getWidth() - 200;
        for(int i = 0; i<12; i++)
        {
            blocks5[i] = new Block();
            addObject(blocks5[i], x5, 380);
            x5+=7;
        }

        //18 blocks - Block set #5
        int x6 = getWidth() - 450;
        for(int i = 0; i<18; i++)
        {
            blocks6[i] = new Block();
            addObject(blocks6[i], x6, 400);
            x6+=7;
        }

        //18 blocks - Block set #5
        int x7 = getWidth() - 200;
        for(int i = 0; i<18; i++)
        {
            blocks6[i] = new Block();
            addObject(blocks6[i], x7, 430);
            x7+=7;
        }

    }
    public void update(){
        if(score.score() < 10){
            score.setState(2);
        }
    }
}
