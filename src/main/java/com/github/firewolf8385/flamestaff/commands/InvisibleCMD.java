package com.github.firewolf8385.flamestaff.commands;

import com.github.firewolf8385.flamestaff.utils.ChatUtils;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.Collection;
import java.util.HashSet;
import java.util.UUID;

/**
 * Give yourself invisibility.
 */
public class InvisibleCMD extends AbstractCommand {
    private static Collection<UUID> players = new HashSet<>();

    /**
     * Registers the command.
     */
    public InvisibleCMD() {
        super("invisible", "flamestaff.invisible", false);
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
            p.removePotionEffect(PotionEffectType.INVISIBILITY);
            ChatUtils.chat(p, "&a&l(&7!&a&l) &aYou are no longer invisible.");
        }
        else {
            getPlayers().add(p.getUniqueId());
            p.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, Integer.MAX_VALUE,0, false, false));
            ChatUtils.chat(p, "&a&l(&7!&a&l) &aYou are now invisible.");
        }
    }

    public static Collection<UUID> getPlayers() {
        return players;
    }
}