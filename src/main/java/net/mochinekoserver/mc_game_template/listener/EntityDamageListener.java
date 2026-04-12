package net.mochinekoserver.mc_game_template.listener;

import org.bukkit.entity.Entity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class EntityDamageListener implements Listener {

    @EventHandler
    public void onEntityDamageByEntity(EntityDamageByEntityEvent event) {
        var damage = event.getEntity(); //ダメージを受けた人
        var damager = event.getDamager(); //ダメージを与えた人
    }
}
