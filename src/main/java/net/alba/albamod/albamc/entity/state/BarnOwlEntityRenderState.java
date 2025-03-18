package net.alba.albamod.albamc.entity.state;

import net.alba.albamod.albamc.entity.model.BarnOwlEntityModel;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.state.LivingEntityRenderState;
import net.minecraft.entity.passive.ParrotEntity;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class BarnOwlEntityRenderState extends LivingEntityRenderState {
    public float flapAngle;
    public BarnOwlEntityModel.Pose barnOwlPose = BarnOwlEntityModel.Pose.FLYING;
}
