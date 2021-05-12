package dev.fps.Cooked.Listeners;

import dev.fps.Cooked.Cooked;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;

public class MobCook implements Listener {
    private Cooked plugin;

    public MobCook(Cooked plugin){
        this.plugin = plugin;
    }

    @EventHandler
    public void mobCook(EntityDeathEvent event){
        FileConfiguration config = plugin.getConfig();
        EntityType entity = event.getEntityType();
        Player player = event.getEntity().getKiller();
        String permission = config.getString("Config.PermissionMob");
        if (player.getGameMode().equals(GameMode.CREATIVE) || (player.getGameMode().equals(GameMode.SPECTATOR)))
            return;
        if (player.getInventory().firstEmpty() == -1)
            return;
        if(player != null && player.hasPermission(permission)){
            event.getDrops().clear();
            if(entity.equals(EntityType.CHICKEN)){
                ItemStack Chicken = new ItemStack(Material.COOKED_CHICKEN, 1);
                ItemStack Feather = new ItemStack(Material.FEATHER, 1);
                player.getInventory().addItem(new ItemStack[]{Feather});
                player.getInventory().addItem(new ItemStack[]{Chicken});
            }
            if(entity.equals(EntityType.COW)){
                ItemStack Beef = new ItemStack(Material.COOKED_BEEF, 1);
                ItemStack Leather = new ItemStack(Material.LEATHER, 2);
                player.getInventory().addItem(new ItemStack[]{Leather});
                player.getInventory().addItem(new ItemStack[]{Beef});
            }
            if(entity.equals(EntityType.PIG)){
                ItemStack Porkchop = new ItemStack(Material.COOKED_PORKCHOP, 1);
                player.getInventory().addItem(new ItemStack[]{Porkchop});
            }
            if(entity.equals(EntityType.RABBIT)){
                ItemStack Rabbit = new ItemStack(Material.COOKED_RABBIT, 1);
                ItemStack Hide = new ItemStack(Material.RABBIT_HIDE, 2);
                player.getInventory().addItem(new ItemStack[]{Rabbit});
                player.getInventory().addItem(new ItemStack[]{Hide});
            }
            if(entity.equals(EntityType.SHEEP)){
                ItemStack Sheep = new ItemStack(Material.COOKED_MUTTON, 1);
                ItemStack Wool = new ItemStack(Material.WHITE_WOOL, 1);
                player.getInventory().addItem(new ItemStack[]{Sheep});
                player.getInventory().addItem(new ItemStack[]{Wool});
            }

        }
    }
}
