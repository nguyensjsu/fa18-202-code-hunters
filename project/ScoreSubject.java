import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class ScoreSubject here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ScoreSubject extends Actor
{
   private int score = 0 ;
   private List<Observer> listOfObservers;
    public void ScoreSubject() 
    {
        listOfObservers = new ArrayList<Observer>();
     
    }   
    
    public int getState(){
       return ((MyWorld) getWorld()).getState();
    }
    
    public void setState(int addScore){
        ((MyWorld) getWorld()).addScore(addScore);
        notifyObservers();
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
