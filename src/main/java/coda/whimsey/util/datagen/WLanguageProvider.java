package coda.whimsey.util.datagen;

import coda.whimsey.Whimsey;
import coda.whimsey.registry.WBlocks;
import coda.whimsey.registry.WItems;
import coda.whimsey.terrablender.WBiomes;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.LanguageProvider;

public class WLanguageProvider extends LanguageProvider {

    public WLanguageProvider(DataGenerator gen) {
        super(gen, Whimsey.MOD_ID, "en_us");
    }

    @Override
    protected void addTranslations() {
        add(WItems.PHOENIX_ASHES.get(), "Phoenix Ashes");
        add(WBlocks.ASHENSTEEL_BLOCK.get(), "Block of Ashensteel");

        add("itemGroup.whimsey", "Whimsey");

        add("biome.whimsey.regal_meadow", "Regal Meadow");
        add("biome.whimsey.stormy_sea", "Stormy Sea");
        add("biome.whimsey.rolling_hills", "Rolling Hills");
    }
}
