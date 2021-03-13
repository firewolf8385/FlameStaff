package com.github.firewolf8385.flamestaff.commands;

import com.github.firewolf8385.flamestaff.utils.ChatUtils;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

/**
 * Gets the UUID of a player.
 */
public class UuidCMD extends AbstractCommand {

    /**
     * Registers the Command.
     */
    public UuidCMD() {
        super("uuid", "flamestaff.uuid", true);
    }

    /**
     * Executes the command.
     * @param sender The Command Sender.
     * @param args Arguments of the command.
     */
    public void execute(CommandSender sender, String[] args) {
        if(args.length == 0) {
            ChatUtils.chat(sender, "&c&l(&7!&c&l) &cUsage: /uuid [player]");
        }

        OfflinePlayer t = Bukkit.getOfflinePlayer(args[0]);
        ChatUtils.chat(sender, "&a&l(&7!&a&l) &aUUID of &f" + t.getName() + " &ais &f" + t.getUniqueId() + "&a.");
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(args.length == 0) {
            return false;
        }

        OfflinePlayer t = Bukkit.getOfflinePlayer(args[0]);
        ChatUtils.chat(sender, "&a&l(&7!&a&l) &aUUID of &f" + t.getName() + " &ais &f" + t.getUniqueId() + "&a.");

        return true;
    }
}