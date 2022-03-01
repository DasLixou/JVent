package cc.lixou.jvent;

import java.util.ArrayList;

public class Handler {

    private final ArrayList<Listener> listeners;

    public Handler() {
        listeners = new ArrayList<>();
    }

    public void call(Event event) {
        listeners.forEach(listener -> listener.call(event));
    }

    public void subscribe(Listener listener) {
        if(listeners.contains(listener)) { return; }
        listeners.add(listener);
    }

    public void unsubscribe(Listener listener) {
        if(!listeners.contains(listener)) { return; }
        listeners.remove(listener);
    }

}
