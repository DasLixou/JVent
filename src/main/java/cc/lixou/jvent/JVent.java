package cc.lixou.jvent;

import kotlin.jvm.JvmClassMappingKt;
import kotlin.reflect.KClass;

import java.util.HashMap;

public abstract class JVent {

    private static final HashMap<Class<? extends JVent>, Handler> handlers = new HashMap<>();

    public static <U extends JVent> U call(U event) {
        return getHandler(event.getClass()).call(event);
    }

    public static Handler getHandler(Class<? extends JVent> event) {
        if(!handlers.containsKey(event)) {
            handlers.put(event, new Handler());
        }
        return handlers.get(event);
    }

    public static Handler getHandler(KClass<? extends JVent> event) {
        return getHandler(JvmClassMappingKt.getJavaClass(event));
    }

}
