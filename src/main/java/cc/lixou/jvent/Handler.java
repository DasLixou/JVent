package cc.lixou.jvent;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;

public class Handler {

    private final ArrayList<Listener> listeners;

    public Handler() {
        listeners = new ArrayList<>();
    }

    public <U extends Event> U call(U event) {
        AtomicReference<U> result = new AtomicReference<>(event);
        listeners.forEach(listener -> result.set(listener.call(result.get())));
        return result.get();
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
