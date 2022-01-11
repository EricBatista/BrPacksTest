package br.erbatista.brpackstest.events;

import br.erbatista.brpackstest.BrPacksTest;
import br.erbatista.brpackstest.entity.ModEntity;
import br.erbatista.brpackstest.entity.custom.GeoTestEntity;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = BrPacksTest.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {

    @SubscribeEvent
    public static void addEntityAttributes(EntityAttributeCreationEvent event) {
        event.put(ModEntity.COLHEITADEIRA.get(), GeoTestEntity.setCustomAttributes().build());
    }
}
