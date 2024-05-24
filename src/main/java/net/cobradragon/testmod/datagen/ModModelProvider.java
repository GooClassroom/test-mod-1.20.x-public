package net.cobradragon.testmod.datagen;

import net.cobradragon.testmod.block.ModBlocks;
import net.cobradragon.testmod.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import net.minecraft.item.ArmorItem;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.POWERITE_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.POWER_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.SOUND_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.VENIOPRIUM_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.END_VENIOPRIUM);
        BlockStateModelGenerator.BlockTexturePool veniopriumPool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.VENIOPRIUM_BLOCK);

        veniopriumPool.stairs(ModBlocks.VENIOPRIUM_STAIRS);
        veniopriumPool.slab(ModBlocks.VENIOPRIUM_SLAB);
        veniopriumPool.button(ModBlocks.VENIOPRIUM_BUTTON);
        veniopriumPool.pressurePlate(ModBlocks.VENIOPRIUM_PRESSURE_PLATE);
        veniopriumPool.fence(ModBlocks.VENIOPRIUM_FENCE);
        veniopriumPool.fenceGate(ModBlocks.VENIOPRIUM_FENCE_GATE);
        veniopriumPool.wall(ModBlocks.VENIOPRIUM_WALL);

        blockStateModelGenerator.registerDoor(ModBlocks.VENIOPRIUM_DOOR);
        blockStateModelGenerator.registerTrapdoor(ModBlocks.VENIOPRIUM_TRAPDOOR);




    }


    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.RUBY, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAW_RUBY, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAW_POWERITE, Models.GENERATED);
        itemModelGenerator.register(ModItems.POWER_STONE, Models.GENERATED);
        itemModelGenerator.register(ModItems.SUPER_COAL, Models.GENERATED);
        itemModelGenerator.register(ModItems.POWERITE_INGOT, Models.GENERATED);
        itemModelGenerator.register(ModItems.METAL_DETECTOR, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAW_VENIOPRIUM, Models.GENERATED);
        itemModelGenerator.register(ModItems.VENIOPRIUM_INGOT, Models.GENERATED);
        itemModelGenerator.register(ModItems.VENIOPRIUM_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.VENIOPRIUM_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.VENIOPRIUM_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.VENIOPRIUM_SHOVEL, Models.HANDHELD);

        itemModelGenerator.registerArmor(((ArmorItem) ModItems.VENIOPRIUM_HELMET));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.VENIOPRIUM_CHESTPLATE));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.VENIOPRIUM_LEGGINGS));
        itemModelGenerator.registerArmor(((ArmorItem) ModItems.VENIOPRIUM_BOOTS));



    }
}
