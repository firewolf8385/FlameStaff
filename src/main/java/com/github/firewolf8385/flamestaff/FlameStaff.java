package com.github.firewolf8385.flamestaff;

import com.github.firewolf8385.flamestaff.commands.*;
import com.github.firewolf8385.flamestaff.listeners.PlayerCommandPreprocess;
import com.github.firewolf8385.flamestaff.listeners.PlayerJoin;
import com.github.firewolf8385.flamestaff.listeners.PlayerQuit;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public final class FlameStaff extends JavaPlugin {
    private static Plugin plugin;

    @Override
    public void onEnable() {
        // Plugin startup logic
        plugin = this;
        registerCommands();
        registerListeners();

        // Registers metrics.
        new MetricsLite(this, 8603);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        plugin = null;
    }

    public static Plugin getPlugin() {
        return plugin;
    }

    private void registerCommands() {
        getCommand("commandspy").setExecutor(new CommandSpyCMD());
        getCommand("ecsee").setExecutor(new ECSeeCMD());
        getCommand("invisibile").setExecutor(new InvisibleCMD());
        getCommand("invsee").setExecutor(new InvSeeCMD());
        getCommand("ip").setExecutor(new IpCMD());
        getCommand("uuid").setExecutor(new UuidCMD());
        getCommand("vanish").setExecutor(new VanishCMD());
    }

    private void registerListeners() {
        Bukkit.getPluginManager().registerEvents(new PlayerCommandPreprocess(), this);
        Bukkit.getPluginManager().registerEvents(new PlayerJoin(), this);
        Bukkit.getPluginManager().registerEvents(new PlayerQuit(), this);
    }
}