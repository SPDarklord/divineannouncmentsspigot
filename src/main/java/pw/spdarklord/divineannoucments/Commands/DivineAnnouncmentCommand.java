package pw.spdarklord.divineannoucments.Commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import pw.spdarklord.divineannoucments.Utils.Chat;

/**
 * Created by Thomas on 08/05/2017.
 */
public class DivineAnnouncmentCommand implements CommandExecutor {

    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        if(command.getName().equalsIgnoreCase("divineannouncment")){
            if (strings.length == 0) {
                Chat.sendMessage(commandSender, "DivineAnnouncments" + Bukkit.getPluginManager().getPlugin("DivineAnnouncments").getDescription().getVersion());
                Chat.sendMessage(commandSender, "Commands:");
                Chat.sendMessage(commandSender, "/divineannouncments - Core command shows help");
                Chat.sendMessage(commandSender, "/divineannouncments list <id> - List all messages or add id to list a message");
                Chat.sendMessage(commandSender, "/divineannounments add <message> <id> - Add a message with an auto id or overwrite a message");
            }
            if (strings[0].equalsIgnoreCase("list")){
                if (strings.length == 1){
                    Chat.sendMessage(commandSender,"Get message " + strings[1] + " from database");
                }else{
                    Chat.sendMessage(commandSender, "Get all message from database");
                }

            }

            if (strings[0].equalsIgnoreCase("add")){
                if (strings.length == 2){
                    Chat.sendMessage(commandSender, "Add " + strings[1] + " to database with id " + strings[2]);
                }
                if (strings.length == 1){
                    Chat.sendMessage(commandSender, "Add message " + strings[1] + "to database");
                } else{
                    Chat.sendRaw(commandSender, "&CInsufficent args /da add <Message> <id>");
                }
            }

        }

        return false;
    }

}
