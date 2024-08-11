package me.wavetech.wavecarpet.mixins.feats.suppressionCount;

import com.llamalad7.mixinextras.sugar.Local;
import me.wavetech.wavecarpet.core.ObjectiveCriteriaRegistry;
import net.minecraft.network.PacketListener;
import net.minecraft.network.protocol.PacketUtils;
import net.minecraft.server.network.ServerGamePacketListenerImpl;
import net.minecraft.world.scores.ScoreAccess;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PacketUtils.class)
public class PacketUtilsMixin {
	@Inject(method = "lambda$ensureRunningOnSameThread$0", at = @At(value = "CONSTANT", args = "classValue=net/minecraft/ReportedException", ordinal = 0))
	private static void countSuppression(CallbackInfo ci, @Local(argsOnly = true) PacketListener packetListener) {
		if (packetListener instanceof ServerGamePacketListenerImpl gamePL) {
			gamePL.player.server.getScoreboard()
				.forAllObjectives(ObjectiveCriteriaRegistry.SUPPRESSION_COUNT, gamePL.player, ScoreAccess::increment);
		}
	}
}
