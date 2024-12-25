package me.g4bryy.joinMessage.events;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class LeftMessageEvent implements Listener {
    private JavaPlugin plugin;
    public LeftMessageEvent(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerQuitEvent(PlayerQuitEvent event) {
        event.setQuitMessage(null);
        Player player = event.getPlayer();
        FileConfiguration config = plugin.getConfig();
        String message = config.getString("left.message", "Setup in the configs!");
        message = message.replace("%player%", player.getName());
        Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', message));
    }
}
