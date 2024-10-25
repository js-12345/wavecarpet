package me.wavetech.wavecarpet.mixins.rule.disableOpsBypassWhitelist;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.mojang.authlib.GameProfile;
import me.wavetech.wavecarpet.WaveCarpetSettings;
import net.minecraft.server.dedicated.DedicatedPlayerList;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(DedicatedPlayerList.class)
public class DedicatedPlayerListMixin {
	@WrapOperation(method = "isWhiteListed", at = @At(value = "INVOKE", target = "Lnet/minecraft/server/dedicated/DedicatedPlayerList;isOp(Lcom/mojang/authlib/GameProfile;)Z"))
	private boolean disableOpsBypassWhitelist(DedicatedPlayerList instance, GameProfile gameProfile, Operation<Boolean> original) {
		return !WaveCarpetSettings.disableOpsBypassWhitelist && original.call(instance, gameProfile);
	}
}
