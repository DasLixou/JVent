import cc.lixou.jvent.Cancellable;
import cc.lixou.jvent.JVent;
import lombok.Getter;
import lombok.Setter;

@Getter
public class ExampleEvent extends JVent implements Cancellable {

    public ExampleEvent(String myString) {
        this.myString = myString;
    }

    private final String myString;
    @Setter
    private boolean cancelled;

    @Override
    public boolean isCancelled() {
        return cancelled;
    }
}
