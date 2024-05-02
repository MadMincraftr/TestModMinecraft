package com.PinkTarr.YUHUMod.command;
import com.PinkTarr.YUHUMod.*;
import com.PinkTarr.YUHUMod.NetworkPacket.NoahSecretModeEnablePacket;
import com.PinkTarr.YUHUMod.NetworkPacket.UserSecretModeEnablePacket;
import com.PinkTarr.YUHUMod.NetworkPacket.YUHUPacketHandler;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.commands.*;
import net.minecraft.commands.arguments.EntityArgument;
public class SetupSecretAlt {
	public static boolean turnedOn;
	public static String user;
	public SetupSecretAlt(CommandDispatcher<CommandSourceStack> dispatcher){
		dispatcher.register(
			Commands.literal("yuhu")
			.then(Commands.literal("customuser")
			.then(Commands.argument("username", EntityArgument.player())
			.executes((command) -> {return EXC(command);})))
			
		);
	}
	
	public int EXC(CommandContext<CommandSourceStack> cmd) throws CommandSyntaxException{
		YUHUMod.LOGGER.debug("EXECUTING SETUP FOR SECRET MODE 2");
		SetupSecret.theNoah = cmd.getSource().getServer();
		SetupSecret.turnedOn = true;
		turnedOn = true;
		user = EntityArgument.getPlayer(cmd, "username").getDisplayName().getString();
		YUHUMod.LOGGER.debug("SECRET MODE 2 ON");
		// I guess it already sends to server automatically.
		/*try {
			YUHUPacketHandler.SendToAll(new UserSecretModeEnablePacket(user));
		} catch (Exception e) {
			YUHUMod.LOGGER.error("Error when attempting to send packet to server. Maybe you are sending from server?");
		}
		finally {
		}*/ 
		return 0;
	}
}
