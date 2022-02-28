package cc.lixou.jvent;

import java.util.ArrayList;

public class Handler {

    private final ArrayList<Listener<? extends Event>> listeners;

    public Handler() {
        listeners = new ArrayList<>();
    }

    public void call(Event event) {
        listeners.forEach(listener -> listener.call(event));
    }

    public void subscribe(Listener<? extends Event> listener) {
        if(listeners.contains(listener)) { return; }
        listeners.add(listener);
    }

    public void unsubscribe(Listener<? extends Event> listener) {
        if(!listeners.contains(listener)) { return; }
        listeners.remove(listener);
    }

}
