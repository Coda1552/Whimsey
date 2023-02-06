package coda.whimsey.registry;

import coda.whimsey.Whimsey;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class WItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Whimsey.MOD_ID);

    public static final RegistryObject<Item> PHOENIX_ASHES = ITEMS.register("phoenix_ashes", () -> new Item(new Item.Properties().tab(Whimsey.GROUP)));

    public static final RegistryObject<Item> PHOENIX_SPAWN_EGG = ITEMS.register("phoenix_spawn_egg", () -> new ForgeSpawnEggItem(WEntities.PHOENIX, 0xf07a08, 0x9e472e, new Item.Properties().tab(Whimsey.GROUP)));

    public static final RegistryObject<Item> ASHENSTEEL_INGOT = ITEMS.register("ashensteel_ingot", () -> new Item(new Item.Properties().tab(Whimsey.GROUP).fireResistant()));
}
