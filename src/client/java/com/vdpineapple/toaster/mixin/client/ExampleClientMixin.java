package com.vdpineapple.toaster.mixin.client;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.*;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.components.toasts.SystemToast;
import net.minecraft.client.gui.components.toasts.ToastComponent;


@Mixin(SystemToast.class)
@Environment(EnvType.CLIENT)
public class ExampleClientMixin {

	@Redirect(method = "render", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/components/toasts/ToastComponent;getNotificationDisplayTimeMultiplier()D"))
	private double redorender(ToastComponent toastComponent) {
		float displayLengthMultiplier = 1.5F;
		return displayLengthMultiplier * toastComponent.getNotificationDisplayTimeMultiplier();
	}

}