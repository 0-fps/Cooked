package dev.fps.Cooked;


import dev.fps.Cooked.Command.ReloadCMD;
import dev.fps.Cooked.Listeners.ItemCook;
import dev.fps.Cooked.Listeners.MobCook;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public class Cooked extends JavaPlugin {

    public String ConfigRute;


    public void onEnable(){
        registerListeners();
        registerConfig();
        Bukkit.getConsoleSender().sendMessage("Cooked has been enabled");

    }
    public void onDisable(){
        Bukkit.getConsoleSender().sendMessage("Cooked has been disabled");
    }

    public void registerCommands(){
        this.getCommand("cooked").setExecutor(new ReloadCMD(this));
    }

    public void registerListeners(){
        PluginManager pm = getServer().getPluginManager();
        pm.registerEvents(new ItemCook(this), this);
        pm.registerEvents(new MobCook(this), this);

    }
    public void registerConfig(){
        File config = new File(this.getDataFolder(),"config.yml");
        ConfigRute = config.getPath();
        if(!config.exists()){
            this.getConfig().options().copyDefaults(true);
            saveConfig();
        }
    }
}