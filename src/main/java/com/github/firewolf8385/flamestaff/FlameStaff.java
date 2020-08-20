package com.github.firewolf8385.flamestaff;

import com.github.firewolf8385.flamestaff.commands.CommandSpyCMD;
import com.github.firewolf8385.flamestaff.commands.InvisibleCMD;
import com.github.firewolf8385.flamestaff.listeners.PlayerCommandPreprocess;
import com.github.firewolf8385.flamestaff.listeners.PlayerQuit;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class FlameStaff extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        registerCommands();
        registerListeners();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    private void registerCommands() {
        getCommand("commandspy").setExecutor(new CommandSpyCMD());
        getCommand("invisibile").setExecutor(new InvisibleCMD());
    }

    private void registerListeners() {
        Bukkit.getPluginManager().registerEvents(new PlayerCommandPreprocess(), this);
        Bukkit.getPluginManager().registerEvents(new PlayerQuit(), this);
    }
}