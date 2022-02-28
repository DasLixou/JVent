import cc.lixou.jvent.Listener;
import org.junit.jupiter.api.Test;

public class EventTest {

    @Test
    public void test() {
        Listener<ExampleEvent> listener = event -> {
            System.out.println(event.getMyString());
        };
    }

}
