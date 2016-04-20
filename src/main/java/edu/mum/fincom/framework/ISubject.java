package edu.mum.fincom.framework;

/**
 * @author Issa Fikadu
 */
public interface ISubject {
    void attach(IObserver observer);
    void notifyObservers();

}
