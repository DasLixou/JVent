package cc.lixou.jvent;

import kotlin.jvm.JvmClassMappingKt;
import kotlin.reflect.KClass;
import lombok.Getter;

import java.util.function.Consumer;

public class Listener {

    @SuppressWarnings("All")
    private final Consumer consumer;
    private final Class<? extends JVent> eventClass;

    private boolean subscribed = false;
    @Getter private int priority = EventPriority.NORMAL.ordinal();

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
     */
    public <U extends JVent> Listener(KClass<U> eventClass, Consumer<U> consumer) {
        this(JvmClassMappingKt.getJavaClass(eventClass), consumer);
    }

    /**
     * Setting the Priority
     * @param priority Integer for saying in which order the listeners should get called (0 gets called first)
     * @return Returns the Listener itself
     */
    public Listener setPriority(int priority) { this.priority = priority; return this; }
    /**
     * Setting the Priority
     * @param priority Enum for saying in which order the listeners should get called (first enum element gets called first)
     * @return Returns the Listener itself
     */
    public Listener setPriority(Enum<?> priority) { return setPriority(priority.ordinal()); }

    @SuppressWarnings("unchecked")
    public <U extends JVent> U call(U event) {
        if(event != null) {
            this.consumer.accept(event);
        }
        return event;
    }

    /**
     * Subscribes the Listener with DefaultPriority: NORMAL (= 3)
     */
    public void subscribe() { subscribe(EventPriority.NORMAL); }
    /**
     * Subscribes the Listener with Custom Enum Priority
     * @param e NOTE: In enums has the first value more priority than the last value
     */
    public void subscribe(Enum<?> e) { subscribe(e.ordinal()); }
    /**
     * Subscribes the Listener with Custom Integer Priority
     * @param priority NOTE: 0 is the first called, then greater number get called next.
     */
    public void subscribe(int priority) {
        JVent.getHandler(eventClass).subscribe(this, priority);
        this.priority = priority;
    }

    /**
     * Unsubcribes the Listener
     */
    public void unsubscribe() {
        if(this.priority == -1) { return; }
        JVent.getHandler(eventClass).unsubscribe(this, this.priority);
    }

}
