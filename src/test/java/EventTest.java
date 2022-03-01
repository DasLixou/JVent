import cc.lixou.jvent.Event;
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
            value.set(exampleEvent.getMyString());
        }, true);

        ExampleEvent result = Event.getHandler(ExampleEvent.class).call(new ExampleEvent(wanted));

        assertEquals(value.get(), wanted);
    }

}
