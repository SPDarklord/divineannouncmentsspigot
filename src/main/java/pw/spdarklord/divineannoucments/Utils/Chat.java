package pw.spdarklord.divineannoucments.Utils;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * Created by Thomas on 08/05/2017.
 */
public class Chat {

    private static Chat ins = new Chat();

    public static Chat get() {
        return ins;
    }

    public static String prefix = "§2DA §5> §r";

    public String getPrefix() {
        return prefix;
    }

    public static void logCS(String s) {
        Bukkit.getConsoleSender().sendMessage(prefix + ChatColor.translateAlternateColorCodes('&', s));
    }

    public static void pm(Player player, String msg, String targetName, String playerName, Player target) {
        player.sendMessage("§a[§5You §b-> §5" + targetName + "§a] §d" + msg);
        target.sendMessage("§a[§5You §b<- §5" + playerName + "§a] §d" + msg);
    }

    public static void sendMessage(Player players, String s) {
        players.sendMessage(prefix + ChatColor.translateAlternateColorCodes('&', s));
    }

    public static void sendMessage(CommandSender cs, String s) {
        cs.sendMessage(prefix + ChatColor.translateAlternateColorCodes('&', s));
    }

    public static void sendRaw(Player players, String s) {
        players.sendMessage(ChatColor.translateAlternateColorCodes('&', s));
    }

    public static void sendRaw(CommandSender cs, String s){
        cs.sendMessage(ChatColor.translateAlternateColorCodes('&', s));
    }

    public static void noPerms(Player player) {
        sendRaw(player, "§cYou can't do this!");
    }

    public static void bc(String msg) {
        for (Player players : Bukkit.getOnlinePlayers()) {
            sendMessage(players, ChatColor.YELLOW + msg);
        }
    }

}
