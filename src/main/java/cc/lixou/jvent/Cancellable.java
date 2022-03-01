package cc.lixou.jvent;

public interface Cancellable {

    boolean isCancelled();

    void setCancelled(boolean cancel);

}
