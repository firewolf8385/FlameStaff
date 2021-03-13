package com.github.firewolf8385.flamestaff.commands;

import com.github.firewolf8385.flamestaff.utils.ChatUtils;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Collection;
import java.util.HashSet;
import java.util.UUID;

/**
 * Allows a player to spy on commands.
 */
public class CommandSpyCMD extends AbstractCommand {
    private static Collection<UUID> players = new HashSet<>();

    /**
     * Registers the command.
     */
    public CommandSpyCMD() {
        super("commandspy", "flamestaff.commandspy", false);
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
            ChatUtils.chat(p, "&a&l(&7!&a&l) &aYou are no longer spying on commands.");
        }
        else {
            getPlayers().add(p.getUniqueId());
            ChatUtils.chat(p, "&a&l(&7!&a&l) &aYou are now spying on commands.");
        }
    }

    public static Collection<UUID> getPlayers() {
        return players;
    }
}