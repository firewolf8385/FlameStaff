package com.github.firewolf8385.flamestaff.commands;

import com.github.firewolf8385.flamestaff.utils.ChatUtils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ECSeeCMD implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(!(sender instanceof Player)) {
            ChatUtils.chat(sender, "&c&l(&7!&c&l) &cOnly players can use that command!!");
            return true;
        }

        if(args.length == 0) {
            ChatUtils.chat(sender, "&c&l(&7!&c&l) &cUsage: /ecsee [player]");
            return true;
        }

        Player t = Bukkit.getPlayer(args[0]);

        if(t == null) {
            ChatUtils.chat(sender, "&c&l(&7!&c&l) &cThat player is not online.");
            return true;
        }

        Player p = (Player) sender;
        p.openInventory(t.getEnderChest());

        return true;
    }
}
