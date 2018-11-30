/**
 * Write a description of class personAlive here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PersonAliveState implements iPersonState  
{
    public Person person;
    
    public PersonAliveState(Person person)
    {
        this.person = person;
    }

    public  boolean isAlive()
    {
        return true;
    }
    
    public boolean isDead()
    {
        return false;
    }
    
     
    public void setState()
    {
        person.setState(person.getPersonDeadState());
    }
    
    public void display()
    {
     
    }
}
