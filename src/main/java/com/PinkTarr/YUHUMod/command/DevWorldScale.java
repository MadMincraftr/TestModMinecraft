package com.PinkTarr.YUHUMod.command;

import com.PinkTarr.YUHUMod.YUHUMod;
import com.PinkTarr.YUHUMod.NetworkPacket.DevWorldScaleSharePacket;
import com.PinkTarr.YUHUMod.NetworkPacket.YUHUPacketHandler;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.FloatArgumentType;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;

import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
public class DevWorldScale {
    public static boolean turnedOn;
	public static String user;
	public DevWorldScale(CommandDispatcher<CommandSourceStack> dispatcher){
		dispatcher.register(
			Commands.literal("yuhu")
			.then(Commands.literal("devworldscale")
			.then(Commands.argument("val",FloatArgumentType.floatArg(0.001f,3f))
			.executes((command) -> {return EXC(command);})))
			
		);
	}
	
	public int EXC(CommandContext<CommandSourceStack> cmd) throws CommandSyntaxException{
        YUHUMod.debugRenderVal = FloatArgumentType.floatArg().getFloat(cmd, "val");
        YUHUPacketHandler.SendToAllFromServer(new DevWorldScaleSharePacket(YUHUMod.debugRenderVal), cmd.getSource().getServer());
		return 0;
	}
}
