package cc.lixou.jvent;

import java.util.function.Consumer;

public class Listener<T extends Event> {

    private final Consumer<T> consumer;
    private final Class<T> eventClass;

    public Listener(Class<T> eventClass, Consumer<T> consumer) {
        this.consumer = consumer;
        this.eventClass = eventClass;
    }

    @SuppressWarnings("unchecked")
    public void call(Event event) {
        if(event != null) {
            this.consumer.accept((T)event);
        }
    }

    public void subscribe() {
        Event.getHandler(eventClass).subscribe(this);
    }

    public void unsubscribe() {
        Event.getHandler(eventClass).unsubscribe(this);
    }

}
