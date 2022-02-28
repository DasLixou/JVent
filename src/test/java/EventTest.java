import cc.lixou.jvent.Event;
import cc.lixou.jvent.Listener;
import org.junit.jupiter.api.Test;

public class EventTest {

    @Test
    public void test() {
        Listener<ExampleEvent> listener = new Listener<>(ExampleEvent.class, exampleEvent -> {
            String myString = exampleEvent.getMyString();
            System.out.println(myString);
        });
        listener.subscribe();
        Event.getHandler(ExampleEvent.class).call(new ExampleEvent("YAY!"));
    }

}
