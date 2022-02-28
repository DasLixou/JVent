import cc.lixou.jvent.Event;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class ExampleEvent extends Event {

    @Getter
    private String myString;

}
