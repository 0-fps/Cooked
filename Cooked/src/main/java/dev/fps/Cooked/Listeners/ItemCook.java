package dev.fps.Cooked.Listeners;

import dev.fps.Cooked.Cooked;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.block.Container;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

public class ItemCook implements Listener {

    private Cooked plugin;

    public ItemCook(Cooked plugin){
        this.plugin = plugin;
    }

    @EventHandler
    public void itemCook(BlockBreakEvent event){
        FileConfiguration config = plugin.getConfig();
        Player player = event.getPlayer();
        String permission = config.getString("Config.PermissionItem");
        Material blockbreak = event.getBlock().getType();
        if (player.getGameMode().equals(GameMode.CREATIVE) || (player.getGameMode().equals(GameMode.SPECTATOR)))
            return;
        if (player.getInventory().firstEmpty() == -1)
            return;
        if (event.getBlock().getState() instanceof Container)
            return;

        if(player.hasPermission(permission)){
            if (blockbreak == Material.IRON_ORE) {
                event.getBlock().setType(Material.AIR);
                ItemStack Iron = new ItemStack(Material.IRON_INGOT, 1);
                player.getInventory().addItem(new ItemStack[]{Iron});
            } else if (blockbreak == Material.GOLD_ORE) {
                event.getBlock().setType(Material.AIR);
                ItemStack Gold = new ItemStack(Material.GOLD_INGOT, 1);
                player.getInventory().addItem(new ItemStack[]{Gold});
            } else if (blockbreak == Material.STONE) {
                event.getBlock().setType(Material.AIR);
                ItemStack Stone = new ItemStack(Material.SMOOTH_STONE, 1);
                player.getInventory().addItem(new ItemStack[]{Stone});
            } else if (blockbreak == Material.SAND) {
                event.getBlock().setType(Material.AIR);
                ItemStack Glass = new ItemStack(Material.GLASS, 1);
                player.getInventory().addItem(new ItemStack[]{Glass});
            } else if (blockbreak == Material.COBBLESTONE) {
                event.getBlock().setType(Material.AIR);
                ItemStack Cobble = new ItemStack(Material.STONE, 1);
                player.getInventory().addItem(new ItemStack[]{Cobble});
            } else if (blockbreak == Material.ACACIA_LOG || blockbreak == Material.BIRCH_LOG || blockbreak == Material.DARK_OAK_LOG || blockbreak == Material.JUNGLE_LOG || blockbreak == Material.OAK_LOG) {
                event.getBlock().setType(Material.AIR);
                ItemStack Coal = new ItemStack(Material.CHARCOAL, 1);
                player.getInventory().addItem(new ItemStack[]{Coal});
            }        }
    }















}
