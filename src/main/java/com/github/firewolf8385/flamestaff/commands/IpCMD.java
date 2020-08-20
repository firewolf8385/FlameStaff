package com.github.firewolf8385.flamestaff.commands;

import com.github.firewolf8385.flamestaff.utils.ChatUtils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class IpCMD implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(args.length == 0) {
            return false;
        }

        Player t = Bukkit.getPlayer(args[0]);

        if(t == null) {
            ChatUtils.chat(sender, "&c&l(&7!&c&l) &cThat player is not online.");
            return true;
        }

        String ip = t.getAddress().toString();
        ChatUtils.chat(sender, "&a&l(&7!&a&l) &aip of &f" + t.getName() + " &ais &f" + ip + "&a.");

        return true;
    }
}
