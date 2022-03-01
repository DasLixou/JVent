package de.lixou.jvent.example.events;

import cc.lixou.jvent.Cancellable;
import cc.lixou.jvent.JVent;
import de.lixou.jvent.example.types.Item;
import de.lixou.jvent.example.types.Player;

public class ItemDropEvent extends JVent implements Cancellable {

    private Player player;
    private Item item;
    private boolean cancelled;

    public ItemDropEvent(Item item, Player player) {
        this.item = item;
        this.player = player;
    }

    public Item getItem() { return item; }
    public void setItem(Item item) { this.item = item; }

    public Player getPlayer() { return player; }
    public void setPlayer(Player player) { this.player = player; }

    @Override
    public boolean isCancelled() {
        return cancelled;
    }

    @Override
    public void setCancelled(boolean cancel) {
        this.cancelled = cancel;
    }
}
