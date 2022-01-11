package br.erbatista.brpackstest.render;

import br.erbatista.brpackstest.entity.custom.GeoTestEntity;
import br.erbatista.brpackstest.model.ColheitadeiraModel;
import net.minecraft.client.renderer.entity.EntityRendererManager;

import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class GeoExampleRenderer extends GeoEntityRenderer<GeoTestEntity>
{
    public GeoExampleRenderer(EntityRendererManager renderManager)
    {
        super(renderManager, new ColheitadeiraModel());
        this.shadowRadius = 0.7F; //change 0.7 to the desired shadow size.
    }
}