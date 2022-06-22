package me.kelopy.acrobatic.commands;

import me.clip.placeholderapi.PlaceholderAPI;
import me.kelopy.acrobatic.Acrobatic;
import org.bukkit.Bukkit;
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

        if(sender instanceof Player p){

            if(args.length == 0){
                String ping = plugin.getConfig().getString("ping");
                ping = PlaceholderAPI.setPlaceholders(p, ping);
                p.sendMessage(ping);
            }else{
                Player target = Bukkit.getPlayer(args[0]);
                if(target != null){
                    String pingTarget = plugin.getConfig().getString("ping-target");
                    pingTarget = PlaceholderAPI.setPlaceholders(target, pingTarget);
                    p.sendMessage(pingTarget);
                }else{
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cPlayer not found."));
                }
            }

        }else{
            System.out.println("This command can only be executed by a player.");
        }

        return true;
    }

}
