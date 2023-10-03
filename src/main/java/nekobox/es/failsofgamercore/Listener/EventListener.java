package nekobox.es.failsofgamercore.Listener;

import nekobox.es.failsofgamercore.Main;
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

        if (!player.hasPermission("fails.admin")) {
            Material[] restrictedItems = {Material.OAK_SAPLING, Material.TWISTING_VINES, Material.CORNFLOWER, Material.RED_CANDLE, Material.FIRE_CORAL, Material.YELLOW_CANDLE, Material.WITHER_ROSE, Material.BROWN_MUSHROOM, Material.CHAIN, Material.HONEYCOMB_BLOCK};
            if (isRestrictedItem(event.getBlockPlaced().getType(), restrictedItems)) {
                event.setCancelled(true);
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&aPlugin &7> &cBlocked placing your offhand!"));
            }
        } else {
        }
    }

    private boolean isRestrictedItem(Material item, Material[] restrictedItems) {
        for (Material restrictedItem : restrictedItems) {
            if (item == restrictedItem) {
                return true;
            }
        }
        return false;
    }

    public HandlerList getHandlers() {
        return null;
    }
}
