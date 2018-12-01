import greenfoot.*;
import java.util.ArrayList;
import java.util.List;

public class CareTaker {
    
   private Memento mementoList;

   public void setMemento(Memento state){
      mementoList = state;
   }

   public Memento getMemento(){
      return mementoList;
   }
}
