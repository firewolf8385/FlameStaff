package com.github.firewolf8385.flamestaff.commands;

import com.github.firewolf8385.flamestaff.utils.ChatUtils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class InvSeeCMD implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(!(sender instanceof Player)) {
            return false;
        }

        if(args.length == 0) {
            ChatUtils.chat(sender, "&c&l(&7!&c&l) &cUsage: /invsee [player]");
            return true;
        }

        Player t = Bukkit.getPlayer(args[0]);

        if(t == null) {
            ChatUtils.chat(sender, "&c&l(&7!&c&l) &cThat player is not online.");
            return true;
        }

        Player p = (Player) sender;
        p.openInventory(t.getInventory());

        return true;
    }
}
