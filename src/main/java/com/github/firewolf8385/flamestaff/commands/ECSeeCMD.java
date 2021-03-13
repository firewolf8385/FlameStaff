package com.github.firewolf8385.flamestaff.commands;

import com.github.firewolf8385.flamestaff.utils.ChatUtils;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * View a player's enderchest.
 */
public class ECSeeCMD extends AbstractCommand {

    /**
     * Registers the command.
     */
    public ECSeeCMD() {
        super("ecsee", "flamestaff.ecsee", false);
    }

    /**
     * Executes the command.
     * @param sender The Command Sender.
     * @param args Arguments of the command.
     */
    public void execute(CommandSender sender, String[] args) {
        if(args.length == 0) {
            ChatUtils.chat(sender, "&c&l(&7!&c&l) &cUsage: /ecsee [player]");
            return;
        }

        Player t = Bukkit.getPlayer(args[0]);

        if(t == null) {
            ChatUtils.chat(sender, "&c&l(&7!&c&l) &cThat player is not online.");
            return;
        }

        Player p = (Player) sender;
        p.openInventory(t.getEnderChest());
    }
}
