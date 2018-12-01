import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class WinWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WinWorld extends World
{
    static GreenfootSound theme = new GreenfootSound("Menu theme.mp3");
    GreenfootSound clicked = new GreenfootSound("Clicked.wav");
    /**
     * Constructor for objects of class WinWorld.
     * 
     */
    public WinWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(500, 1080/2, 1); 
        if(theme.isPlaying() == false)
        {
            //theme.playLoop();
        }
    }
    
    public void act()
    {
        if (Greenfoot.isKeyDown("enter"))
        {
            theme.stop();
            clicked.play();
            Greenfoot.setWorld(new StartMenu1());
        }
    }
}
