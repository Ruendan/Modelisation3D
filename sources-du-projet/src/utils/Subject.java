package utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Extendable class to convert a class into a Subject
 * <p>This class is used to convert any other class into a Subject from the Observer Pattern</p>
 * @author Groupe G1
 */
public abstract class Subject {
    protected List<Observer> attached;

    public Subject() {
        attached = new ArrayList<>();
    }

    public void attach(Observer obs) {
        if (! attached.contains( obs)) {
            attached.add(obs);
        }
    }

    public void detach(Observer obs) {
        if (attached.contains( obs)) {
            attached.remove(obs);
        }
    }

    public void notifyObservers() {
        for (Observer o : attached) {
            o.update(this);
        }
    }


    public void notifyObservers(Object data) {
        for (Observer o : attached) {
            o.update(this, data);
        }
    }

}
