package me.kelopy.acrobatic;

import me.kelopy.acrobatic.commands.ping;
import me.kelopy.acrobatic.events.importantEvents;
import org.bukkit.plugin.java.JavaPlugin;

public final class Acrobatic extends JavaPlugin {

    @Override
    public void onEnable() {
        System.out.println("Acrobatic Lands official plugin has started up.");

        getConfig().options().copyDefaults();
        saveDefaultConfig();

        this.getCommand("ping").setExecutor(new ping(this));
        this.getServer().getPluginManager().registerEvents(new importantEvents(this), this);
    }

    @Override
    public void onDisable() {
        System.out.println("Acrobatic Lands official plugin has shut down.");
    }
}
