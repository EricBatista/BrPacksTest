package br.erbatista.brpackstest.model;

import br.erbatista.brpackstest.BrPacksTest;
import br.erbatista.brpackstest.entity.custom.ColheitadeiraEntity;
import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class ColheitadeiraModel extends AnimatedGeoModel<ColheitadeiraEntity> {
    @Override
    public ResourceLocation getModelLocation(ColheitadeiraEntity object) {
        return new ResourceLocation(BrPacksTest.MOD_ID, "geo/colheitadeira.geo.json");
    }

    @Override
    public ResourceLocation getTextureLocation(ColheitadeiraEntity object) {
        return new ResourceLocation(BrPacksTest.MOD_ID, "textures/entity/colheitadeira.png");
    }

    @Override
    public ResourceLocation getAnimationFileLocation(ColheitadeiraEntity animatable) {
        return null;
    }

}
