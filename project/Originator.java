import greenfoot.*;
/**
 * Write a description of class Originator here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class Originator {
   private World state;

   public void setState(World state){
      this.state = state;
   }

   public World getState(){
      return state;
   }

   public Memento saveStateToMemento(){
      return new Memento(state);
   }

   public void getStateFromMemento(Memento memento){
      state = memento.getState();
   }
}