package br.erbatista.brpackstest;

import br.erbatista.brpackstest.entity.ModEntity;
import br.erbatista.brpackstest.entity.custom.GeoTestEntity;
import br.erbatista.brpackstest.render.GeoExampleRenderer;
import net.minecraft.block.Blocks;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import software.bernie.example.registry.EntityRegistry;
import software.bernie.geckolib3.GeckoLib;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(BrPacksTest.MOD_ID)
public class BrPacksTest
{
    // Directly reference a log4j logger.
    private static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "brpackstest";

    public BrPacksTest() {

        GeckoLib.initialize();
        // Register the setup method for modloading
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModEntity.register(modEventBus);

        modEventBus.addListener(this::setup);

        // Register the doClientStuff method for modloading
        modEventBus.addListener(this::doClientStuff);


        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event)
    {
        // some preinit code
        LOGGER.info("HELLO FROM PREINIT");
        LOGGER.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());
    }

    private void doClientStuff(final FMLClientSetupEvent event) {
        // do something that can only be done on the client
        LOGGER.info("Got game settings {}", event.getMinecraftSupplier().get().options);
        registerRenderers(event);
    }

    @OnlyIn(Dist.CLIENT)
    @SubscribeEvent
    public void registerRenderers(final FMLClientSetupEvent event)
    {
        RenderingRegistry.registerEntityRenderingHandler(ModEntity.COLHEITADEIRA.get(),
                manager -> new GeoExampleRenderer(manager));
    }
}
