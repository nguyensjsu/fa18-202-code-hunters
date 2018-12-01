import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
         * Write a description of class MarioWorld2 here.
         * 
         * @author (your name) 
         * @version (a version number or a date)
         */
public class MarioWorld2 extends World implements Observer
{

    public Block blocks1[] = new Block[18];
    public Block blocks2[] = new Block[4];
    public Block blocks3[] = new Block[15];
    public Block blocks4[] = new Block[20];
    public Block blocks5[] = new Block[12]; 
    public Block blocks6[] = new Block[18];
    public Block blocks7[] = new Block[15];
    public Block blocks8[] = new Block[10];
    public Block blocks9[] = new Block[5];
    public Block blocks10[] = new Block[8];
    public Block blocks11[] = new Block[8];
    public boolean isRunning=true;
    PauseScreen pp=new PauseScreen();
    public Score scoreObj;
    EnemyFactory enemyFactory;
    static GreenfootSound theme = new GreenfootSound("Theme Song.mp3");
    /**
     * Constructor for objects of class MarioWorld.
     * 
     */
    public MarioWorld2(Score score)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(500, 1080/2, 1); 
        
        GreenfootImage background = getBackground();
        enemyFactory = new EnemyFactory(score);
        this.scoreObj = score;
        buildWorld();
        if(theme.isPlaying() == false)
        {
            theme.playLoop();
        }
        
    }

    public void rebuildWorld(){
        List objects = getObjects(null);
        removeObjects(objects);
        buildWorld();
    }
    
    private void buildWorld(){
        createBlocks();
        addObject(scoreObj, 25, 10);
        addObject(new Floor(),250, 524 );
        addObject(new Person(this, scoreObj), 50,500);
        addObject(new Princess(this), 30,68);
        addObject(enemyFactory.getEnemy("Wizard"),100,160);
        addObject(enemyFactory.getEnemy("HammerBoy"),360,80);
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
            addObject(enemyFactory.getEnemy("HammerBoy"),360,80);
            addObject(enemyFactory.getEnemy("Wizard"),100,160);
        }
        }
          if(Greenfoot.mouseClicked(this))
        {
            if(isRunning)
             {   isRunning = false;
                addObject(pp,100,100);
            }
            else if(!isRunning){
                isRunning = true;
                removeObject(pp);
            }
        }
    }

    /**
     * createBlocks - adds the blocks/platforms
     */
    public void createBlocks()
    {
         //32 blocks - Block set #1
        int x = 100;
        for(int i = 0; i < 18; i++)
        {
           blocks1[i] = new Block();
           addObject(blocks1[i], x, 350);
           x+=7;
            }
        //4 blocks - Block set #2
        int x2 = 240;
        for(int i = 0; i< 4; i++)
        {
            blocks2[i] = new Block();
            addObject(blocks2[i], x2, 100);
            x2+=7;
        }

        //15 blocks - Block set #3
        int x3 = getWidth() - 430;
        for(int i = 0; i < 15; i++)
        {
            blocks3[i] = new Block();
            addObject(blocks3[i], x3, 450);
            x3+=7;
        }

        //20 blocks - Block set #4
        int x4 = 80;
        for(int i = 0; i < 20; i++)
        {
            blocks4[i] = new Block();
            addObject(blocks4[i], x4, 240);
            x4+=7;
        }

        //12 blocks - Block set #5
        int x5 = getWidth() - 200;
        for(int i = 0; i<12; i++)
        {
            blocks5[i] = new Block();
            addObject(blocks5[i], x5, 360);
            x5+=7;
        }
        
        //18 blocks - Block set #5
        int x6 = getWidth() - 350;
        for(int i = 0; i<18; i++)
        {
            blocks6[i] = new Block();
            addObject(blocks6[i], x6, 400);
            x6+=7;
        }

        //18 blocks - Block set #5
        int x7 = getWidth() - 300;
        for(int i = 0; i<15; i++)
        {
            blocks6[i] = new Block();
            addObject(blocks6[i], x7, 300);
            x7+=7;
        }
        
        int x8 = getWidth() - 200;
        for(int i = 0; i<10; i++)
        {
            blocks8[i] = new Block();
            addObject(blocks8[i], x8, 150);
            x8+=7;
        }
        
        int x9 = getWidth() - 250;
        for(int i = 0; i<5; i++)
        {
            blocks9[i] = new Block();
            addObject(blocks9[i], x9, 200);
            x9+=7;
        }
        
        int x10 = getWidth() - 380;
        for(int i = 0; i<8; i++)
        {
            blocks10[i] = new Block();
            addObject(blocks10[i], x10, 100);
            x10+=7;
        }
        
         int x11 = getWidth() - 480;
        for(int i = 0; i<8; i++)
        {
            blocks11[i] = new Block();
            addObject(blocks11[i], x11, 80);
            x11+=7;
        }

    }
    
    public void update(){
        if(scoreObj.score() == 50){
            scoreObj.setState(2);
        
    }
}
}
