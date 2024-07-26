package com.vdpineapple.toaster;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.command.v2.ClientCommandManager;
import net.fabricmc.fabric.api.client.command.v2.ClientCommandRegistrationCallback;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.components.toasts.SystemToast;
import net.minecraft.commands.arguments.MessageArgument;
import net.minecraft.network.chat.Component;

public class ToasterClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        ClientCommandRegistrationCallback.EVENT.register(
			(dispatcher, registryAccess) -> dispatcher.register(
				ClientCommandManager.literal("toaster").then(ClientCommandManager.argument("message", MessageArgument.message()).executes(context -> {
                    String message = context.getInput().substring(8);
                    StringBuilder sb = new StringBuilder();
                    int i = 0;
                    for (; i < message.length(); i++) {
                        // stop at "|"
                        if (message.charAt(i) == '|') {
                            break;
                        }
                        sb.append(message.charAt(i));
                    }
                    String titleString = sb.toString();
                    sb = new StringBuilder();
                    for (i++; i < message.length(); i++) {
                        sb.append(message.charAt(i));
                    }
                    String contentString = sb.toString();

                    Minecraft minecraft = Minecraft.getInstance();
                    Component title = Component.literal(titleString);
                    Component content = Component.literal(contentString);

                    SystemToast systemToast = SystemToast.multiline(minecraft, SystemToast.SystemToastId.PERIODIC_NOTIFICATION, title, content);
                    minecraft.getToasts().addToast(systemToast);
					return 1;
				})
			)
		));
    }
}