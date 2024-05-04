package com.PinkTarr.YUHUMod.NetworkPacket;

import java.util.function.Supplier;

import com.PinkTarr.YUHUMod.YUHUMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.PacketDistributor;
import net.minecraftforge.network.simple.SimpleChannel;
public class YUHUPacketHandler {
	public static final String protVer = "1";
	public static SimpleChannel INSTANCE;
	public static void setup(){
		YUHUMod.LOGGER.info("Registering netork!");
		INSTANCE = NetworkRegistry.newSimpleChannel(new ResourceLocation("yuhumod","main"), () ->  protVer, protVer::equals, protVer::equals);
		INSTANCE.messageBuilder(NoahSecretModeEnablePacket.class, 0).encoder(NoahSecretModeEnablePacket::encode).decoder(NoahSecretModeEnablePacket::new).consumerMainThread(YUHUPacketHandler::HandleNoahSecretMode);
		INSTANCE.messageBuilder(UserSecretModeEnablePacket.class, 1).encoder(UserSecretModeEnablePacket::encode).decoder(UserSecretModeEnablePacket::new).consumerMainThread(YUHUPacketHandler::HandleUserSecretMode);
		INSTANCE.messageBuilder(DevWorldScaleSharePacket.class, 2).encoder(DevWorldScaleSharePacket::encode).decoder(DevWorldScaleSharePacket::new).consumerMainThread(YUHUPacketHandler::HandleSharedWorldScale);
	}

	public static void SendToAll(Object msg){
		INSTANCE.send(PacketDistributor.ALL.noArg(), msg);
	}
	public static void SendToAllFromServer(Object msg, MinecraftServer server){
		if (server == null) return;
		for (ServerPlayer p : server.getPlayerList().getPlayers()){
			try {INSTANCE.send(PacketDistributor.PLAYER.with(() -> p), msg);} catch(Exception e){} finally{}
		}
	}

	public static void SendToServer(Object msg){
		INSTANCE.send(PacketDistributor.SERVER.noArg(), msg);
	}

	public static void HandleNoahSecretMode(NoahSecretModeEnablePacket msg, Supplier<NetworkEvent.Context> ctx){
		YUHUMod.LOGGER.error("Why is this happening?");
		/*if (SetupSecret.turnedOn) return;
		SetupSecret.turnedOn = true;
		SetupSecret.theNoah = ctx.get().getSender().server;
		YUHUMod.LOGGER.info("Activated username attack mode for Nooooooah820");*/
	}
	public static void HandleUserSecretMode(UserSecretModeEnablePacket msg, Supplier<NetworkEvent.Context> ctx){
		YUHUMod.LOGGER.info("All attacks now will go to " + msg.username);
	}
	public static void HandleSharedWorldScale(DevWorldScaleSharePacket msg, Supplier<NetworkEvent.Context> ctx){
		YUHUMod.LOGGER.info("recieved debug world scaling.");
		YUHUMod.debugRenderVal = msg.val;
	}
}
