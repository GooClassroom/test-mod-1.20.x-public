package net.cobradragon.testmod.block;

import net.cobradragon.testmod.TestMod;
import net.cobradragon.testmod.block.custom.SoundBlock;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlocks {
    public static final Block POWER_BLOCK = registerBlock("power_block",
            new Block(FabricBlockSettings.copyOf(Blocks.DIAMOND_BLOCK)));

    public static final Block VENIOPRIUM_BLOCK = registerBlock("venioprium_block",
            new Block(FabricBlockSettings.copyOf(Blocks.DIAMOND_BLOCK)));



    public static final Block POWERITE_ORE = registerBlock("powerite_ore",
            new Block(FabricBlockSettings.copyOf(Blocks.IRON_ORE)));
    public static final Block VENIOPRIUM_ORE = registerBlock("venioprium_ore",
            new Block(FabricBlockSettings.copyOf(Blocks.IRON_ORE)));
    public static final Block END_VENIOPRIUM = registerBlock("end_venioprium",
            new Block(FabricBlockSettings.copyOf(Blocks.IRON_ORE)));

    public static final Block SOUND_BLOCK = registerBlock("sound_block",
            new SoundBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK)));

    public static final Block VENIOPRIUM_STAIRS = registerBlock("venioprium_stairs",
            new StairsBlock(ModBlocks.VENIOPRIUM_BLOCK.getDefaultState(), FabricBlockSettings.copyOf(Blocks.IRON_BLOCK)));
    public static final Block VENIOPRIUM_SLAB = registerBlock("venioprium_slab",
            new SlabBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK)));

    public static final Block VENIOPRIUM_BUTTON = registerBlock("venioprium_button",
            new ButtonBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK), BlockSetType.IRON, 10, true  )); //wooden means pressable by arrow
    public static final Block VENIOPRIUM_PRESSURE_PLATE = registerBlock("venioprium_pressure_plate",
            new PressurePlateBlock(PressurePlateBlock.ActivationRule.EVERYTHING, FabricBlockSettings.copyOf(Blocks.IRON_BLOCK), BlockSetType.IRON));

    public static final Block VENIOPRIUM_FENCE = registerBlock("venioprium_fence",
            new FenceBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK)));

    public static final Block VENIOPRIUM_FENCE_GATE = registerBlock("venioprium_fence_gate",
            new FenceGateBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK), WoodType.ACACIA));

    public static final Block VENIOPRIUM_WALL = registerBlock("venioprium_wall",
            new WallBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK)));

    public static final Block VENIOPRIUM_DOOR = registerBlock("venioprium_door",
            new DoorBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).nonOpaque(), BlockSetType.IRON));

    public static final Block VENIOPRIUM_TRAPDOOR = registerBlock("venioprium_trapdoor",
            new TrapdoorBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK).nonOpaque(), BlockSetType.IRON));




    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(TestMod.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, new Identifier(TestMod.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
    }

    public static void registerModBlocks() {
        TestMod.LOGGER.info("registering blocks for " + TestMod.MOD_ID);
    }
}
