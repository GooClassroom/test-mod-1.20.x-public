package net.cobradragon.testmod;

import net.cobradragon.testmod.block.ModBlocks;
import net.cobradragon.testmod.entity.ModEntities;
import net.cobradragon.testmod.entity.client.ModModelLayers;
import net.cobradragon.testmod.entity.client.VeniopriumShulkerModel;
import net.cobradragon.testmod.entity.client.VeniopriumShulkerRenderer;
import net.cobradragon.testmod.entity.custom.VeniopriumShulkerEntity;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.fabricmc.fabric.impl.client.rendering.EntityRendererRegistryImpl;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.RenderLayers;
import net.minecraft.client.render.entity.EntityRendererFactory;

public class TestModClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.VENIOPRIUM_DOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.VENIOPRIUM_TRAPDOOR, RenderLayer.getCutout());



        EntityModelLayerRegistry.registerModelLayer(ModModelLayers.VENIOPRIUMSHLUKER, VeniopriumShulkerModel::getTexturedModelData);
    
    }
}
