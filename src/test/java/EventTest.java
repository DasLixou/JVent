import cc.lixou.jvent.EventPriority;
import cc.lixou.jvent.JVent;
import cc.lixou.jvent.Listener;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.concurrent.atomic.AtomicReference;

public class EventTest {

    @Test
    public void test() {
        AtomicReference<String> value = new AtomicReference<>("");
        String wanted = "Yes it works! :D";

        new Listener(ExampleEvent.class, exampleEvent -> {
            value.set("This is before the latest");
            exampleEvent.setCancelled(true);
        }, true);

        new Listener(ExampleEvent.class, exampleEvent -> {
            value.set(exampleEvent.getMyString());
            exampleEvent.setCancelled(true);
        }, true, EventPriority.LAST);

        ExampleEvent result = JVent.getHandler(ExampleEvent.class).call(new ExampleEvent(wanted));

        assertEquals(value.get(), wanted);
        assertEquals(result.isCancelled(), true);
    }

}
