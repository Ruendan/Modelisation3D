package utils;

import java.util.ArrayList;
import java.util.List;

public class Subject {
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
        for (final Observer o : attached) {
            o.update(this);
        }
    }


    public void notifyObservers(Object data) {
        for (final Observer o : attached) {
            o.update(this, data);
        }
    }

}
