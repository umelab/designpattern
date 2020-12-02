package umelab.designpattern.observer;

import java.util.ArrayList;
import java.util.Iterator;

public abstract class AbstractSubject {

    /**
     * array list for observer object
     */
    private ArrayList<IObserver> listObs = new ArrayList<IObserver>();

    /**
     * register IObserver obj
     * @param observer specified I Observer obj
     */
    public void addObserver(IObserver observer) {
        listObs.add(observer);
    }

    /**
     * remove IObserver obj
     * @param observer specified IObserver obj
     */
    public void removeObserver(IObserver observer) {
        listObs.remove(observer);
    }


    /**
     * notify all observers and call their update method
     */
    protected void nofityObservers() {
        Iterator<IObserver> iterator = listObs.iterator();
        while(iterator.hasNext()) {
            IObserver obs = (IObserver) iterator.next();
            obs.update(this);
        }
    }

    public abstract int getStatus();
}