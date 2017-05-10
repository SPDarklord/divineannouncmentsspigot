package pw.spdarklord.divineannoucments;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import pw.spdarklord.divineannoucments.Commands.DivineAnnouncmentCommand;
import pw.spdarklord.divineannoucments.Listeners.PluginMessageListener;
import pw.spdarklord.divineannoucments.Utils.BungeeUtils;

/**
 * Created by Thomas on 07/05/2017.
 */
public class DivineAnnouncments extends JavaPlugin{

    public static DivineAnnouncments plugin;

    public static DivineAnnouncments instance;

    public DivineAnnouncments() {
        instance = this;
    }
    public static DivineAnnouncments getInstance() {
        return instance;
    }

    @Override
    public void onEnable() {
        plugin = this;
        Bukkit.getMessenger().registerOutgoingPluginChannel(plugin, "BungeeCord");
        Bukkit.getMessenger().registerIncomingPluginChannel(plugin, "BungeeCord", new PluginMessageListener());
        getCommand("divineannouncment").setExecutor(new DivineAnnouncmentCommand());
    }

    @Override
    public void onDisable() {

    }
}
