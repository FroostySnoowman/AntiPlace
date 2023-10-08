package nekobox.es.antiplace.Listener;

import nekobox.es.antiplace.Main;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import java.util.HashMap;
import java.util.Map;

public class EventListener extends Event implements Listener {

    private Main main;

    private Map<String, Long> cooldownMap = new HashMap<>();

    public EventListener(Main main) {
        this.main = main;
    }

    @EventHandler
    public void onBlockPlaceEvent(BlockPlaceEvent event) {
        Player player = event.getPlayer();

        if (!player.hasPermission("antiplace.admin")) {
            String[] blockedItemStrings = this.main.config.getConfig().getStringList("Blocked_Items").toArray(new String[0]);

            Material[] restrictedItems = new Material[blockedItemStrings.length];
            for (int i = 0; i < blockedItemStrings.length; i++) {
                try {
                    restrictedItems[i] = Material.valueOf(blockedItemStrings[i]);
                } catch (IllegalArgumentException e) {
                    e.printStackTrace();
                }
            }

            if (isRestrictedItem(event.getBlockPlaced().getType(), restrictedItems)) {
                event.setCancelled(true);
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', this.main.config.getConfig().getString("Prefix") + " &cBlocked placing your offhand!"));
            }
        } else {
        }
    }

    private boolean isRestrictedItem(Material material, Material[] restrictedItems) {
        for (Material restrictedItem : restrictedItems) {
            if (material == restrictedItem) {
                return true;
            }
        }
        return false;
    }

    public HandlerList getHandlers() {
        return null;
    }
}
