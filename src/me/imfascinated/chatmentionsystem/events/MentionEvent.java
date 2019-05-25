package me.imfascinated.chatmentionsystem.events;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class MentionEvent implements Listener {

    @EventHandler
    public void onMention(AsyncPlayerChatEvent e) {
        Player p = e.getPlayer();
        String msg = e.getMessage();

        if(msg.contains(p.getName())) {
            return;
        }

        for(Player target : Bukkit.getOnlinePlayers()) {
            if(msg.contains(target.getName())) {
                target.playSound(target.getEyeLocation(), Sound.LEVEL_UP, 0.9f, 1);
                target.sendMessage("§a§l>§2§l> §a" + p.getName() + " has mentioned you. §a§l<§2§l<");
            }
        }
    }
}
