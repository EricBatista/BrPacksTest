package br.erbatista.brpackstest.item;

import br.erbatista.brpackstest.BrPacksTest;
import br.erbatista.brpackstest.entity.ModEntityRegister;
import br.erbatista.brpackstest.item.custom.ModSpawnEggItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, BrPacksTest.MOD_ID);

    public static final RegistryObject<ModSpawnEggItem> COLHEITADEIRA_SPAWN = ITEMS.register("colheitadeira_spawn",
            () -> new ModSpawnEggItem(ModEntityRegister.COLHEITADEIRA, 0x879995, 0x576ABC,
                    new Item.Properties().tab(ItemGroup.TAB_MISC)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
