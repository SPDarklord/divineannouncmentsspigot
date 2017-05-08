package pw.spdarklord.divineannoucments;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import pw.spdarklord.divineannoucments.Commands.DivineAnnouncmentCommand;

/**
 * Created by Thomas on 07/05/2017.
 */
public class DivineAnnouncments extends JavaPlugin{

    public static DivineAnnouncments plugin;

    @Override
    public void onEnable() {
        plugin = this;
        getCommand("divineannouncment").setExecutor(new DivineAnnouncmentCommand());
    }

    @Override
    public void onDisable() {

    }
}
