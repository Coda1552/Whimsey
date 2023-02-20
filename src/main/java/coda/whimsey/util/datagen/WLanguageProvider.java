package coda.whimsey.util.datagen;

import coda.whimsey.Whimsey;
import coda.whimsey.registry.WBlocks;
import coda.whimsey.registry.WEntities;
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
        add(WItems.PHOENIX_SPAWN_EGG.get(), "Phoenix Spawn Egg");
        add(WItems.ASHENSTEEL_INGOT.get(), "Ashensteel Ingot");
        add(WItems.ASHENSTEEL_SWORD.get(), "Ashensteel Blade");
        add(WItems.ASHENSTEEL_AXE.get(), "Ashensteel Waraxe");
        add(WItems.ASHENSTEEL_HOE.get(), "Ashensteel Hoe");
        add(WItems.ASHENSTEEL_PICKAXE.get(), "Ashensteel Pickaxe");
        add(WItems.ASHENSTEEL_SHOVEL.get(), "Ashensteel Shovel");
        add(WItems.ASHENSTEEL_HELMET.get(), "Ashensteel Helmet");
        add(WItems.ASHENSTEEL_CHESTPLATE.get(), "Ashensteel Chestplate");
        add(WItems.ASHENSTEEL_LEGGINGS.get(), "Ashensteel Leggings");
        add(WItems.ASHENSTEEL_BOOTS.get(), "Ashensteel Boots");

        add(WBlocks.ASHENSTEEL_BLOCK.get(), "Block of Ashensteel");

        add(WEntities.PHOENIX.get(), "Phoenix");

        add("itemGroup.whimsey", "Whimsey");

        add("biome.whimsey.regal_meadow", "Regal Meadow");
        add("biome.whimsey.stormy_sea", "Stormy Sea");
        add("biome.whimsey.rolling_hills", "Rolling Hills");
    }
}
