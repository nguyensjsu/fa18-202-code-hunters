import greenfoot.*;
/**
 * Write a description of class Memento here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */


public class Memento {
   private World lastWorld;

   public Memento(World lastWorld){
      this.lastWorld = lastWorld;
   }

   public World getState(){
      return lastWorld;
   }	
}