/**
 * Write a description of class EnemyFactory here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
 import greenfoot.*;
public class EnemyFactory extends Actor  
{
   
    public void act() 
    {
        // Add your action code here.
    }   
    
    public Enemy getEnemy(String enemyType){
      if(enemyType == null){
         return null;
      }		
      if(enemyType.equalsIgnoreCase("Duck")){
         return new Duck();
         
      } 
      else if(enemyType.equalsIgnoreCase("Monster")){
          return new Monster();
        }
         
         return null;
   }   
}


