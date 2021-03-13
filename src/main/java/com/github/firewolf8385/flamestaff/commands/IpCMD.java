package com.github.firewolf8385.flamestaff.commands;

import com.github.firewolf8385.flamestaff.utils.ChatUtils;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * Get the ip of a player.
 */
public class IpCMD extends AbstractCommand {

    /**
     * Register the command.
     */
    public IpCMD() {
        super("ip", "flamestaff.ip", true);
    }

    /**
     * Execute the command.
     * @param sender The Command Sender.
     * @param args Arguments of the command.
     */
    public void execute(CommandSender sender, String[] args) {
        Player t = Bukkit.getPlayer(args[0]);

        if(t == null) {
            ChatUtils.chat(sender, "&c&l(&7!&c&l) &cThat player is not online.");
            return;
        }

        String ip = t.getAddress().toString();
        ChatUtils.chat(sender, "&a&l(&7!&a&l) &aip of &f" + t.getName() + " &ais &f" + ip + "&a.");
    }
}