package pw.spdarklord.divineannoucments.Listeners;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import pw.spdarklord.divineannoucments.DivineAnnouncments;
import pw.spdarklord.divineannoucments.Utils.Chat;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;

/**
 * Created by Thomas on 10/05/2017.
 */
public class PluginMessageListener implements org.bukkit.plugin.messaging.PluginMessageListener {

    public void onPluginMessageReceived(String channel, Player player, byte[] bytes) {

        if (!channel.equals("BungeeCord")){
            return;
        }

        ByteArrayInputStream stream = new ByteArrayInputStream(bytes);
        DataInputStream in = new DataInputStream(stream);
        try {
            if (in.readUTF().equals("MessageToBroadcast")) {
                Chat.bc(in.readUTF());
            }
            if (in.readUTF().equals("MessageTo"+ DivineAnnouncments.getInstance().getName())){
                String data = in.readUTF();
                String user = in.readUTF();
                Player p = Bukkit.getServer().getPlayer(user);
                Chat.sendMessage(p, data);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
