package de.lixou.jvent.example;

import cc.lixou.jvent.JVent;
import de.lixou.jvent.example.events.ItemDropEvent;
import de.lixou.jvent.example.listener.ItemListener;
import de.lixou.jvent.example.types.Item;
import de.lixou.jvent.example.types.Player;

public class Main {

    public static void main(String[] args) {
        new ItemListener();
        Item item = new Item("Stick");
        Player player = new Player("coolUser");
        ItemDropEvent event = JVent.getHandler(ItemDropEvent.class).call(new ItemDropEvent(item, player));
        System.out.println(event.isCancelled() ? "Event was cancelled" : "Event wasn't cancelled");
    }

}
