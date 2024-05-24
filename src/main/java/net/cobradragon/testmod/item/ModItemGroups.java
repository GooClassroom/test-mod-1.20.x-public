package net.cobradragon.testmod.item;

import net.cobradragon.testmod.TestMod;
import net.cobradragon.testmod.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {

    public static final ItemGroup Power_Group = Registry.register(Registries.ITEM_GROUP,
            new Identifier(TestMod.MOD_ID, "power"),
            FabricItemGroup.builder().displayName(Text.translatable( "itemgroup.power"))
                    .icon(() -> new ItemStack(ModItems.POWER_STONE)).entries((displayContext, entries) -> {
                        entries.add(ModItems.RUBY);
                        entries.add(ModItems.RAW_RUBY);


                        entries.add(ModItems.POWERITE_INGOT);
                        entries.add(ModItems.POWER_STONE);
                        entries.add(ModItems.RAW_POWERITE);

                        entries.add(ModBlocks.POWER_BLOCK);
                        entries.add(ModBlocks.VENIOPRIUM_BLOCK);
                        entries.add(ModBlocks.VENIOPRIUM_ORE);
                        entries.add(ModBlocks.END_VENIOPRIUM);
                        entries.add(ModBlocks.POWERITE_ORE);
                        entries.add(ModBlocks.SOUND_BLOCK);
                        entries.add(ModItems.SUPER_COAL);
                        entries.add(ModItems.RAW_VENIOPRIUM);
                        entries.add(ModItems.VENIOPRIUM_INGOT);

                        entries.add(ModItems.VENIOPRIUM_HELMET);
                        entries.add(ModItems.VENIOPRIUM_CHESTPLATE);
                        entries.add(ModItems.VENIOPRIUM_LEGGINGS);
                        entries.add(ModItems.VENIOPRIUM_BOOTS);


                        entries.add(ModBlocks.VENIOPRIUM_STAIRS);
                        entries.add(ModBlocks.VENIOPRIUM_SLAB);
                        entries.add(ModBlocks.VENIOPRIUM_FENCE);
                        entries.add(ModBlocks.VENIOPRIUM_FENCE_GATE);
                        entries.add(ModBlocks.VENIOPRIUM_WALL);
                        entries.add(ModBlocks.VENIOPRIUM_BUTTON);
                        entries.add(ModBlocks.VENIOPRIUM_PRESSURE_PLATE);
                        entries.add(ModBlocks.VENIOPRIUM_DOOR);
                        entries.add(ModBlocks.VENIOPRIUM_TRAPDOOR);

                        entries.add(ModItems.METAL_DETECTOR);
                        entries.add(ModItems.VENIOPRIUM_HOE);
                        entries.add(ModItems.VENIOPRIUM_AXE);
                        entries.add(ModItems.VENIOPRIUM_SHOVEL);
                        entries.add(ModItems.VENIOPRIUM_PICKAXE);
                        entries.add(ModItems.VENIOPRIUM_SWORD);

                    }).build());



    public static void registerItemGroups() {

        TestMod.LOGGER.info("registering item groups for " + TestMod.MOD_ID);
    }
}
