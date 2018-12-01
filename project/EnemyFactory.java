/**
 * Write a description of class EnemyFactory here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
 import greenfoot.*;
public class EnemyFactory extends Actor  
{
    public Score score;
    
    public EnemyFactory(Score score){
        this.score = score;
    }
    public void act() 
    {
        // Add your action code here.
    }   
    
    public Enemy getEnemy(String enemyType){
      if(enemyType == null){
         return null;
      }     
      if(enemyType.equalsIgnoreCase("Duck")){
         return new Duck(this.score);
         
      } 
      else if(enemyType.equalsIgnoreCase("Monster")){
          return new Monster(this.score);
        }
      else if(enemyType.equalsIgnoreCase("Wizard")){
          return new Wizard(this.score);
        }
      else if(enemyType.equalsIgnoreCase("HammerBoy")){
          return new HammerBoy(this.score);
        }
         
         return null;
   }   
}


