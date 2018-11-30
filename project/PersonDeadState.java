/**
 * Write a description of class personDead here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PersonDeadState implements iPersonState
{
    
    public Person person;
    public PersonDeadState(Person person)
    {
        this.person = person;
    }

    public  boolean isAlive()
    {
        return false;
    }
    
    public boolean isDead()
    {
        return true;
    }
    
    public void setState() { 
    
    }
    
    public void display()
    {
       // person.getWorld().addObject(new FinalBanner("gameover1.png"), 500, 125);
    }
}
