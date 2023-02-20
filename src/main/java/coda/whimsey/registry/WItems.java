package coda.whimsey.registry;

import coda.whimsey.Whimsey;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.*;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class WItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Whimsey.MOD_ID);

    // Spawn Eggs
    public static final RegistryObject<Item> PHOENIX_SPAWN_EGG = ITEMS.register("phoenix_spawn_egg", () -> new ForgeSpawnEggItem(WEntities.PHOENIX, 0xf07a08, 0x9e472e, new Item.Properties().tab(Whimsey.GROUP)));

    // Materials
    public static final RegistryObject<Item> PHOENIX_ASHES = ITEMS.register("phoenix_ashes", () -> new Item(new Item.Properties().tab(Whimsey.GROUP)));
    public static final RegistryObject<Item> ASHENSTEEL_INGOT = ITEMS.register("ashensteel_ingot", () -> new Item(new Item.Properties().tab(Whimsey.GROUP).fireResistant()));

    // Gear
    // todo: custom item tier
    public static final RegistryObject<Item> ASHENSTEEL_SWORD = ITEMS.register("ashensteel_sword", () -> new SwordItem(Tiers.NETHERITE, 3, -2.4F, new Item.Properties().tab(Whimsey.GROUP).fireResistant()));
    public static final RegistryObject<Item> ASHENSTEEL_SHOVEL = ITEMS.register("ashensteel_shovel", () -> new ShovelItem(Tiers.NETHERITE, 1.5F, -3.0F, new Item.Properties().tab(Whimsey.GROUP).fireResistant()));
    public static final RegistryObject<Item> ASHENSTEEL_PICKAXE = ITEMS.register("ashensteel_pickaxe", () -> new PickaxeItem(Tiers.NETHERITE, 1, -2.8F, new Item.Properties().tab(Whimsey.GROUP).fireResistant()));
    public static final RegistryObject<Item> ASHENSTEEL_AXE = ITEMS.register("ashensteel_axe", () -> new AxeItem(Tiers.NETHERITE, 5.0F, -3.0F, new Item.Properties().tab(Whimsey.GROUP).fireResistant()));
    public static final RegistryObject<Item> ASHENSTEEL_HOE = ITEMS.register("ashensteel_hoe", () -> new HoeItem(Tiers.NETHERITE, -4, 0.0F, new Item.Properties().tab(Whimsey.GROUP).fireResistant()));
    public static final RegistryObject<Item> ASHENSTEEL_HELMET = ITEMS.register("ashensteel_helmet", () -> new ArmorItem(ArmorMaterials.NETHERITE, EquipmentSlot.HEAD, new Item.Properties().tab(Whimsey.GROUP).fireResistant()));
    public static final RegistryObject<Item> ASHENSTEEL_CHESTPLATE = ITEMS.register("ashensteel_chestplate", () -> new ArmorItem(ArmorMaterials.NETHERITE, EquipmentSlot.CHEST, new Item.Properties().tab(Whimsey.GROUP).fireResistant()));
    public static final RegistryObject<Item> ASHENSTEEL_LEGGINGS = ITEMS.register("ashensteel_leggings", () -> new ArmorItem(ArmorMaterials.NETHERITE, EquipmentSlot.LEGS, new Item.Properties().tab(Whimsey.GROUP).fireResistant()));
    public static final RegistryObject<Item> ASHENSTEEL_BOOTS = ITEMS.register("ashensteel_boots", () -> new ArmorItem(ArmorMaterials.NETHERITE, EquipmentSlot.FEET, new Item.Properties().tab(Whimsey.GROUP).fireResistant()));
}
