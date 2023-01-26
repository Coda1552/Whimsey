package coda.whimsey;

import coda.whimsey.common.entities.Phoenix;
import coda.whimsey.registry.WBlocks;
import coda.whimsey.registry.WEntities;
import coda.whimsey.registry.WItems;
import coda.whimsey.common.terrablender.WBiomes;
import coda.whimsey.common.terrablender.WOverworldBiomes;
import coda.whimsey.common.terrablender.WRegion;
import coda.whimsey.common.terrablender.WSurfaceRuleData;
import coda.whimsey.util.ClientLevelExtension;
import coda.whimsey.util.datagen.WLanguageProvider;
import net.minecraft.core.BlockPos;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.Biome;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;
import net.minecraftforge.registries.IForgeRegistry;
import terrablender.api.Regions;
import terrablender.api.SurfaceRuleManager;

@Mod(Whimsey.MOD_ID)
public class Whimsey {
    public static final String MOD_ID = "whimsey";
    public static final CreativeModeTab GROUP = new CreativeModeTab(MOD_ID) {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(WItems.PHOENIX_ASHES.get());
        }
    };

    public Whimsey() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        IEventBus forgeBus = MinecraftForge.EVENT_BUS;

        forgeBus.addListener(this::addWeather);

        WItems.ITEMS.register(bus);
        WEntities.ENTITIES.register(bus);
        WBlocks.BLOCKS.register(bus);

        bus.addListener(this::dataGen);
        bus.addListener(this::commonSetup);
        bus.addListener(this::createAttributes);
        bus.addGenericListener(Biome.class, this::registerBiomes);
    }

    private void dataGen(GatherDataEvent e) {
        DataGenerator gen = e.getGenerator();

        gen.addProvider(new WLanguageProvider(gen));
    }

    private void createAttributes(EntityAttributeCreationEvent e) {
        e.put(WEntities.PHOENIX.get(), Phoenix.createAttributes().build());
    }

    private void registerBiomes(RegistryEvent.Register<Biome> e) {
        IForgeRegistry<Biome> registry = e.getRegistry();
        registry.register(WOverworldBiomes.regalMeadow().setRegistryName(WBiomes.REGAL_MEADOW.location()));
        registry.register(WOverworldBiomes.stormySea().setRegistryName(WBiomes.STORMY_SEA.location()));
        registry.register(WOverworldBiomes.rollingHills().setRegistryName(WBiomes.ROLLING_HILLS.location()));
    }

    private void addWeather(TickEvent.PlayerTickEvent e) {
        Player player = e.player;
        BlockPos pos = player.blockPosition();
        Level level = player.level;

        if (level.getBiome(pos).is(WBiomes.STORMY_SEA) && level.isClientSide && !((ClientLevelExtension)level).isDark()) {
            ((ClientLevelExtension)level).setDark(true);
        } else if (!level.getBiome(pos).is(WBiomes.STORMY_SEA) && level.isClientSide && ((ClientLevelExtension)level).isDark()){
            ((ClientLevelExtension)level).setDark(false);
        }

        if (level.random.nextInt(1000) == 0 && level.isClientSide && level.getBiome(pos).is(WBiomes.STORMY_SEA)) {
            level.playLocalSound(pos.getX(), pos.getY(), pos.getZ(), SoundEvents.LIGHTNING_BOLT_THUNDER, SoundSource.WEATHER, 10000.0F, 0.8F + level.random.nextFloat() * 0.2F, false);
            level.playLocalSound(pos.getX(), pos.getY(), pos.getZ(), SoundEvents.LIGHTNING_BOLT_IMPACT, SoundSource.WEATHER, 2.0F, 0.5F + level.random.nextFloat() * 0.2F, false);
        }

        if (level.getBiome(pos).is(WBiomes.STORMY_SEA) && e.player.isPassenger() && e.player.getVehicle() instanceof Boat boat && player.getRandom().nextFloat() > 0.65F) {
            boat.onAboveBubbleCol(true);
        }
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            Regions.register(new WRegion(new ResourceLocation(MOD_ID, "overworld"), 2));

            SurfaceRuleManager.addSurfaceRules(SurfaceRuleManager.RuleCategory.OVERWORLD, MOD_ID, WSurfaceRuleData.makeRules());
        });
    }
}