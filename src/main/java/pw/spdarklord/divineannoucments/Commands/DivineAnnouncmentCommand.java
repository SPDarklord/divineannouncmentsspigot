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

        if (command.getName().equalsIgnoreCase("divineannouncment")) {
            if (strings.length == 0) {
                Chat.sendMessage(commandSender, "DivineAnnouncments" + Bukkit.getPluginManager().getPlugin("DivineAnnouncments").getDescription().getVersion());
                Chat.sendMessage(commandSender, "Commands:");
                Chat.sendMessage(commandSender, "/divineannouncments - Core command shows help");
                Chat.sendMessage(commandSender, "/divineannouncments list <id> - List all messages or add id to list a message");
                Chat.sendMessage(commandSender, "/divineannounments add <message> <id> - Add a message with an auto id or overwrite a message");
            }
            if (strings.length == 1) {
                if (strings[0].equalsIgnoreCase("list")) {
                    Chat.sendMessage(commandSender, "Get all message from database");
                }
            }
            if (strings.length > 1) {
                if (strings[0].equalsIgnoreCase("list")) {
                    Chat.sendMessage(commandSender, "Get message " + strings[1] + " from database");
                    return false;
                }
                if (strings[0].equalsIgnoreCase("add")){
                    try {
                        Integer.parseInt(strings[1]);
                        StringBuilder sb = new StringBuilder();
                        for(int i=2; i<strings.length; i++){ // change 1
                            sb.append(strings[i]).append(" ");
                        }
                        String formedS = sb.toString();
                        Chat.sendMessage(commandSender, "Send " + formedS + "to database at id " + strings[1] );

                    }catch (NumberFormatException e){
                        StringBuilder sb = new StringBuilder();
                        for(int i=1; i<strings.length; i++){ // change 1
                            sb.append(strings[i]).append(" ");
                        }
                        String formedS = sb.toString();
                        Chat.sendMessage(commandSender, "Send " + formedS + "to database");
                    }
                }else {
                    Chat.sendRaw(commandSender, "&CInsufficent args");
                }

            }



        }

        return false;
    }


}