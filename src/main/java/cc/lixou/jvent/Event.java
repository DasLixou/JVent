package cc.lixou.jvent;

import java.util.HashMap;

public abstract class Event {

    private static final HashMap<Class<? extends Event>, Handler> handlers = new HashMap<>();

    public static Handler getHandler(Class<? extends Event> event) {
        if(!handlers.containsKey(event)) {
            handlers.put(event, new Handler());
        }
        return handlers.get(event);
    }

}
