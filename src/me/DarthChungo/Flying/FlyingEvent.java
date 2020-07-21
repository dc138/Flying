package me.DarthChungo.Flying;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityToggleGlideEvent;

public class FlyingEvent implements Listener {
    public final Flying plugin;

    public FlyingEvent(Flying plugin) {
        this.plugin = plugin;
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler(priority = EventPriority.HIGH)
    public void onEntityToogleGliding(EntityToggleGlideEvent event) {
        if(this.plugin.fc.players.contains((Player)event.getEntity())) {
            event.setCancelled(true);
        }
    }
}
