package dev.fps.Cooked.Command;

import dev.fps.Cooked.Cooked;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ReloadCMD implements CommandExecutor {
    private Cooked plugin;

    public ReloadCMD(Cooked plugin){this.plugin = plugin;}

    @Override
    public boolean onCommand(CommandSender sender, Command commands, String label, String[] args) {
        Player player = (Player) sender;

        if(args.length > 0){
            if (args[0].equalsIgnoreCase("reload")){
                if (player.hasPermission("Cooked.admin")){
                    plugin.reloadConfig();
                    player.sendMessage(ChatColor.BLUE +"[Cooked] has been reloaded");
                    return true;
                }
            }
        }





        return false;
    }
}
