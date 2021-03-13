package com.github.firewolf8385.flamestaff.commands;

import com.github.firewolf8385.flamestaff.FlameStaff;
import com.github.firewolf8385.flamestaff.utils.ChatUtils;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Collection;
import java.util.HashSet;
import java.util.UUID;

/**
 * Hides a player from the rest of the server.
 */
public class VanishCMD extends AbstractCommand {
    private static Collection<UUID> players = new HashSet<>();

    /**
     * Registers the command.
     */
    public VanishCMD() {
        super("vanish", "flamestaff.vanish", false);
    }

    /**
     * Executes the command.
     * @param sender The Command Sender.
     * @param args Arguments of the command.
     */
    public void execute(CommandSender sender, String[] args) {
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
    }

    public static Collection<UUID> getPlayers() {
        return players;
    }
}
