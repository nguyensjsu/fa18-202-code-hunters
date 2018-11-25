import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
//import java.awt.Color;
/**
 * Write a description of class GameOver here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameOver extends Actor
{
/**
 * GameOver - constructs the GameOver class
 */
    public GameOver(Score score)
    {
        GreenfootImage image = new GreenfootImage(100, 100);
        image.setColor(new Color(0, 190, 50));
        //image.fillRect(0, 0, 100, 100);
        image.setColor(Color.GREEN);
        image.drawString("GAME OVER", 10, 25);
        image.drawString("Score: " + score.score(), 10, 50);
        setImage(image);
    }
    
    
    
    
}
