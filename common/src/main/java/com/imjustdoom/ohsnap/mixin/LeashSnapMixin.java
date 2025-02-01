package com.imjustdoom.ohsnap.mixin;

import com.imjustdoom.ohsnap.OhSnap;
import com.imjustdoom.ohsnap.config.Config;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Leashable.class)
public interface LeashSnapMixin {

    @Inject(method = "dropLeash(Lnet/minecraft/world/entity/Entity;ZZ)V", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/Entity;spawnAtLocation(Lnet/minecraft/server/level/ServerLevel;Lnet/minecraft/world/level/ItemLike;)Lnet/minecraft/world/entity/item/ItemEntity;"))
    private static <E extends Entity & Leashable> void dropLeast(E entity, boolean bl, boolean bl2, CallbackInfo ci) {
        Level level = entity.level();
        if (!level.isClientSide() && OhSnap.SOUND != null) {
            level.playSound(null, entity, OhSnap.SOUND, SoundSource.PLAYERS, Config.VOLUME, Config.PITCH);
        }
    }
}
