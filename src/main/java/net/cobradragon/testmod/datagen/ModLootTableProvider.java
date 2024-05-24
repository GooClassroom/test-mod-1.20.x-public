package net.cobradragon.testmod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.cobradragon.testmod.block.ModBlocks;
import net.cobradragon.testmod.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.data.server.loottable.BlockLootTableGenerator;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LeafEntry;
import net.minecraft.loot.entry.LootPoolEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.POWER_BLOCK);
        addDrop(ModBlocks.POWERITE_ORE);
        addDrop(ModBlocks.SOUND_BLOCK);

        addDrop(ModBlocks.POWERITE_ORE, oreDrops(ModBlocks.POWERITE_ORE, ModItems.RAW_POWERITE));
        addDrop(ModBlocks.VENIOPRIUM_ORE, diamondLikeOreDrops(ModBlocks.VENIOPRIUM_ORE, ModItems.RAW_VENIOPRIUM));
        addDrop(ModBlocks.END_VENIOPRIUM, diamondLikeOreDrops(ModBlocks.END_VENIOPRIUM, ModItems.RAW_VENIOPRIUM));
        addDrop(ModBlocks.VENIOPRIUM_BLOCK, drops(ModBlocks.VENIOPRIUM_BLOCK));
        addDrop(ModBlocks.POWER_BLOCK, oreDrops(ModBlocks.POWER_BLOCK, ModItems.POWER_STONE));
        addDrop(ModBlocks.SOUND_BLOCK, drops(ModBlocks.SOUND_BLOCK));


        addDrop(ModBlocks.VENIOPRIUM_STAIRS);
        addDrop(ModBlocks.VENIOPRIUM_TRAPDOOR);
        addDrop(ModBlocks.VENIOPRIUM_WALL);
        addDrop(ModBlocks.VENIOPRIUM_FENCE);
        addDrop(ModBlocks.VENIOPRIUM_FENCE_GATE);
        addDrop(ModBlocks.VENIOPRIUM_BUTTON);
        addDrop(ModBlocks.VENIOPRIUM_PRESSURE_PLATE);

        addDrop(ModBlocks.VENIOPRIUM_DOOR, doorDrops(ModBlocks.VENIOPRIUM_DOOR));
        addDrop(ModBlocks.VENIOPRIUM_SLAB, slabDrops(ModBlocks.VENIOPRIUM_SLAB));

    }

    public LootTable.Builder diamondLikeOreDrops(Block drop, Item item) {
        return BlockLootTableGenerator.dropsWithSilkTouch(drop, (LootPoolEntry.Builder)this.applyExplosionDecay(drop,
                ((LeafEntry.Builder)
                        ItemEntry.builder(item)
                                .apply(SetCountLootFunction
                                        .builder(UniformLootNumberProvider
                                                .create(1.0f, 1.0f))))
                        .apply(ApplyBonusLootFunction.oreDrops(Enchantments.FORTUNE))));
    }
}

