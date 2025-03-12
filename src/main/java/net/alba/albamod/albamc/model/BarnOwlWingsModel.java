package net.alba.albamod.albamc.model;

import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.render.entity.state.EntityRenderState;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;

public class BarnOwlWingsModel extends EntityRenderState{
    private final ModelPart elytra;
    private final ModelPart left_wing;
    private final ModelPart right_wing;
    public BarnOwlWingsModel(ModelPart root) {
        this.elytra = root.getChild("elytra");
        this.left_wing = this.elytra.getChild("left_wing");
        this.right_wing = this.elytra.getChild("right_wing");
    }
    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();
        ModelPartData elytra = modelPartData.addChild("elytra", ModelPartBuilder.create(), ModelTransform.pivot(-14.0F, 0.0F, 1.0F));

        ModelPartData left_wing = elytra.addChild("left_wing", ModelPartBuilder.create().uv(22, 0).cuboid(-10.0F, 4.0F, 0.0F, 10.0F, 20.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -4.0F, 0.0F));

        ModelPartData right_wing = elytra.addChild("right_wing", ModelPartBuilder.create().uv(22, 0).mirrored().cuboid(0.0F, 4.0F, 0.0F, 10.0F, 20.0F, 2.0F, new Dilation(0.0F)).mirrored(false), ModelTransform.pivot(0.0F, -4.0F, 0.0F));
        return TexturedModelData.of(modelData, 64, 32);
    }
    public void setAngles(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
    }
    public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
        elytra.render(matrices, vertexConsumer, light, overlay);
    }
}
