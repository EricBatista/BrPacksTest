package br.erbatista.brpackstest.render;

import br.erbatista.brpackstest.entity.custom.GeoTestEntity;
import br.erbatista.brpackstest.model.ColheitadeiraModel;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererManager;

import software.bernie.geckolib3.geo.render.built.GeoModel;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

import javax.annotation.Nullable;

public class GeoExampleRenderer extends GeoEntityRenderer<GeoTestEntity>
{
    public GeoExampleRenderer(EntityRendererManager renderManager)
    {
        super(renderManager, new ColheitadeiraModel());
        this.shadowRadius = 1F; //change 0.7 to the desired shadow size.
    }

    @Override
    public void render(GeoModel model, GeoTestEntity animatable, float partialTicks, RenderType type, MatrixStack matrixStackIn, @Nullable IRenderTypeBuffer renderTypeBuffer, @Nullable IVertexBuilder vertexBuilder, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) {
        MatrixStack offset = matrixStackIn;
        offset.translate(-1.25d,0d,0d);
        offset.scale(2.5f,2.5f,2.5f);
        super.render(model, animatable, partialTicks, type, offset, renderTypeBuffer, vertexBuilder, packedLightIn, packedOverlayIn, red, green, blue, alpha);
    }
}