package com.github.firewolf8385.flamestaff.listeners;

import com.github.firewolf8385.flamestaff.FlameStaff;
import com.github.firewolf8385.flamestaff.commands.VanishCMD;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.UUID;

public class PlayerJoin implements Listener {
    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();

        for(UUID u : VanishCMD.getPlayers()) {
            p.hidePlayer(FlameStaff.getPlugin(), Bukkit.getPlayer(u));
        }
    }
}
