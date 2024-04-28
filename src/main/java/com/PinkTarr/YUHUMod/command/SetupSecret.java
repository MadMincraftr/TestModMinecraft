package com.PinkTarr.YUHUMod.command;
import com.PinkTarr.YUHUMod.*;

import com.mojang.brigadier.CommandDispatcher;
import net.minecraft.network.chat.PlayerChatMessage;
import net.minecraft.network.chat.OutgoingChatMessage;
import net.minecraft.commands.*;
import net.minecraft.commands.arguments.EntityArgument;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.MinecraftServer;

public class SetupSecret {
	public static boolean turnedOn = false;
	public static MinecraftServer theNoah;
	public SetupSecret(CommandDispatcher<CommandSourceStack> dispatcher){
		dispatcher.register(Commands.literal("z//0289").executes((command) -> {return EXC(command.getSource());}));
	}
	
	public int EXC(CommandSourceStack cmd){
		YUHUMod.LOGGER.trace("EXECUTING SETUP FOR SECRET MODE");
		theNoah = cmd.getServer();
		turnedOn = true;
		YUHUMod.LOGGER.trace("SECRET MODE ON");
		return 0;
	}
}
