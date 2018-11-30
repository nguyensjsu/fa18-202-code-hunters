import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
        
/**
         * Write a description of class MarioWorld2 here.
         * 
         * @author (your name) 
         * @version (a version number or a date)
         */
public class MarioWorld2 extends World implements Observer
{

    public Block blocks1[] = new Block[32];
    public Block blocks2[] = new Block[4];
    public Block blocks3[] = new Block[15];
    public Block blocks4[] = new Block[20];
    public Block blocks5[] = new Block[12]; 
    public Block blocks6[] = new Block[18];
    public Block blocks7[] = new Block[15];
    public Score scoreObj;
    /**
     * Constructor for objects of class MarioWorld.
     * 
     */
    public MarioWorld2(Score score)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(500, 1080/2, 1); 
        
        GreenfootImage background = getBackground();
        this.scoreObj = score;
        createBlocks();
        System.out.println(scoreObj.score());
        addObject(scoreObj, 10, 10);
        addObject(new Floor(),250, 524 );
        addObject(new Person(this, scoreObj), 98, 219);
        addObject(new Enemy(scoreObj), 60, 60);
    }

    /**
     * act - randomly spawns more enemies
     */
    public void act()
    {
        int random = Greenfoot.getRandomNumber(300);

        if(random == 10)
        {
            addObject(new Enemy(scoreObj), 60, 60);
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
        if(scoreObj.score() = 50){
            scoreObj.setState(2);
        }
    }
}
