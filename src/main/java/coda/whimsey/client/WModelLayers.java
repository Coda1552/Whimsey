package coda.whimsey.client;

import coda.whimsey.Whimsey;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;

public class WModelLayers {

    public static final ModelLayerLocation PHOENIX = create("phoenix");

    private static ModelLayerLocation create(String name) {
        return new ModelLayerLocation(new ResourceLocation(Whimsey.MOD_ID, name), "main");
    }
}
