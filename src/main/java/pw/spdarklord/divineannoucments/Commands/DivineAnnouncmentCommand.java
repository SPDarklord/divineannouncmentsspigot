package pw.spdarklord.divineannoucments.Commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import pw.spdarklord.divineannoucments.Utils.BungeeUtils;
import pw.spdarklord.divineannoucments.Utils.Chat;

//Implement code from the Spigot class Command Executor
public class DivineAnnouncmentCommand implements CommandExecutor {

    //constructor for a command
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        //if the command is divineannouncment, ignoring case
        if (command.getName().equalsIgnoreCase("divineannouncment")) {
            //if no args are given, give the player help
            if (strings.length == 0) {
                //Tell the player the plugin version and commands they can do
                Chat.sendMessage(commandSender, "DivineAnnouncments" + Bukkit.getPluginManager().getPlugin("DivineAnnouncments").getDescription().getVersion());
                Chat.sendMessage(commandSender, "Commands:");
                Chat.sendMessage(commandSender, "/divineannouncments - Core command shows help");
                Chat.sendMessage(commandSender, "/divineannouncments list <id> - List all messages or add id to list a message");
                Chat.sendMessage(commandSender, "/divineannounments add <id> <message>  - Add a message with an auto id or overwrite a message");
            }
            //if there is only one arg and
            if (strings.length == 1) {
                //the arg is list
                if (strings[0].equalsIgnoreCase("list")) {
                    //Get all messages from bungee
                    BungeeUtils.requestList("listall", 0, commandSender.getName());
                }
            }
            //if there are more than one args
            if (strings.length > 1) {
                //if the first arg equals list
                if (strings[0].equalsIgnoreCase("list")) {
                    //Request the data by using the method written in bungeeutils, sending the request list the id
                    //and the name of the player
                    BungeeUtils.requestList("list", Integer.parseInt(strings[1]), commandSender.getName());
                    //end code
                    return true;
                }
                //if the first arg is add
                if (strings[0].equalsIgnoreCase("add")){
                    //try to do the following
                    try {
                        //get the numer at the second arg
                        Integer.parseInt(strings[1]);
                        //create a new string builder to make all other args one string
                        StringBuilder sb = new StringBuilder();
                        //start at arg 2, since arg 1 is the number
                        //loop for the length of the list
                        for(int i=2; i<strings.length; i++){ // change 1
                            //add the item to the string builder
                            sb.append(strings[i]).append(" ");
                        }
                        //Change the string builder to a string
                        String formedS = sb.toString();
                        //send the message to bungee with the request int and string
                        BungeeUtils.addMessage("addID", Integer.parseInt(strings[1]), formedS);
                        //if the plugin fails to parse the int it will do the following
                    }catch (NumberFormatException e){
                        //Create a new string
                        StringBuilder sb = new StringBuilder();
                        //Starting at 1 as ther eis no int
                        for(int i=1; i<strings.length; i++){ // change 1
                            sb.append(strings[i]).append(" ");
                        }
                        String formedS = sb.toString();
                        //send with an id zero as this can not be used and so can be ignored
                        BungeeUtils.addMessage("add", 0, formedS);
                    }
                    //after all else inform the user they did it wrong.
                }else {
                    Chat.sendRaw(commandSender, "&CInsufficent args");
                }

            }



        }

        return false;
    }


}