import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
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
    public Block blocks5[] = new Block[16];
    public Block blocks6[] = new Block[18];
    public Block blocks7[] = new Block[15];
    public Block blocks8[] = new Block[20];
    public boolean isRunning=true;
    PauseScreen pp=new PauseScreen();
    public Score score;

    /**
     * Constructor for objects of class MarioWorld.
     *
     */
     EnemyFactory enemyFactory;
    public MarioWorld()
    {
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(500, 1080/2, 1);
        this.score = new Score(0);
        GreenfootImage background = getBackground();
        background.setColor(Color.BLACK);
        background.fill();
        this.score.attach(new MarioWorld2(this.score));

        //concretesubject.setState(mw);
        buildWorld();

    }

    public void rebuildWorld(){
        List objects = getObjects(null);
        removeObjects(objects);
        buildWorld();
    }

    private void buildWorld(){
        createBlocks();
        enemyFactory = new EnemyFactory(score);
        addObject(score, 25, 10);

        addObject(new Floor(),250, 524 );
        addObject(new Person(this, score), 50,500);
        addObject(new Enemy(score), 60, 60);
        Enemy duck = enemyFactory.getEnemy("Duck");
        Enemy monster = enemyFactory.getEnemy("Monster");
        addObject(duck,60,60);
        addObject(monster,50,50);
    }

    /**
     * act - randomly spawns more enemies
     */
    public void act()
    {
        int random = Greenfoot.getRandomNumber(300);

        if(isRunning)
        {
          if(random == 10)
          Enemy duck = enemyFactory.getEnemy("Duck");
          Enemy monster = enemyFactory.getEnemy("Monster");
          if(random == 10)
        {
            addObject( duck, 60, 60);
            addObject(monster,50,50);
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
        int x = 140;

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
        int x5 = getWidth() - 180;
        for(int i = 0; i<16; i++)
        {
            blocks5[i] = new Block();
            addObject(blocks5[i], x5, 400);
            x5+=7;
        }

        //18 blocks - Block set #5
        int x6 = getWidth() - 480;
        for(int i = 0; i<18; i++)
        {
            blocks6[i] = new Block();
            addObject(blocks6[i], x6, 400);
            x6+=7;
        }

        //18 blocks - Block set #5
        int x7 = getWidth() - 100;
        for(int i = 0; i<18; i++)
        {
            blocks6[i] = new Block();
            addObject(blocks6[i], x7, 450);
            x7+=7;
        }

        int x8 = 340;
        for(int i = 0; i < 20; i++)
        {
            blocks8[i] = new Block();
            addObject(blocks8[i], x8, 270);
            x8+=7;
        }


    }

    public void update(){
        if(score.score() < 10){
            score.setState(2);
        }
    }
}
