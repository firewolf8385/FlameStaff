package com.github.firewolf8385.flamestaff.listeners;

import com.github.firewolf8385.flamestaff.commands.CommandSpyCMD;
import com.github.firewolf8385.flamestaff.utils.ChatUtils;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import java.util.UUID;

public class PlayerCommandPreprocess implements Listener {
    @EventHandler
    public void onCommandPreprocess(PlayerCommandPreprocessEvent e) {
        Player p = e.getPlayer();
        String cmd = e.getMessage();

        if(p.hasPermission("flamestaff.commandspy.exempt")) {
            return;
        }

        for(UUID u : CommandSpyCMD.getPlayers()) {
            if(p.getUniqueId().equals(u)) {
                continue;
            }
            ChatUtils.chat(Bukkit.getPlayer(u), "&7[&aSpy&7] &a" + p.getName() + ": &f" + cmd);
        }
    }
}
