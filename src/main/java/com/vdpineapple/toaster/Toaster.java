package com.vdpineapple.toaster;

import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Toaster implements ModInitializer {
    public static final Logger LOGGER = LoggerFactory.getLogger("toaster");

	@Override
	public void onInitialize() {
		LOGGER.info("Loaded Toaster!");
	}
}