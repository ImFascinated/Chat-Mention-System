package me.imfascinated.chatmentionsystem;

import me.imfascinated.chatmentionsystem.events.MentionEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    public void onEnable() {
        registerEvents();
    }
    private void registerEvents() {
        getServer().getPluginManager().registerEvents(new MentionEvent(), this);
    }
}
