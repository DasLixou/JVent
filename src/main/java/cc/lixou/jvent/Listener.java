package cc.lixou.jvent;

import kotlin.jvm.JvmClassMappingKt;
import kotlin.reflect.KClass;
import lombok.Getter;

import java.util.function.Consumer;

public class Listener {

    @SuppressWarnings("All")
    private final Consumer consumer;
    private final Class<?> eventClass;

    @Getter private boolean subscribed = false;
    @Getter
    private int priority = EventPriority.NORMAL.ordinal();
    private int oldPriority = -1;

    /**
     * @param eventClass The Class of the Event you want to listen
     * @param consumer   Consumer for the code that executes when event gets fired
     */
    public <U> Listener(Class<U> eventClass, Consumer<U> consumer) {
        this.consumer = consumer;
        this.eventClass = eventClass;
    }

    /**
     * @param eventClass The Class of the Event you want to listen
     * @param consumer   Consumer for the code that executes when event gets fired
     */
    public <U> Listener(KClass<U> eventClass, Consumer<U> consumer) {
        this(JvmClassMappingKt.getJavaClass(eventClass), consumer);
    }

    /**
     * Setting the Priority
     *
     * @param priority Integer for saying in which order the listeners should get called (0 gets called first)
     * @return Returns the Listener itself
     */
    public Listener setPriority(int priority) {
        this.priority = priority;
        return this;
    }

    /**
     * Setting the Priority
     *
     * @param priority Enum for saying in which order the listeners should get called (first enum element gets called first)
     * @return Returns the Listener itself
     */
    public Listener setPriority(Enum<?> priority) {
        return setPriority(priority.ordinal());
    }

    @SuppressWarnings("unchecked")
    public <U> U call(U event) {
        if (event != null) {
            this.consumer.accept(event);
        }
        return event;
    }

    /**
     * Subscribes or unsubscribes the Listener
     * @param shouldSubscribe When true, subscribes; When false, unsubscribes
     */
    public Listener subscribe(boolean shouldSubscribe) {
        this.subscribed = shouldSubscribe;
        if (shouldSubscribe) {
            oldPriority = priority;
            JVent.getHandler(eventClass).subscribe(this, priority);
        } else {
            JVent.getHandler(eventClass).unsubscribe(this, oldPriority);
        }

        return this;
    }

    /**
     *  Resubscribes the Listener for example updating the Event Priority
     */
    public Listener resubscribe() {
        subscribe(false);
        subscribe(true);

        return this;
    }

}
