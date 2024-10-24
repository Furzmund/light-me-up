package org.furzmund.lightmeup;

import net.fabricmc.api.ModInitializer;

import org.furzmund.lightmeup.entity.ModEntities;
import org.furzmund.lightmeup.item.ModItems;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LightMeUp implements ModInitializer {
	public static final String MOD_ID = "light-me-up";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
		ModEntities.registerModEntities();
		LOGGER.info("Light Me Up loaded");
	}
}
