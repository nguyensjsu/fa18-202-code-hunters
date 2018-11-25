import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MarioWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MarioWorld extends World
{

    public Block blocks1[] = new Block[16];
    public Block blocks2[] = new Block[4];
    public Block blocks3[] = new Block[4];
    public Block blocks4[] = new Block[12];
    public Block blocks5[] = new Block[12];
    public Score score = new Score();
    /**
     * Constructor for objects of class MarioWorld.
     * 
     */
     EnemyFactory enemyFactory = new EnemyFactory();
    public MarioWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(240, 491/2, 1); 

        GreenfootImage background = getBackground();
        background.setColor(Color.BLACK);
        background.fill();

        createBlocks();

        addObject(score, 10, 10);
        addObject(new Floor(), 120, 237);
        addObject(new Person(this, score), 98, 219);
        Enemy duck = enemyFactory.getEnemy("Duck");
        Enemy monster = enemyFactory.getEnemy("Monster");
        addObject(duck,60,60);
        addObject(monster,50,50);
        //addObject(new Enemy(score), 60, 60);
    }

    /**
     * act - randomly spawns more enemies
     */
    public void act()
    {
        int random = Greenfoot.getRandomNumber(300);
        Enemy duck = enemyFactory.getEnemy("Duck");
        Enemy monster = enemyFactory.getEnemy("Monster");
        if(random == 10)
        {
            addObject( duck, 60, 60);
             addObject(monster,50,50);
        }
    }

    /**
     * createBlocks - adds the blocks/platforms
     */
    public void createBlocks()
    {
        //16 blocks - Block set #1
        int x = 67;
        for(int i = 0; i < 16; i++)
        {
            blocks1[i] = new Block();
            addObject(blocks1[i], x, 140);
            x+=7;
        }
        //4 blocks - Block set #2
        int x2 = 3;
        for(int i = 0; i< 4; i++)
        {
            blocks2[i] = new Block();
            addObject(blocks2[i], x2, 150);
            x2+=7;
        }

        //4 blocks - Block set #3
        int x3 = getWidth() - 25;
        for(int i = 0; i < 4; i++)
        {
            blocks3[i] = new Block();
            addObject(blocks3[i], x3, 150);
            x3+=7;
        }

        //12 blocks - Block set #4
        int x4 = 3;
        for(int i = 0; i < 12; i++)
        {
            blocks4[i] = new Block();
            addObject(blocks4[i], x4, 192);
            x4+=7;
        }

        //12 blocks - Block set #5
        int x5 = getWidth() - 81;
        for(int i = 0; i<12; i++)
        {
            blocks5[i] = new Block();
            addObject(blocks5[i], x5, 192);
            x5+=7;
        }

    }
}
