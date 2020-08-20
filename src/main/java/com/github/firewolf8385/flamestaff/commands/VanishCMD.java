package com.github.firewolf8385.flamestaff.commands;

import com.github.firewolf8385.flamestaff.FlameStaff;
import com.github.firewolf8385.flamestaff.utils.ChatUtils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Collection;
import java.util.HashSet;
import java.util.UUID;

public class VanishCMD implements CommandExecutor {
    private static Collection<UUID> players = new HashSet<>();

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(!(sender instanceof Player)) {
            ChatUtils.chat(sender, "&c&l(&7!&c&l) &cOnly players can use that command!!");
            return true;
        }

        Player p = (Player) sender;

        if(getPlayers().contains(p.getUniqueId())) {
            getPlayers().remove(p.getUniqueId());

            for(Player player : Bukkit.getOnlinePlayers()) {
                player.showPlayer(FlameStaff.getPlugin(), p);
            }

            ChatUtils.chat(p, "&a&l(&7!&a&l) &aYou are no longer vanished.");
        }
        else {
            getPlayers().add(p.getUniqueId());

            for(Player player : Bukkit.getOnlinePlayers()) {
                player.hidePlayer(FlameStaff.getPlugin(), p);
            }

            ChatUtils.chat(p, "&a&l(&7!&a&l) &aYou are now vanished.");
        }

        return true;
    }

    public static Collection<UUID> getPlayers() {
        return players;
    }
}
