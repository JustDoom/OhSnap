package com.imjustdoom.ohsnap.mixin;

import com.imjustdoom.ohsnap.OhSnap;
import com.imjustdoom.ohsnap.config.Config;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Mob.class)
public abstract class LeashSnapMixin extends LivingEntity {

    protected LeashSnapMixin(EntityType<? extends LivingEntity> p_20966_, Level p_20967_) {
        super(p_20966_, p_20967_);
    }

    @Inject(method = "dropLeash", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/Mob;spawnAtLocation(Lnet/minecraft/world/level/ItemLike;)Lnet/minecraft/world/entity/item/ItemEntity;"))
    private void dropLeast(boolean bl, boolean bl2, CallbackInfo ci) {
        Level level = this.level();
        if (!level.isClientSide() && OhSnap.SOUND != null) {
            level.playSound(null, this, OhSnap.SOUND, SoundSource.PLAYERS, Config.VOLUME, Config.PITCH);
        }
    }
}
