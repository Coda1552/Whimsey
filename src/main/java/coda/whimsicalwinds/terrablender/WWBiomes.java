package coda.whimsicalwinds.terrablender;

import coda.whimsicalwinds.WhimsicalWinds;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;

public class WWBiomes {
    public static final ResourceKey<Biome> REGAL_MEADOW = register("regal_meadow");
    public static final ResourceKey<Biome> STORMY_SEA = register("stormy_sea");
    public static final ResourceKey<Biome> ROLLING_HILLS = register("rolling_hills");

    private static ResourceKey<Biome> register(String name) {
        return ResourceKey.create(Registry.BIOME_REGISTRY, new ResourceLocation(WhimsicalWinds.MOD_ID, name));
    }
}