import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description.
 * 
 * @author 
 * @version
 */
public class StartMenu1 extends World
{
    private int enterDelayCount;
    static GreenfootSound theme = new GreenfootSound("Menu theme.mp3");
    GreenfootSound clicked = new GreenfootSound("Clicked.wav");
    /**
     * Constructor for objects of class StartMenu1.
     * 
     */
    public StartMenu1()
    {    
        super(500, 1080/2, 1);
        if(theme.isPlaying() == false)
        {
            theme.playLoop();
        }
    }
    
    public void act()
    {
        enterDelayCount ++;
        if (Greenfoot.isKeyDown("enter") && enterDelayCount > 15)
        {
            theme.stop();
            clicked.play();
            Greenfoot.setWorld(new MarioWorld());
        }
        if (Greenfoot.isKeyDown("down"))
        {
            clicked.play();
            Greenfoot.setWorld(new StartMenu2());
        }
    }
}
