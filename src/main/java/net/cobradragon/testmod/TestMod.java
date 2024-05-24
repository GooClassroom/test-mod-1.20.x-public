package net.cobradragon.testmod;

import net.cobradragon.testmod.block.ModBlocks;
import net.cobradragon.testmod.entity.ModEntities;
import net.cobradragon.testmod.entity.custom.VeniopriumShulkerEntity;
import net.cobradragon.testmod.item.ModItemGroups;
import net.cobradragon.testmod.item.ModItems;
import net.cobradragon.testmod.world.gen.ModWorldGeneration;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.registry.FuelRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestMod implements ModInitializer {
	public static final String MOD_ID = "testmod";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.registerModItems();

		ModItemGroups.registerItemGroups();
		ModBlocks.registerModBlocks();

		FuelRegistry.INSTANCE.add(ModItems.SUPER_COAL, 5000);
		ModWorldGeneration.generateModWorldGen();
	FabricDefaultAttributeRegistry.register(ModEntities.VENIOPRIUMSHULKER, VeniopriumShulkerEntity.createShulkerAttributes());
	}
}