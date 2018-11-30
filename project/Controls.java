import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Will display the controls to the user
 * 
 * @author 
 * @version
 */
public class Controls extends World
{
    private int enterDelayCount; //Ticks up to determine when the player can press enter - to keep them from accidentally flipping through two worlds
    GreenfootSound clicked = new GreenfootSound("Clicked.wav");
    /**
     * Constructs the controls world
     */
    public Controls()
    {    
        super(500, 1080/2, 1);
    }
    
    /**
     * Ticks up the enterDelayCount and switches the world when the enter key is pressed
     */
    public void act()
    {
        enterDelayCount ++;
        if (Greenfoot.isKeyDown("enter") && enterDelayCount > 15)
        {
            clicked.play();
            Greenfoot.setWorld(new StartMenu2());
        }
    }
}
