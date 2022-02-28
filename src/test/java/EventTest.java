import cc.lixou.jvent.Listener;
import org.junit.jupiter.api.Test;

import java.util.function.Consumer;

public class EventTest {

    @Test
    public void test() {
        Listener<ExampleEvent> listener = new Listener<>(exampleEvent -> {
            String myString = exampleEvent.getMyString();
            System.out.println(myString);
        });
    }

}
