package de.lixou.jvent.example.listener;

import cc.lixou.jvent.Listener;
import de.lixou.jvent.example.events.ItemDropEvent;

public class ItemListener {

    public static final boolean AUTO_SUBSCRIBE = true;

    public ItemListener() {
        new Listener(ItemDropEvent.class, this::onItemDrop, AUTO_SUBSCRIBE);
    }

    public void onItemDrop(ItemDropEvent e) {
        System.out.println(e.getItem().name() + " was dropped by " + e.getPlayer().username());
        if(e.getPlayer().username().equalsIgnoreCase("coolUser")) {
            e.setCancelled(true);
        }
    }

}
