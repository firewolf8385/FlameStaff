package com.github.firewolf8385.flamestaff;

import com.github.firewolf8385.flamestaff.commands.InvisibleCMD;
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
        getCommand("invisibile").setExecutor(new InvisibleCMD());
    }

    private void registerListeners() {
        Bukkit.getPluginManager().registerEvents(new PlayerQuit(), this);
    }
}