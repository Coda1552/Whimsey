package coda.whimsey.util.datagen;

import coda.whimsey.Whimsey;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class WItemModelProvider extends ItemModelProvider {

    public WItemModelProvider(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, Whimsey.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
    }
}
