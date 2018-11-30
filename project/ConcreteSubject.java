import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;
/**
 * Write a description of class ConcreteSubject here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ConcreteSubject extends Actor implements Subject
{
   private List<Observer> listOfObservers;
    public void ScoreSubject() 
    {
        listOfObservers = new ArrayList<Observer>();
     
    }   
    
    public World getState()
    {
        return getWorld();
    }
    
    public void setState(World myworld){
        myworld = getWorld();
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
