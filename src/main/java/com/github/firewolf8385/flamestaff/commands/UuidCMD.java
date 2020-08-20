package com.github.firewolf8385.flamestaff.commands;

import com.github.firewolf8385.flamestaff.utils.ChatUtils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class UuidCMD implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(args.length == 0) {
            ChatUtils.chat(sender, "&c&l(&7!&c&l) &cUsage: /uuid [player]");
            return true;
        }

        Player t = Bukkit.getPlayer(args[0]);

        if(t == null) {
            ChatUtils.chat(sender, "&c&l(&7!&c&l) &cThat player is not online.");
            return true;
        }

        ChatUtils.chat(sender, "&a&l(&7!&a&l) &aUUID of &f" + t.getName() + " &ais &f" + t.getUniqueId() + "&a.");

        return true;
    }
}