package pw.spdarklord.divineannoucments.Utils;

//Import libaries and API's as needed
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

//create a new class
public class Chat {

    //create an instance of this class
    private static Chat ins = new Chat();

    //return an instance of this class
    public static Chat get() {
        return ins;
    }

    //Set the prefix for all messages
    public static String prefix = "§2DA §5> §r";

    //Return the value of prefix
    public String getPrefix() {
        return prefix;
    }

    //Method to log to console
    public static void logCS(String s) {
        Bukkit.getConsoleSender().sendMessage(prefix + ChatColor.translateAlternateColorCodes('&', s));
    }

    //Method to send a message to a player changing colours codes
    public static void sendMessage(Player players, String s) {
        players.sendMessage(prefix + ChatColor.translateAlternateColorCodes('&', s));
    }

    //Method to send a message to a command sender
    public static void sendMessage(CommandSender cs, String s) {
        cs.sendMessage(prefix + ChatColor.translateAlternateColorCodes('&', s));
    }

    //Send a message without the prefix to player
    public static void sendRaw(Player players, String s) {
        players.sendMessage(ChatColor.translateAlternateColorCodes('&', s));
    }

    //Send a mesage without the prefix to command sender
    public static void sendRaw(CommandSender cs, String s){
        cs.sendMessage(ChatColor.translateAlternateColorCodes('&', s));
    }

    //Method to say the player has no perms
    public static void noPerms(Player player) {
        sendRaw(player, "§cYou can't do this!");
    }

    //Method to broadcast to all players
    public static void bc(String msg) {
        for (Player players : Bukkit.getOnlinePlayers()) {
            sendMessage(players, ChatColor.YELLOW + msg);
        }
    }

}
