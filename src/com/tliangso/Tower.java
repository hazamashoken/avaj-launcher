package com.tliangso;

import java.util.*;

public class Tower {
    private List<Flyable> observers = new ArrayList<Flyable>();

    public void register(Flyable p_flyable) {
        this.observers.add(p_flyable);
    };

    public void unregister(Flyable p_flyable) {
        Integer index = this.observers.indexOf(p_flyable);
        if (index < 0) {
            return;
        }
        this.observers.remove(index.intValue());
    };

    protected void conditionChanged() {
        for (int i = 0; i < observers.size(); i++) {
            observers.get(i).updateConditions();
        }

    };

}
