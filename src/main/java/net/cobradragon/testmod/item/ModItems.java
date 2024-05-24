package net.cobradragon.testmod.item;

import net.cobradragon.testmod.TestMod;
import net.cobradragon.testmod.item.custom.ModArmorItem;
import net.cobradragon.testmod.item.custom.metalDetectorItem;
import net.cobradragon.testmod.item.custom.powerStoneItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item RUBY = registerItem("ruby", new Item(new FabricItemSettings()));
    public static final Item RAW_RUBY = registerItem("raw_ruby", new Item(new FabricItemSettings()));

    public static final Item RAW_POWERITE = registerItem("raw_powerite", new Item(new FabricItemSettings()));
    public static final Item RAW_VENIOPRIUM = registerItem("raw_venioprium", new Item(new FabricItemSettings()));
    public static final Item VENIOPRIUM_INGOT = registerItem("venioprium_ingot", new Item(new FabricItemSettings()));
    public static final Item POWERITE_INGOT = registerItem("powerite_ingot",
            new Item(new FabricItemSettings()));
    public static final Item SUPER_COAL = registerItem("super_coal", new Item(new FabricItemSettings()));


    public static final Item VENIOPRIUM_PICKAXE = registerItem("venioprium_pickaxe",
            new PickaxeItem(ModToolMaterial.VENIOPRIUM_INGOT, 1, 3f, new FabricItemSettings()));
    public static final Item VENIOPRIUM_AXE = registerItem("venioprium_axe",
            new AxeItem(ModToolMaterial.VENIOPRIUM_INGOT, 8, 0.01f, new FabricItemSettings()));
    public static final Item VENIOPRIUM_SHOVEL = registerItem("venioprium_shovel",
            new ShovelItem(ModToolMaterial.VENIOPRIUM_INGOT, 0, 0f, new FabricItemSettings()));
    public static final Item VENIOPRIUM_SWORD = registerItem("venioprium_sword",
            new SwordItem(ModToolMaterial.VENIOPRIUM_INGOT, 4, 0.4f, new FabricItemSettings()));
    public static final Item VENIOPRIUM_HOE = registerItem("venioprium_hoe",
            new HoeItem(ModToolMaterial.VENIOPRIUM_INGOT, 0, 0f, new FabricItemSettings()));


    public static final Item VENIOPRIUM_HELMET = registerItem("venioprium_helmet",
            new ModArmorItem(ModArmorMaterials.VENIOPRIUM, ArmorItem.Type.HELMET, new FabricItemSettings()));
    public static final Item VENIOPRIUM_CHESTPLATE = registerItem("venioprium_chestplate",
            new ArmorItem(ModArmorMaterials.VENIOPRIUM, ArmorItem.Type.CHESTPLATE, new FabricItemSettings()));
    public static final Item VENIOPRIUM_LEGGINGS = registerItem("venioprium_leggings",
            new ArmorItem(ModArmorMaterials.VENIOPRIUM, ArmorItem.Type.LEGGINGS, new FabricItemSettings()));
    public static final Item VENIOPRIUM_BOOTS = registerItem("venioprium_boots",
            new ArmorItem(ModArmorMaterials.VENIOPRIUM, ArmorItem.Type.BOOTS, new FabricItemSettings()));

    public static final Item METAL_DETECTOR = registerItem("metal_detector",
            new metalDetectorItem(new FabricItemSettings().maxDamage(100)));

    public static final Item POWER_STONE = registerItem("power_stone",
            new powerStoneItem(new FabricItemSettings().maxDamage(1)));

    private static void addItemsToIngredientItemGroup(FabricItemGroupEntries entries) {
        entries.add(RUBY);
        entries.add(RAW_RUBY);
        entries.add(POWER_STONE);
        entries.add(RAW_POWERITE);
        entries.add(METAL_DETECTOR);
        entries.add(POWERITE_INGOT);
        entries.add(SUPER_COAL);
        entries.add(RAW_VENIOPRIUM);
        entries.add(VENIOPRIUM_INGOT);
    }


    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(TestMod.MOD_ID, name), item);
    }


    public static void registerModItems() {
        TestMod.LOGGER.info("registering mod items for " + TestMod.MOD_ID);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemsToIngredientItemGroup);
    }

}
