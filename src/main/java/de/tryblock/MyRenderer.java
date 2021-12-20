package de.tryblock;

/**
 * Spigot - Map Image
 * Here is a simple example to display an image on a map
 *
 * @author TryBlock
 * @version 1.0
 */

import org.bukkit.entity.Player;
import org.bukkit.map.MapCanvas;
import org.bukkit.map.MapRenderer;
import org.bukkit.map.MapView;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Renderer Class
 */
public class MyRenderer extends MapRenderer {
    @Override
    public void render(MapView mapView, MapCanvas mapCanvas, Player player) {
        try {
            // Create Buffered Image
            BufferedImage image = ImageIO.read(ImageMap.class.getClassLoader().getResource("test.png"));

            // Draw Image to Map
            mapCanvas.drawImage(0, 0, image);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
