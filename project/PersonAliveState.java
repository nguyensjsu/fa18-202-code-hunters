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
     //   person.getWorld().addObject(new FinalBanner("youwin.png"), 500, 125);
    }
}
