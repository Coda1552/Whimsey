package coda.whimsicalwinds;

import coda.whimsicalwinds.terrablender.WWBiomes;
import coda.whimsicalwinds.terrablender.WWOverworldBiomes;
import coda.whimsicalwinds.terrablender.WWRegion;
import coda.whimsicalwinds.terrablender.WWSurfaceRuleData;
import coda.whimsicalwinds.util.ClientLevelExtension;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.biome.Biome;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.IForgeRegistry;
import terrablender.api.Regions;
import terrablender.api.SurfaceRuleManager;

@Mod(WhimsicalWinds.MOD_ID)
public class WhimsicalWinds {
    public static final String MOD_ID = "whimsicalwinds";

    public WhimsicalWinds() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        IEventBus forgeBus = MinecraftForge.EVENT_BUS;

        forgeBus.addListener(this::addWeather);
        forgeBus.addListener(this::checkSpawns);

        bus.addListener(this::commonSetup);
        bus.addGenericListener(Biome.class, this::registerBiomes);
    }

    private void registerBiomes(RegistryEvent.Register<Biome> event) {
        IForgeRegistry<Biome> registry = event.getRegistry();
        registry.register(WWOverworldBiomes.regalMeadow().setRegistryName(WWBiomes.REGAL_MEADOW.location()));
        registry.register(WWOverworldBiomes.stormySea().setRegistryName(WWBiomes.STORMY_SEA.location()));
        registry.register(WWOverworldBiomes.rollingHills().setRegistryName(WWBiomes.ROLLING_HILLS.location()));
    }

    private void checkSpawns(BiomeLoadingEvent e) {
    }

    private void addWeather(TickEvent.PlayerTickEvent e) {
        Player player = e.player;
        BlockPos pos = player.blockPosition();
        Level level = player.level;

        if (level.getBiome(pos).is(WWBiomes.STORMY_SEA) && level.isClientSide && !((ClientLevelExtension)level).isDark()) {
            ((ClientLevelExtension)level).setDark(true);
        } else if (!level.getBiome(pos).is(WWBiomes.STORMY_SEA) && level.isClientSide && ((ClientLevelExtension)level).isDark()){
            ((ClientLevelExtension)level).setDark(false);
        }

        if (level.random.nextInt(1000) == 0 && level.isClientSide && level.getBiome(pos).is(WWBiomes.STORMY_SEA)) {
            level.playLocalSound(pos.getX(), pos.getY(), pos.getZ(), SoundEvents.LIGHTNING_BOLT_THUNDER, SoundSource.WEATHER, 10000.0F, 0.8F + level.random.nextFloat() * 0.2F, false);
            level.playLocalSound(pos.getX(), pos.getY(), pos.getZ(), SoundEvents.LIGHTNING_BOLT_IMPACT, SoundSource.WEATHER, 2.0F, 0.5F + level.random.nextFloat() * 0.2F, false);
        }

        if (level.getBiome(pos).is(WWBiomes.STORMY_SEA) && e.player.isPassenger() && e.player.getVehicle() instanceof Boat boat && player.getRandom().nextFloat() > 0.65F) {
            boat.onAboveBubbleCol(true);
        }
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            Regions.register(new WWRegion(new ResourceLocation(MOD_ID, "overworld"), 2));

            SurfaceRuleManager.addSurfaceRules(SurfaceRuleManager.RuleCategory.OVERWORLD, MOD_ID, WWSurfaceRuleData.makeRules());
        });
    }
}