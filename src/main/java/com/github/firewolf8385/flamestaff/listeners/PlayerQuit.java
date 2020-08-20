package com.github.firewolf8385.flamestaff.listeners;

import com.github.firewolf8385.flamestaff.commands.CommandSpyCMD;
import com.github.firewolf8385.flamestaff.commands.InvisibleCMD;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.potion.PotionEffectType;

public class PlayerQuit implements Listener {
    @EventHandler
    public void onQuit(PlayerQuitEvent e) {
        Player p = e.getPlayer();

        // Remove from all valid Collections.
        InvisibleCMD.getPlayers().remove(p.getUniqueId());
        CommandSpyCMD.getPlayers().remove(p.getUniqueId());

        // Remove invisibility.
        p.removePotionEffect(PotionEffectType.INVISIBILITY);
    }
}
