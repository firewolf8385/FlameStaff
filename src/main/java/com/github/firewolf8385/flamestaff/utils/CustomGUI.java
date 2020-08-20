package com.github.firewolf8385.flamestaff.utils;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Represents an interactive menu using chest infaces.
 */
public abstract class CustomGUI {
    private static Map<UUID, CustomGUI> inventories = new HashMap<>();
    private static Map<UUID, UUID> openInventories = new HashMap<>();

    private Inventory inventory;
    private UUID uuid;
    private Map<Integer, ClickAction> actions;

    /**
     * Creates a CustomGUI
     * @param size Size of the GUI
     * @param name Name of the GUI
     */
    public CustomGUI(int size, String name) {
        uuid = UUID.randomUUID();
        inventory = Bukkit.createInventory(null, size, ChatUtils.translate(name));
        actions = new HashMap<>();

        inventories.put(uuid, this);
    }

    /**
     * Gets all GUIs
     * @return Map of all GUIs
     */
    public static Map<UUID, CustomGUI> getInventories() {
        return inventories;
    }

    /**
     * Gets all open GUIs
     * @return Map of open GUIs
     */
    public static Map<UUID, UUID> getOpenInventories() {
        return openInventories;
    }

    /**
     * Deletes the GUI
     */
    public void delete() {
        inventories.remove(getUuid());
    }

    /**
     * Get click actions of the GUI
     * @return all actions in the GUI
     */
    public Map<Integer, ClickAction> getActions() {
        return actions;
    }

    /**
     * Get the Inventory of the GUI
     * @return Inventory
     */
    public Inventory getInventory() {
        return inventory;
    }

    /**
     * Get the UUID of the GUI
     * @return UUID of GUI
     */
    public UUID getUuid() {
        return uuid;
    }

    /**
     * Set an item in the GUI with a ClickAction
     * @param slot Slot of the Item
     * @param item Item to set
     * @param action Click action
     */
    public void setItem(int slot, ItemStack item, ClickAction action) {
        inventory.setItem(slot, item);

        if(actions != null)
            actions.put(slot, action);
    }

    /**
     * Set an item in the GUI without a ClickAction
     * @param slot Slot of the Item
     * @param stack Item to set
     */
    public void setItem(int slot, ItemStack stack) {
        setItem(slot, stack, null);
    }

    /**
     * Open the GUI for a player
     * @param p Player to open GUI for.
     */
    public void open(Player p) {
        p.openInventory(inventory);
        openInventories.put(p.getUniqueId(), getUuid());
    }

    /**
     * Action to happen when an item is clicked.
     */
    public interface ClickAction {
        void click(Player player);
    }
}