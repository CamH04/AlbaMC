package net.alba.albamod.albamc.entity.render;

import net.alba.albamod.albamc.entity.model.BarnOwlEntityModel;
import net.alba.albamod.albamc.entity.passive.BarnOwlEntity;
import net.alba.albamod.albamc.entity.state.BarnOwlEntityRenderState;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.model.EntityModelLayers;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;

public class BarnOwlEntityRenderer extends MobEntityRenderer<BarnOwlEntity, BarnOwlEntityRenderState, BarnOwlEntityModel> {


    private static final Identifier TEXTURE = Identifier.of("textures/entity/barn_owl/barn_owl.png");

    public BarnOwlEntityRenderer(EntityRendererFactory.Context context) {
        super(context, new BarnOwlEntityModel(context.getPart(EntityModelLayers.PARROT)), 0.3F);
    }

    public Identifier getTexture(BarnOwlEntityRenderState parrotEntityRenderState) {
        return getTexture(TEXTURE);
    }

    private Identifier getTexture(Identifier texture) {
        texture = TEXTURE;
        return TEXTURE;
    }

    public BarnOwlEntityRenderState createRenderState() {
        return new BarnOwlEntityRenderState();
    }

    public void updateRenderState(BarnOwlEntity parrotEntity, BarnOwlEntityRenderState parrotEntityRenderState, float f) {
        super.updateRenderState(parrotEntity, parrotEntityRenderState, f);
        float g = MathHelper.lerp(f, parrotEntity.prevFlapProgress, parrotEntity.flapProgress);
        float h = MathHelper.lerp(f, parrotEntity.prevMaxWingDeviation, parrotEntity.maxWingDeviation);
        parrotEntityRenderState.flapAngle = (MathHelper.sin(g) + 1.0F) * h;
        parrotEntityRenderState.barnOwlPose = BarnOwlEntityModel.getPose(parrotEntity);
    }
}
