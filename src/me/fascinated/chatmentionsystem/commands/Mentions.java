package me.fascinated.chatmentionsystem.commands;

import me.fascinated.chatmentionsystem.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Mentions implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender s, Command c, String l, String[] args) {
        Player player = (Player)s;

        if (player.hasPermission("mentions.command.admin")) {
            if (args.length < 1) {
                help(player);
            } else {
                if (args[0].equalsIgnoreCase("reload")) {
                    player.sendMessage("§e§lNotice §8▪ §fThe configuration is reloading...");
                    try {
                        player.sendMessage("§a§lSuccess §8▪ §fThe configuration has reloaded!");
                        Main.config.reloadConfig();
                    } catch (Exception ex) {
                        player.sendMessage("§c§lError §8▪ §fThe configuration has failed to reload!");
                        ex.printStackTrace();
                    }
                }
            }
        }
        return false;
    }
    private void help(Player player) {
        player.sendMessage("§8§m---------------------------------------");
        player.sendMessage("§a§lMentions §8┃ §fv" + Main.instance.getDescription().getVersion());
        player.sendMessage("");
        player.sendMessage("§8* §a/mentions reload §8- §fReloads the config!");
        player.sendMessage("§8§m---------------------------------------");
    }
}
