package pw.spdarklord.divineannoucments.Listeners;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import pw.spdarklord.divineannoucments.DivineAnnouncments;
import pw.spdarklord.divineannoucments.Utils.Chat;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;

//Create a class implement the methods from the bukkit class pluginmessagelistenere
public class PluginMessageListener implements org.bukkit.plugin.messaging.PluginMessageListener {

    //When the message is received do the following, collecting the data, channel player and byte array
    public void onPluginMessageReceived(String channel, Player player, byte[] bytes) {

        //if the channel does not equal BungeeCord return
        if (!channel.equals("BungeeCord")){
            return;
        }

        //Get the data from the byte array
        ByteArrayInputStream stream = new ByteArrayInputStream(bytes);
        //get the data from the byte array and turn it into a data stream
        DataInputStream in = new DataInputStream(stream);
        //try
        try {
            //if the first data is equal to messagetobroadcast
            if (in.readUTF().equals("MessageToBroadcast")) {
                //broadcast the message
                Chat.bc(in.readUTF());
            }
            //if the data is equal to messageto plus the name of server
            if (in.readUTF().equals("MessageTo"+ DivineAnnouncments.getInstance().getName())){
                //The data is the second element in the byte array
                String data = in.readUTF();
                //the user is the third element
                String user = in.readUTF();
                //find the player matching the username given
                Player p = Bukkit.getServer().getPlayer(user);
                //send the player a message with the data
                Chat.sendMessage(p, data);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
