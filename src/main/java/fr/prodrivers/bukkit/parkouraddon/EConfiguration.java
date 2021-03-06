package fr.prodrivers.bukkit.parkouraddon;

import fr.prodrivers.bukkit.commons.Chat;
import fr.prodrivers.bukkit.commons.annotations.ForceSkipObjectAction;
import fr.prodrivers.bukkit.commons.configuration.Configuration;
import fr.prodrivers.bukkit.commons.configuration.Messages;
import me.eddie.inventoryguiapi.gui.elements.FormImage;
import org.bukkit.Material;
import org.bukkit.plugin.Plugin;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.logging.Level;

public class EConfiguration extends Configuration {
	@ForceSkipObjectAction
	public FormImage selection_image_check =
			new FormImage(FormImage.FormImageType.PATH, "textures/ui/check.png");
	public Material shops_close_material = Material.BARRIER;
	public Material shops_ranks_material = Material.EMERALD;
	public Material shops_ranks_alreadyBought_material = Material.EMERALD_BLOCK;
	public Material shops_ranks_notBuyable_material = Material.BEDROCK;
	public Material shops_converters_material = Material.GOLD_INGOT;
	public Material shops_converters_to_material = Material.GOLD_INGOT;
	public Material shops_converters_from_material = Material.IRON_INGOT;
	public Map<String, Integer> shops_converters_amounts = new LinkedHashMap<>();
	@ForceSkipObjectAction public Level logLevel = Level.INFO;

	{
		shops_converters_amounts.put( String.valueOf( 10 ) , 5 );
		shops_converters_amounts.put( String.valueOf( 100 ) , 50 );
		shops_converters_amounts.put( String.valueOf( 200 ) , 100 );
		shops_converters_amounts.put( String.valueOf( 1000 ) , 500 );
		shops_converters_amounts.put( String.valueOf( 2000 ) , 1000 );
	}

	public EConfiguration( Plugin plugin, Class<? extends Messages> messagesClass, Chat chat ) {
		super( plugin, messagesClass, chat );
	}

	@Override
	public void reload() {
		super.reload();
		getMessages().reload();
	}
}
