package br.erbatista.brpackstest.entity;

import br.erbatista.brpackstest.BrPacksTest;
import br.erbatista.brpackstest.entity.custom.ColheitadeiraEntity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModEntityRegister {
    public static DeferredRegister<EntityType<?>> ENTITY_TYPES
            = DeferredRegister.create(ForgeRegistries.ENTITIES, BrPacksTest.MOD_ID);

    public static final RegistryObject<EntityType<ColheitadeiraEntity>> COLHEITADEIRA =ENTITY_TYPES.register(
            "colheitadeira", () -> EntityType.Builder.of(
                    ColheitadeiraEntity::new, EntityClassification.MISC).sized(2.5f,2f).build("colheitadeira")
    );

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
