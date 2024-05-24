package net.cobradragon.testmod.entity.client;

import net.cobradragon.testmod.TestMod;
import net.cobradragon.testmod.entity.custom.VeniopriumShulkerEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.LivingEntityRenderer;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class VeniopriumShulkerRenderer extends LivingEntityRenderer<VeniopriumShulkerEntity,
        VeniopriumShulkerModel<VeniopriumShulkerEntity>> {



    public VeniopriumShulkerRenderer(EntityRendererFactory.Context context, VeniopriumShulkerModel<VeniopriumShulkerEntity> entityModel, float f) {
        super(context, new VeniopriumShulkerModel<>(context.getPart(ModModelLayers.VENIOPRIUMSHLUKER)), 0.6f);
    }

    @Override
    public Identifier getTexture(VeniopriumShulkerEntity entity) {
        return new Identifier(TestMod.MOD_ID, "textures/entity/veniopriumshulker.png");
    }

}
