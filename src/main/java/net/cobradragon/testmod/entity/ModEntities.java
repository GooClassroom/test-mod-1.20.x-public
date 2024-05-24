package net.cobradragon.testmod.entity;

import net.cobradragon.testmod.TestMod;
import net.cobradragon.testmod.entity.custom.VeniopriumShulkerEntity;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEntities {
    public static final EntityType<VeniopriumShulkerEntity> VENIOPRIUMSHULKER = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(TestMod.MOD_ID, "veniopriumshulker"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, VeniopriumShulkerEntity::new)
                    .dimensions(EntityDimensions.fixed(1f, 1f)).build());
}
