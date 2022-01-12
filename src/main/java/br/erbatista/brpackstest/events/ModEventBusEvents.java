package br.erbatista.brpackstest.events;

import br.erbatista.brpackstest.BrPacksTest;
import br.erbatista.brpackstest.entity.ModEntityRegister;
import br.erbatista.brpackstest.entity.custom.ColheitadeiraEntity;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = BrPacksTest.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEventBusEvents {

    @SubscribeEvent
    public static void addEntityAttributes(EntityAttributeCreationEvent event) {
        event.put(ModEntityRegister.COLHEITADEIRA.get(), ColheitadeiraEntity.setCustomAttributes().build());
    }
}
