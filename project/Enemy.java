import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Enemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public  abstract class Enemy extends Actor
{
    public abstract void move();
    public abstract void checkIfKicked();
    public abstract boolean knockedOver();
    public abstract void checkIfHit();
    public abstract void getKnockedOver();
    public abstract boolean onGround();
    public abstract void teleport();
}