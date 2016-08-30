package de.domisum.hmapi.test;

import de.domisum.auxiliumapi.data.container.math.Vector3D;
import de.domisum.auxiliumapi.util.bukkit.ItemStackBuilder;
import de.domisum.hmapi.component.HologramMenuComponent;
import de.domisum.hmapi.menu.HologramMenu;
import de.domisum.hologramapi.hologram.TextHologram;
import de.domisum.hologramapi.hologram.item.ItemHologram;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class TestMenu extends HologramMenu
{

	// -------
	// CONSTRUCTOR
	// -------
	public TestMenu(Player player)
	{
		super(player, new Location(player.getWorld(), 174.5, 64.6, 60.5));

		addComponents();

		done();
	}

	private void addComponents()
	{
		ItemStack is = new ItemStackBuilder(Material.GRASS).build();
		//new ItemStackBuilder(Material.SKULL_ITEM).durability(3).skullOwner("domisum").build();

		HologramMenuComponent hmc;

		ItemHologram ihg = new ItemHologram(is);
		ihg.setRotation(-30);
		hmc = new HologramMenuComponent(ihg)
		{
			@Override
			public void onHover()
			{
				((ItemHologram) this.hologram).setItemStack(new ItemStack(Material.PUMPKIN));
			}

			@Override
			public void onDehover()
			{
				((ItemHologram) this.hologram).setItemStack(new ItemStack(Material.GRASS));
			}
		};
		this.components.put(hmc, new Vector3D(-3, 0, 0));

		hmc = new HologramMenuComponent(new TextHologram("Ayy lmao, memes are gr8"))
		{
			@Override
			public void onHover()
			{
				TextHologram textHologram = (TextHologram) this.hologram;
				textHologram.setText(ChatColor.GOLD+textHologram.getText());
			}

			@Override
			public void onDehover()
			{
				TextHologram textHologram = (TextHologram) this.hologram;
				textHologram.setText(ChatColor.stripColor(textHologram.getText()));
			}
		};
		this.components.put(hmc, new Vector3D(0, 0, 0));

		ihg = new ItemHologram(is);
		ihg.setRotation(30);
		hmc = new HologramMenuComponent(ihg)
		{
			@Override
			public void onHover()
			{
				((ItemHologram) this.hologram).setItemStack(new ItemStack(Material.PUMPKIN));
			}

			@Override
			public void onDehover()
			{
				((ItemHologram) this.hologram).setItemStack(new ItemStack(Material.GRASS));
			}
		};
		this.components.put(hmc, new Vector3D(3, 0, 0));
	}

}
