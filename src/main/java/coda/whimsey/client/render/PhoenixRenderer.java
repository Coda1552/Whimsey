package coda.whimsey.client.render;

import coda.whimsey.Whimsey;
import coda.whimsey.client.WModelLayers;
import coda.whimsey.client.model.PhoenixModel;
import coda.whimsey.common.entities.Phoenix;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class PhoenixRenderer extends MobRenderer<Phoenix, PhoenixModel<Phoenix>> {
    private static final ResourceLocation TEX = new ResourceLocation(Whimsey.MOD_ID, "textures/entity/phoenix.png");

    public PhoenixRenderer(EntityRendererProvider.Context pContext) {
        super(pContext, new PhoenixModel<>(pContext.bakeLayer(WModelLayers.PHOENIX)), 0.6F);
    }

    @Override
    public ResourceLocation getTextureLocation(Phoenix pEntity) {
        return TEX;
    }
}
