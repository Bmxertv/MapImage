package de.tryblock;

/**
 * Spigot - Map Image
 * Here is a simple example to display an image on a map
 *
 * @author TryBlock
 * @version 1.0
 */

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.MapMeta;
import org.bukkit.map.MapView;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Main Class
 */
public class ImageMap extends JavaPlugin implements CommandExecutor {

    @Override
    public void onEnable() {
        getCommand("test").setExecutor(this);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;

        // Create Filled Map ItemStack
        ItemStack itemStack = new ItemStack(Material.FILLED_MAP);
        // Create MapView
        MapView mapView = Bukkit.createMap(player.getWorld());
        // Clear all Renderes of the MapView
        mapView.getRenderers().clear();
        // Set Custom Renderer for MapView
        mapView.addRenderer(new MyRenderer());

        // Get MapMeta
        MapMeta mapMeta = (MapMeta) itemStack.getItemMeta();
        // Set Map View
        mapMeta.setMapView(mapView);

        // Set ItemMeta
        itemStack.setItemMeta(mapMeta);

        // Add Map to Inventory
        player.getInventory().addItem(itemStack);
        return true;
    }

}
