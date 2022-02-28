package cc.lixou.jvent;

import java.util.function.Consumer;

@FunctionalInterface
public interface Listener<T extends Event> extends Consumer<T> {

}
