package coda.whimsey.util.datagen;

import coda.whimsey.Whimsey;
import coda.whimsey.registry.WItems;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.LanguageProvider;

public class WLanguageProvider extends LanguageProvider {

    public WLanguageProvider(DataGenerator gen) {
        super(gen, Whimsey.MOD_ID, "en_us");
    }

    @Override
    protected void addTranslations() {
        add(WItems.PHOENIX_ASHES.get(), "Phoenix Ashes");
    }
}
