package coda.whimsey.registry;

import coda.whimsey.Whimsey;
import coda.whimsey.common.entities.Phoenix;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.apache.http.client.entity.EntityBuilder;

public class WEntities {
    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITIES, Whimsey.MOD_ID);

    public static final RegistryObject<EntityType<Phoenix>> PHOENIX = ENTITIES.register("phoenix", () -> EntityType.Builder.of(Phoenix::new, MobCategory.CREATURE).sized(1.0F, 1.0F).setTrackingRange(16).updateInterval(1).build("phoenix"));
}
