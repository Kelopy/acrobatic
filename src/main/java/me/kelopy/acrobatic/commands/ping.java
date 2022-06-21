package me.kelopy.acrobatic.commands;

import me.kelopy.acrobatic.Acrobatic;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ping implements CommandExecutor {

    final Acrobatic plugin;

    public ping(Acrobatic plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (sender instanceof Player p){
            p.sendMessage(ChatColor.translateAlternateColorCodes('&', plugin.getConfig().getString("ping")));
        } else {
            System.out.println("This command can only be executed by a player.");
        }

        return true;
    }

}
