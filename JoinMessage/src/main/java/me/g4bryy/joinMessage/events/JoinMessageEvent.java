package me.g4bryy.joinMessage.events;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class JoinMessageEvent implements Listener {
    private JavaPlugin plugin;
    public JoinMessageEvent(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        event.setJoinMessage(null);
        Player player = event.getPlayer();
        FileConfiguration config = plugin.getConfig();
        String message = config.getString("join.message", "Setup in the configs!");
        message = message.replace("%player%", player.getName());
        Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', message));
    }
}
