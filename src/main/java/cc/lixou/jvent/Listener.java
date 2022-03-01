package cc.lixou.jvent;

import java.util.function.Consumer;

public class Listener {

    @SuppressWarnings("All")
    private final Consumer consumer;
    private final Class<? extends JVent> eventClass;

    /**
     * @param eventClass The Class of the Event you want to listen
     * @param consumer Consumer for the code that executes when event gets fired
     */
    public <U extends JVent> Listener(Class<U> eventClass, Consumer<U> consumer) {
        this.consumer = consumer;
        this.eventClass = eventClass;
    }

    /**
     * @param eventClass The Class of the Event you want to listen
     * @param consumer Consumer for the code that executes when event gets fired
     * @param autoSubscribe When true, the event will automaticly get subscribed
     */
    public <U extends JVent> Listener(Class<U> eventClass, Consumer<U> consumer, boolean autoSubscribe) {
        this(eventClass, consumer);
        if(autoSubscribe) {
            subscribe();
        }
    }

    @SuppressWarnings("unchecked")
    public <U extends JVent> U call(U event) {
        if(event != null) {
            this.consumer.accept(event);
        }
        return event;
    }

    public void subscribe() {
        JVent.getHandler(eventClass).subscribe(this);
    }

    public void unsubscribe() {
        JVent.getHandler(eventClass).unsubscribe(this);
    }

}
