package me.kelopy.acrobatic.events;

import me.clip.placeholderapi.PlaceholderAPI;
import me.kelopy.acrobatic.Acrobatic;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class importantEvents implements Listener {

    final Acrobatic plugin;

    public importantEvents(Acrobatic plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event){

        Player player = event.getPlayer();

        if (player.hasPlayedBefore()) {
            String joinMessage = plugin.getConfig().getString("player-join");
            joinMessage = PlaceholderAPI.setPlaceholders(player, joinMessage);
            event.setJoinMessage(joinMessage);
        }else{
            String firstJoinMessage = plugin.getConfig().getString("player-first-join");
            firstJoinMessage = PlaceholderAPI.setPlaceholders(player, firstJoinMessage);
            event.setJoinMessage(firstJoinMessage);
        }

    }

    @EventHandler
    public void onQuit(PlayerQuitEvent event){

        Player player = event.getPlayer();
        String quitMessage = plugin.getConfig().getString("player-quit");
        quitMessage = PlaceholderAPI.setPlaceholders(player, quitMessage);
        event.setQuitMessage(quitMessage);

    }

}
