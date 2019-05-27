package me.fascinated.chatmentionsystem;

import me.fascinated.chatmentionsystem.commands.Mentions;
import me.fascinated.chatmentionsystem.events.MentionEvent;
import me.fascinated.chatmentionsystem.util.Config;
import me.fascinated.chatmentionsystem.util.Metrics;
import org.bukkit.plugin.java.JavaPlugin;

import static org.bukkit.Bukkit.getConsoleSender;

public class Main extends JavaPlugin {

    public static Config config;
    public static Main instance;

    public void onEnable() {
        instance = this;
        new Metrics(this);
        getServer().getPluginManager().registerEvents(new MentionEvent(), this);
        getCommand("mentions").setExecutor(new Mentions());
        config = new Config(this, "config.yml", null);
        config.saveDefaultConfig();
        getConsoleSender().sendMessage("§8§m-----------------------------------------");
        getConsoleSender().sendMessage("§aThis plugin was created by _Fascinated");
        getConsoleSender().sendMessage("");
        getConsoleSender().sendMessage("§cPlugin: §f" + getDescription().getName());
        getConsoleSender().sendMessage("§cVersion: §f" + getDescription().getVersion());
        getConsoleSender().sendMessage("");
        getConsoleSender().sendMessage("§aDiscord: §fImFascinated#4735");
        getConsoleSender().sendMessage("§aGitHub: §fgithub.com/RealFascinated");
        getConsoleSender().sendMessage("§aTwitter: §ftwitter.com/RealFascinated");
        getConsoleSender().sendMessage("§8§m-----------------------------------------");

    }
}
