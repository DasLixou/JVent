package cc.lixou.jvent;

import java.util.function.Consumer;

public class Listener<T extends Event> {

    private final Consumer<T> consumer;

    public Listener(Consumer<T> consumer) {
        this.consumer = consumer;
    }

}
