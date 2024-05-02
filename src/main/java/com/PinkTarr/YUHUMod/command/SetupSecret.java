package com.PinkTarr.YUHUMod.command;

import com.PinkTarr.YUHUMod.*;
import com.PinkTarr.YUHUMod.NetworkPacket.NoahSecretModeEnablePacket;
import com.PinkTarr.YUHUMod.NetworkPacket.YUHUPacketHandler;
import com.mojang.brigadier.CommandDispatcher;
import net.minecraft.commands.*;
import net.minecraft.server.MinecraftServer;

public class SetupSecret {
	public static boolean turnedOn = false;
	public static MinecraftServer theNoah;

	public SetupSecret(CommandDispatcher<CommandSourceStack> dispatcher) {
		dispatcher.register(Commands.literal("yuhu").then(Commands.literal("noah").executes((command) -> {
			return EXC(command.getSource());
		})));
	}

	public int EXC(CommandSourceStack cmd) {
		YUHUMod.LOGGER.debug("EXECUTING SETUP FOR SECRET MODE");
		theNoah = cmd.getServer();
		turnedOn = true;
		YUHUMod.LOGGER.debug("SECRET MODE ON");
		// I guess it already sends to server automatically. (Again)
		/*try {
			YUHUPacketHandler.SendToServer(new NoahSecretModeEnablePacket());
		} catch (Exception e) {
			YUHUMod.LOGGER.error("Error when attempting to send packet to server. Maybe you are sending from server?");
		}
		finally {
		}*/
		return 0;
	}
}
