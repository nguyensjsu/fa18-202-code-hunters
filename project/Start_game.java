import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Start_game here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Start_game extends World
{

    /**
     * Constructor for objects of class Start_game.
     * 
     */
    public Start_game()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
       super(240, 491/2, 1);
       
       
    }
    
     public void act() 
    {
        // Add your action code here.
        if (Greenfoot.isKeyDown("enter"))
        {
            Greenfoot.setWorld (new MarioWorld ());
        }
    }    
    
    
}