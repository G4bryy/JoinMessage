package me.g4bryy.joinMessage;

import me.g4bryy.joinMessage.events.JoinMessageEvent;
import me.g4bryy.joinMessage.events.LeftMessageEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class JoinMessage extends JavaPlugin {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(new JoinMessageEvent(this), this);
        getServer().getPluginManager().registerEvents(new LeftMessageEvent(this), this);
        saveDefaultConfig();
    }

    @Override
    public void onDisable() {
    }
}
