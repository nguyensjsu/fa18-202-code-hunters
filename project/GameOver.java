import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

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
        GreenfootImage image = new GreenfootImage("GameOverScreen.png");

        image.setColor(Color.WHITE);

        image.drawString("Score: " + score.score(), 10, 50);
        setImage(image);
    }
}
