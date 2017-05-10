package pw.spdarklord.divineannoucments.Utils;

import com.google.common.collect.Iterables;
import com.google.common.io.ByteArrayDataOutput;
import com.google.common.io.ByteStreams;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import pw.spdarklord.divineannoucments.DivineAnnouncments;

/**
 * Created by Thomas on 08/05/2017.
 */
public class BungeeUtils {

    public static void requestList(String request, int id, String playerName) {

        try {
            ByteArrayDataOutput out = ByteStreams.newDataOutput();
            out.writeUTF("Request");
            out.writeUTF(request);
            if (request == "list"){
                out.writeUTF(Integer.toString(id));
            }
            out.writeUTF(DivineAnnouncments.getInstance().getName());
            out.writeUTF(playerName);
            Player player = Iterables.getFirst(Bukkit.getOnlinePlayers(), null);
            player.sendPluginMessage(DivineAnnouncments.getInstance(), "BungeeCord", out.toByteArray());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public  static void addMessage(String request, int id, String message){
        try {
            ByteArrayDataOutput out = ByteStreams.newDataOutput();
            out.writeUTF("Request");
            out.writeUTF(request);
            if (request == "AddID"){
                out.writeUTF(Integer.toString(id));
            }
            Player player = Iterables.getFirst(Bukkit.getOnlinePlayers(), null);
            player.sendPluginMessage(DivineAnnouncments.getInstance(), "BungeeCord", out.toByteArray());
            out.writeUTF(message);
        }catch (Exception e){
            e.printStackTrace();
        }
    }


}
