package br.erbatista.brpackstest.entity;

import br.erbatista.brpackstest.BrPacksTest;
import br.erbatista.brpackstest.entity.custom.GeoTestEntity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import static software.bernie.example.registry.EntityRegistry.buildEntity;

public class ModEntity {
    public static DeferredRegister<EntityType<?>> ENTITY_TYPES
            = DeferredRegister.create(ForgeRegistries.ENTITIES, BrPacksTest.MOD_ID);

    public static final RegistryObject<EntityType<GeoTestEntity>> COLHEITADEIRA =ENTITY_TYPES.register(
            "colheitadeira", () -> EntityType.Builder.of(
                    GeoTestEntity::new, EntityClassification.MISC).sized(1f,1f).build("colheitadeira")
    );

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
