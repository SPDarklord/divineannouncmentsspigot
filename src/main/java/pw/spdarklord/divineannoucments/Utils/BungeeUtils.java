package pw.spdarklord.divineannoucments.Utils;

//Import libaries and API's that are needed
import com.google.common.collect.Iterables;
import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import pw.spdarklord.divineannoucments.DivineAnnouncments;

//Create a new class
public class BungeeUtils {

    //Create a method for requesting data from database
    // calling for a string and int and another string
    public static void requestList(String request, int id, String playerName) {

        //Try to complete the following code
        try {
            //Create a bytearray of a new data stream
            ByteArrayDataOutput out = ByteStreams.newDataOutput();
            //add "request" to the byte array
            out.writeUTF("Request");
            //add the string request
            out.writeUTF(request);
            //if the request is list
            if (request == "list"){
                //if the request is list write the id as a string
                out.writeUTF(Integer.toString(id));
            }
            //Add the name of this server
            out.writeUTF(DivineAnnouncments.getInstance().getName());
            //Add the name of the player
            out.writeUTF(playerName);
            //get a random player from the server
            Player player = Iterables.getFirst(Bukkit.getOnlinePlayers(), null);
            //User the player to send the array on the channel BungeeCord
            player.sendPluginMessage(DivineAnnouncments.getInstance(), "BungeeCord", out.toByteArray());
        //If the code fails print stack trace
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Create a method for add a message to the database
    //calling for the request and the message
    public  static void addMessage(String request, int id, String message){
        //try the code
        try {
            //Create a new dataoutput
            ByteArrayDataOutput out = ByteStreams.newDataOutput();
            //add Request
            out.writeUTF("Request");
            //Write the type of request
            out.writeUTF(request);
            //if the request is
            if (request == "addID"){
                //add the id as a string
                out.writeUTF(Integer.toString(id));
            }
            out.writeUTF(message);
            //get the first player on the server
            Player player = Iterables.getFirst(Bukkit.getOnlinePlayers(), null);
            //Send the message to bungee
            player.sendPluginMessage(DivineAnnouncments.getInstance(), "BungeeCord", out.toByteArray());
        }catch (Exception e){
            e.printStackTrace();
        }
    }


}
