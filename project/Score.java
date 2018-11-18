import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Score here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Score extends Actor
{
    public int score = 0;
    private GreenfootImage image;
    /**
     * Score - constructs the score class
     */
    public Score()
    {
        image = new GreenfootImage(100, 30);
        image.setColor(Color.GREEN);
        image.drawString("Score:  " + score, 5, 15);
        setImage(image);
    }

    /**
     * addScore - adds 10 to the current score and sets the image
     */
    public void addScore()
    {
        score+=10;
        setImage();
    }

    /**
     * setImage - sets the image to the current score
     */
    public void setImage()
    {
        image.clear();
        image.drawString("Score:  " + score, 5, 15);
        setImage(image);
    }
    
    public int score()
    {
        return score;
    }
}
