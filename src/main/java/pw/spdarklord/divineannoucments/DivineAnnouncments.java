package pw.spdarklord.divineannoucments;

//Import libaries and API's which are needed
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import pw.spdarklord.divineannoucments.Commands.DivineAnnouncmentCommand;
import pw.spdarklord.divineannoucments.Listeners.PluginMessageListener;

//Extend an instance of javaplugin
public class DivineAnnouncments extends JavaPlugin{



    //Register an instance of this class
    public static DivineAnnouncments instance;

    //return the value of instance
    public static DivineAnnouncments getInstance() {
        return instance;
    }


    //When the plugin is enabled, do the following
    @Override
    public void onEnable() {
        //set the value of instance to this
        instance = this;
        //Register incoming and outgoing plugin messaging channels for communication
        Bukkit.getMessenger().registerOutgoingPluginChannel(instance, "BungeeCord");
        //Set the handler for incoming messages
        Bukkit.getMessenger().registerIncomingPluginChannel(instance, "BungeeCord", new PluginMessageListener());
        //Register command handler for the command divineannouncment
        getCommand("divineannouncment").setExecutor(new DivineAnnouncmentCommand());
    }

    //Method for disabling plugins
    @Override
    public void onDisable() {
        super.onDisable();
    }
}
