package net.cobradragon.testmod.datagen;


import net.cobradragon.testmod.block.ModBlocks;
import net.cobradragon.testmod.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.RecipeProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.SmithingTransformRecipeJsonBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.item.SmithingTemplateItem;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.ShapedRecipe;
import net.minecraft.recipe.SmithingRecipe;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends FabricRecipeProvider {
    private static final List<ItemConvertible>  POWERITE_SMELTABLES = List.of(ModItems.RAW_POWERITE, ModBlocks.POWERITE_ORE);
    private static final List<ItemConvertible> VENIOPRIUM_SMELTABLES= List.of(ModItems.RAW_VENIOPRIUM, ModBlocks.VENIOPRIUM_ORE);

    public ModRecipeProvider(FabricDataOutput output) {
        super(output);
    }


    @Override
    public void generate(Consumer<RecipeJsonProvider> exporter) {
        offerSmelting(exporter, POWERITE_SMELTABLES, RecipeCategory.MISC, ModItems.POWERITE_INGOT,
                0.7f, 200, "power");
        offerBlasting(exporter, POWERITE_SMELTABLES, RecipeCategory.MISC, ModItems.POWERITE_INGOT,
                0.7f, 100, "power");


        offerSmelting(exporter, VENIOPRIUM_SMELTABLES, RecipeCategory.MISC, ModItems.VENIOPRIUM_INGOT,
                0.7f, 200, "power");
        offerBlasting(exporter, VENIOPRIUM_SMELTABLES, RecipeCategory.MISC, ModItems.VENIOPRIUM_INGOT,
                0.7f, 100, "power");
        offerPressurePlateRecipe(exporter, ModBlocks.VENIOPRIUM_PRESSURE_PLATE, ModItems.VENIOPRIUM_INGOT);

        createDoorRecipe(ModBlocks.VENIOPRIUM_DOOR, Ingredient.ofItems(ModItems.VENIOPRIUM_INGOT));


        createFenceGateRecipe(ModBlocks.VENIOPRIUM_FENCE_GATE, Ingredient.ofItems(ModItems.VENIOPRIUM_INGOT));
        createStairsRecipe(ModBlocks.VENIOPRIUM_STAIRS, Ingredient.ofItems(ModItems.VENIOPRIUM_INGOT));
        offerWallRecipe(exporter, RecipeCategory.DECORATIONS, ModBlocks.VENIOPRIUM_WALL, ModItems.VENIOPRIUM_INGOT);
        createSlabRecipe(RecipeCategory.DECORATIONS, ModBlocks.VENIOPRIUM_SLAB, Ingredient.ofItems(ModItems.VENIOPRIUM_INGOT));




        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.POWERITE_INGOT,
                RecipeCategory.DECORATIONS, ModBlocks.POWER_BLOCK);
        offerReversibleCompactingRecipes(exporter,
                RecipeCategory.BUILDING_BLOCKS, ModItems.VENIOPRIUM_INGOT, RecipeCategory.DECORATIONS, ModBlocks.VENIOPRIUM_BLOCK);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.METAL_DETECTOR, 1)
                .pattern("  s")
                .pattern(" S ")
                .pattern("I  ")
                .input('S', ModItems.POWER_STONE)
                .input('s', Items.STICK)
                .input('I', Items.IRON_BLOCK)
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .criterion(hasItem(ModItems.POWER_STONE), conditionsFromItem(ModItems.POWER_STONE))
                .criterion(hasItem(Items.IRON_BLOCK), conditionsFromItem(Items.IRON_BLOCK))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.METAL_DETECTOR)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.VENIOPRIUM_FENCE, 1)
                .pattern("vsv")
                .pattern("vsv")
                .pattern("   ")
                .input('v', ModItems.VENIOPRIUM_INGOT)
                .input('s', Items.STICK)
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .criterion(hasItem(ModItems.VENIOPRIUM_INGOT), conditionsFromItem(ModItems.VENIOPRIUM_INGOT))
                .offerTo(exporter, new Identifier(getRecipeName(ModBlocks.VENIOPRIUM_FENCE)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.SUPER_COAL, 1)
                .pattern("ccc")
                .pattern("cSc")
                .pattern("ccc")
                .input('S', ModItems.POWER_STONE)
                .input('c', Items.COAL)
                .criterion(hasItem(ModItems.POWER_STONE), conditionsFromItem(ModItems.POWER_STONE))
                .criterion(hasItem(Items.COAL), conditionsFromItem(Items.COAL))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.SUPER_COAL)));

        ShapedRecipeJsonBuilder.create(RecipeCategory.COMBAT, ModItems.VENIOPRIUM_SWORD, 1)
                .pattern(" v ")
                .pattern(" v ")
                .pattern(" s ")
                .input('v', ModItems.VENIOPRIUM_INGOT)
                .input('s', Items.STICK)
                .criterion(hasItem(ModItems.VENIOPRIUM_INGOT), conditionsFromItem(ModItems.VENIOPRIUM_INGOT))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(exporter, new Identifier(getRecipeName(ModItems.VENIOPRIUM_SWORD)));


        SmithingTransformRecipeJsonBuilder.create(Ingredient.ofItems(ModItems.POWER_STONE),
                Ingredient.ofItems(Items.NETHERITE_HELMET), Ingredient.ofItems(ModItems.VENIOPRIUM_INGOT),
                RecipeCategory.COMBAT, ModItems.VENIOPRIUM_HELMET).criterion("has_netherite_ingot",
                RecipeProvider.conditionsFromItem(ModItems.VENIOPRIUM_INGOT)).offerTo(exporter,
                RecipeProvider.getItemPath(ModItems.VENIOPRIUM_HELMET) + "_smithing");

        SmithingTransformRecipeJsonBuilder.create(Ingredient.ofItems(ModItems.POWER_STONE),
                Ingredient.ofItems(Items.NETHERITE_CHESTPLATE), Ingredient.ofItems(ModItems.VENIOPRIUM_INGOT),
                RecipeCategory.COMBAT, ModItems.VENIOPRIUM_CHESTPLATE).criterion("has_netherite_ingot",
                RecipeProvider.conditionsFromItem(ModItems.VENIOPRIUM_INGOT)).offerTo(exporter,
                RecipeProvider.getItemPath(ModItems.VENIOPRIUM_CHESTPLATE) + "_smithing");

        SmithingTransformRecipeJsonBuilder.create(Ingredient.ofItems(ModItems.POWER_STONE),
                Ingredient.ofItems(Items.NETHERITE_LEGGINGS), Ingredient.ofItems(ModItems.VENIOPRIUM_INGOT),
                RecipeCategory.COMBAT, ModItems.VENIOPRIUM_LEGGINGS).criterion("has_netherite_ingot",
                RecipeProvider.conditionsFromItem(ModItems.VENIOPRIUM_INGOT)).offerTo(exporter,
                RecipeProvider.getItemPath(ModItems.VENIOPRIUM_LEGGINGS) + "_smithing");

        SmithingTransformRecipeJsonBuilder.create(Ingredient.ofItems(ModItems.POWER_STONE),
                Ingredient.ofItems(Items.NETHERITE_BOOTS), Ingredient.ofItems(ModItems.VENIOPRIUM_INGOT),
                RecipeCategory.COMBAT, ModItems.VENIOPRIUM_BOOTS).criterion("has_netherite_ingot",
                RecipeProvider.conditionsFromItem(ModItems.VENIOPRIUM_INGOT)).offerTo(exporter,
                RecipeProvider.getItemPath(ModItems.VENIOPRIUM_BOOTS) + "_smithing");

        SmithingTransformRecipeJsonBuilder.create(Ingredient.ofItems(ModItems.POWER_STONE),
                Ingredient.ofItems(Items.NETHERITE_SWORD), Ingredient.ofItems(ModItems.VENIOPRIUM_INGOT),
                RecipeCategory.COMBAT, ModItems.VENIOPRIUM_SWORD).criterion("has_netherite_ingot",
                RecipeProvider.conditionsFromItem(ModItems.VENIOPRIUM_INGOT)).offerTo(exporter,
                RecipeProvider.getItemPath(ModItems.VENIOPRIUM_SWORD) + "_smithing");

        SmithingTransformRecipeJsonBuilder.create(Ingredient.ofItems(ModItems.POWER_STONE),
                Ingredient.ofItems(Items.NETHERITE_PICKAXE), Ingredient.ofItems(ModItems.VENIOPRIUM_INGOT),
                RecipeCategory.COMBAT, ModItems.VENIOPRIUM_PICKAXE).criterion("has_netherite_ingot",
                RecipeProvider.conditionsFromItem(ModItems.VENIOPRIUM_INGOT)).offerTo(exporter,
                RecipeProvider.getItemPath(ModItems.VENIOPRIUM_PICKAXE) + "_smithing");

        SmithingTransformRecipeJsonBuilder.create(Ingredient.ofItems(ModItems.POWER_STONE),
                Ingredient.ofItems(Items.NETHERITE_AXE), Ingredient.ofItems(ModItems.VENIOPRIUM_INGOT),
                RecipeCategory.COMBAT, ModItems.VENIOPRIUM_AXE).criterion("has_netherite_ingot",
                RecipeProvider.conditionsFromItem(ModItems.VENIOPRIUM_INGOT)).offerTo(exporter,
                RecipeProvider.getItemPath(ModItems.VENIOPRIUM_AXE) + "_smithing");



















    }


}