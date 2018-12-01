import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Princess here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Princess extends Actor
{
    /**
     * Act - do whatever the Princess wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public World world;
     public Princess(World w)
    {
        world = w;
    }
    public void act() 
    {
        checkIfWin();
    }
    private void checkIfWin(){
        Actor person = getOneIntersectingObject(Person.class);
        if(person != null){
            Greenfoot.setWorld(new WinWorld());
        }
    }
}
