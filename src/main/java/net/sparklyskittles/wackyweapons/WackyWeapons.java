package net.sparklyskittles.wackyweapons;

import net.fabricmc.api.ModInitializer;

import net.sparklyskittles.wackyweapons.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WackyWeapons implements ModInitializer {
	public static final String MOD_ID = "wackyweapons";
    public static final Logger LOGGER = LoggerFactory.getLogger("wackyweapons");


	@Override
	public void onInitialize() {
		ModItems.registerModItems();
	}
}