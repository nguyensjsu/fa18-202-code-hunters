/**
 * Write a description of class Subject here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public interface Subject
{
    public abstract void attach(Observer obj);
    public abstract void detach(Observer obj);
    public abstract void notifyObservers();
}
