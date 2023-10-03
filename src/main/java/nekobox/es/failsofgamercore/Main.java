package nekobox.es.failsofgamercore;
import nekobox.es.failsofgamercore.Listener.EventListener;
import org.bukkit.plugin.java.JavaPlugin;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class Main extends JavaPlugin {
    private static Main instance;
    public Logger logger;

    @Override
    public void onEnable() {
        // Config Setup
        getConfig().options().copyDefaults();
        saveDefaultConfig();

        // Sets up logger
        this.logger = this.getLogger();

        // Adds "this" for "this.main" to work
        if (instance == null) instance = this;

        // Events Setup
        this.getServer().getPluginManager().registerEvents(new EventListener(this), this);

        this.logger.log(Level.INFO, "\u001B[32mPlugin has loaded!\u001B[0m");
    }

    @Override
    public void onDisable() {
        this.logger.log(Level.INFO, "\u001B[31mPlugin has shutdown.\u001B[0m");
    }
}
