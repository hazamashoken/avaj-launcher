package com.tliangso.Tower;

import java.util.ArrayList;
import java.util.List;

import com.tliangso.Flyable.Flyable;

public class Tower {
    private List<Flyable> observers = new ArrayList<Flyable>();
    
    public void register(Flyable p_flyable) {
        this.observers.add(p_flyable);
    };

    public void unregister(Flyable p_flyable) throws UnregisterFlyable {
        int index = this.observers.indexOf(p_flyable);
        if (index < 0) {
            throw new UnregisterFlyable();
        }
        this.observers.remove(index);
    };

    protected void conditionChanged() {
        this.observers.forEach((flyable) -> flyable.updateConditions());
    };

    public class UnregisterFlyable extends Exception {
        private UnregisterFlyable () {
            super("Unregister flyable detected !");
        }
    }

}
