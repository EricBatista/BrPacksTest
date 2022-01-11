package br.erbatista.brpackstest.model;

import br.erbatista.brpackstest.BrPacksTest;
import br.erbatista.brpackstest.entity.custom.GeoTestEntity;
import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class ColheitadeiraModel extends AnimatedGeoModel<GeoTestEntity> {
    @Override
    public ResourceLocation getModelLocation(GeoTestEntity object) {
        return new ResourceLocation(BrPacksTest.MOD_ID, "geo/colheitadeira.geo.json");
    }

    @Override
    public ResourceLocation getTextureLocation(GeoTestEntity object) {
        return new ResourceLocation(BrPacksTest.MOD_ID, "textures/item/colheitadeira.png");
    }

    @Override
    public ResourceLocation getAnimationFileLocation(GeoTestEntity animatable) {
        return null;
    }
}
