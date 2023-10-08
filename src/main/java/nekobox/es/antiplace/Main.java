package nekobox.es.antiplace;

import nekobox.es.antiplace.Listener.EventListener;
import org.bukkit.plugin.java.JavaPlugin;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class Main extends JavaPlugin {
    private static Main instance;
    public Logger logger;
    public DataManager config;

    @Override
    public void onEnable() {
        // Sets up config
        getConfig().options().copyDefaults();
        saveDefaultConfig();

        this.config = new DataManager(this, "config.yml");

        // Sets up logger
        this.logger = this.getLogger();

        // Adds "this" for "this.main" to work
        if (instance == null) instance = this;

        // Events Setup
        this.getServer().getPluginManager().registerEvents(new EventListener(this), this);

        this.logger.log(Level.INFO, "\u001B[35mAntiPlace has loaded!\u001B[0m");
    }

    @Override
    public void onDisable() {
        this.logger.log(Level.INFO, "\u001B[31mAntiPlace has shutdown.\u001B[0m");
    }

    public static Main getInstance() {
        return instance;
    }
}
