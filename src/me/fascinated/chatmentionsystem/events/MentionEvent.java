package me.fascinated.chatmentionsystem.events;

import me.fascinated.chatmentionsystem.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class MentionEvent implements Listener {

    @EventHandler
    public void onMention(AsyncPlayerChatEvent e) {
        Player p = e.getPlayer();
        String msg = e.getMessage();
        FileConfiguration config = Main.config.getConfiguration();

        if (msg.contains(p.getName())) {
            return;
        }

        for(Player target : Bukkit.getOnlinePlayers()) {
            if(msg.contains(target.getName())) {
                target.playSound(target.getEyeLocation(), Sound.valueOf(config.getString("Sound")), 0.9f, 1);
                target.sendMessage(ChatColor.translateAlternateColorCodes('&', config.getString("Message").replace("$player", target.getName())));
            }
        }
    }
}
