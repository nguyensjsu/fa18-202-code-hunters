import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class Score here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Score extends Actor implements Subject
{
    public int score = 0;
    public int life = 1;
    private GreenfootImage image;
    MarioWorld2 mw  ;
    private List<Observer> listOfObservers;
    /**
     * Score - constructs the score class
     */
    public Score(int score)
    {
        this.score = score;
        image = new GreenfootImage(130, 30);
        image.setColor(Color.GREEN);
        image.drawString("Score:  " + Integer.toString(score) + "  Life:  " + Integer.toString(life), 40, 17);
        setImage(image);
        listOfObservers = new ArrayList<Observer>();
    }

    /**
     * addScore - adds 10 to the current score and sets the image
     */
    public void addScore()
    {
        score+=10;
        setImage();
        notifyObservers();
    }

    /**
     * setImage - sets the image to the current score
     */
    public void setImage()
    {
        image.clear();
        image.drawString("Score:  " + Integer.toString(score) + "  Life:  " + Integer.toString(life), 35, 17);
        setImage(image);
    }

    public int score()
    {
        return score;
    }
    
    public int getLife()
    {
        return life;
    }
    
    public void decreaseLife(){
        life--;
        image.clear();
        image.drawString("Score:  " + Integer.toString(score) + "  Life:  " + Integer.toString(life), 40, 17);
        setImage(image);
    }

    public World getState()
    {
        return getWorld();
    }

    public void setState(int level){
        if(level == 2){
            Greenfoot.setWorld((World)listOfObservers.get(0));
        }

    }

    public void attach(Observer o){
        this.listOfObservers.add(o);
    }

    public void detach(Observer o){
         this.listOfObservers.remove(o);
    }

    public void notifyObservers(){
        for(Observer o: listOfObservers){
            o.update();
        }
    }
}
