import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Block here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Block extends Platform
{
    private static int timer;
    private boolean normal = true;
    private boolean direct = false;
    private final int TIMERSET = 1100;
    /**
     * act - runs the time method
     */
    public void act()
    {
        time();
    }
    
    /**
     * normal - returns whether the block is in a normal state
     */
    public boolean normal()
    {
        return normal;
    }

    /**
     * time - runs a timer and sets the image based on that
     */
    private void time()
    {
        if(timer == 0)
        {            
            setImage("marioBlock.png"); 
            resetOriginalLocation();
            normal = true;
        }
        else
            timer--;
    }

    /**
     * resetOriginalLocation - moves the block back down after it has been hit
     */
    private void resetOriginalLocation()
    {
        if(!normal && direct)
        {
            setLocation(getX(), getY() + 7);
        }
        else if(!normal && !direct)
        setLocation(getX(), getY() + 3);
    }

    /**
     * activateOthers - makes the blocks to the right and left of it slant up
     */
    
    public void activateOthers()
    {
        Block toLeft = (Block)getOneObjectAtOffset(7, 0, Block.class);
        if(toLeft != null)
            toLeft.leftHit();
        //toLeft.setImage("bumpedBrickEdge1.png");

        Block toRight = (Block)getOneObjectAtOffset(-7, 0, Block.class);
        if(toRight != null)
            toRight.rightHit();
        //toRight.setImage("bumpedBrickEdge0.png");
    }

    /**
     * directHit() - moves the block up, sets the image, and sets the state to not normal
     */
    public void directHit()
    {
        timer = TIMERSET;
        normal = false;
        direct = true;
        activateOthers();
        setLocation(getX(), getY() - 7);

        setImage("curvedBump0.png");
    }

    /**
     * leftHit - sets the image and moves it up, sets the state to not normal
     */
    public void leftHit()
    {
        timer = TIMERSET;
        normal = false;
        direct = false;
        setLocation(getX(), getY() - 3);
        setImage("bumpedBrickEdge0.png");
    }

    /**
     * rightHit - sets the image, moves it up, sets the state to not normal
     */
    public void rightHit()
    {
        timer = TIMERSET;
        normal = false;
        direct = false;
        setLocation(getX(), getY() - 3);
        setImage("bumpedBrickEdge1.png");
    }

}
