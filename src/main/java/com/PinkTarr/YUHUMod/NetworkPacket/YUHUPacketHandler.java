package com.PinkTarr.YUHUMod.NetworkPacket;

import java.util.function.Supplier;

import com.PinkTarr.YUHUMod.YUHUMod;
import com.PinkTarr.YUHUMod.command.SetupSecret;
import com.PinkTarr.YUHUMod.command.SetupSecretAlt;

import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.PacketDistributor;
import net.minecraftforge.network.simple.SimpleChannel;
public class YUHUPacketHandler {
	public static final String protVer = "1";
	public static SimpleChannel INSTANCE;
	public static void setup(){
		INSTANCE = NetworkRegistry.newSimpleChannel(new ResourceLocation("yuhumod","main"), () ->  protVer, protVer::equals, protVer::equals);
		INSTANCE.messageBuilder(NoahSecretModeEnablePacket.class, 0).encoder(NoahSecretModeEnablePacket::encode).decoder(NoahSecretModeEnablePacket::new).consumerMainThread(YUHUPacketHandler::HandleNoahSecretMode);
		INSTANCE.messageBuilder(UserSecretModeEnablePacket.class, 1).encoder(UserSecretModeEnablePacket::encode).decoder(UserSecretModeEnablePacket::new).consumerMainThread(YUHUPacketHandler::HandleUserSecretMode);
	}

	public static void SendToAll(Object msg){
		INSTANCE.send(PacketDistributor.ALL.noArg(), msg);
	}

	public static void SendToServer(Object msg){
		INSTANCE.send(PacketDistributor.SERVER.noArg(), msg);
	}

	public static void HandleNoahSecretMode(NoahSecretModeEnablePacket msg, Supplier<NetworkEvent.Context> ctx){
		if (SetupSecret.turnedOn) return;
		SetupSecret.turnedOn = true;
		SetupSecret.theNoah = ctx.get().getSender().server;
		YUHUMod.LOGGER.info("Activated username attack mode for Nooooooah820");
	}
	public static void HandleUserSecretMode(UserSecretModeEnablePacket msg, Supplier<NetworkEvent.Context> ctx){
		SetupSecretAlt.turnedOn = true;
		SetupSecret.turnedOn = true;
		SetupSecret.theNoah = ctx.get().getSender().server;
		SetupSecretAlt.user = msg.username;
		YUHUMod.LOGGER.info("Activated username attack mode for "+msg.username);
	}
}
