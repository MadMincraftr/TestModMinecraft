package com.PinkTarr.YUHUMod;

import com.PinkTarr.YUHUMod.NetworkPacket.YUHUPacketHandler;
import com.PinkTarr.YUHUMod.command.SetupSecret;
import com.PinkTarr.YUHUMod.command.SetupSecretAlt;

import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import com.mojang.logging.LogUtils;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.*;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(YUHUMod.MODID)
public class YUHUMod
{
    // Define mod id in a common place for everything to reference
    public static final String MODID = "yuhumod";
    // Directly reference a slf4j logger
    public static final Logger LOGGER = LogUtils.getLogger();

    public YUHUMod()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);
        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
        // Register our mod's ForgeConfigSpec so that Forge can create and load the config file for us
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {
        
    }
    private void commonSetup(final FMLCommonSetupEvent event)
    {
        if (Config.fuckYouNoah)
            LOGGER.info("Fuck you noah; or whoever the command attacks");
    }

    public String getPlayerNameToKill(){
        if (SetupSecretAlt.turnedOn){
            return SetupSecretAlt.user;
        }
        else if  (SetupSecret.turnedOn){
            return "Nooooooah820";
        }
        else return "Dev";
    }


    @Mod.EventBusSubscriber(modid = MODID, bus = Bus.FORGE)
    public static class ClientModEvents
    {
    	@SubscribeEvent
        public static void onEntityDamage(LivingDamageEvent event) {
    		// LOGGER.debug("debugdamage");
        	if (event.getSource().getEntity() != null) {
    			   if (!(SetupSecret.turnedOn))event.getSource().getEntity().hurt(event.getEntity().damageSources().genericKill(), event.getAmount());
    			   else {
    				   if (SetupSecret.theNoah != null) {
    					   var noah = SetupSecret.theNoah.getPlayerList().getPlayerByName("");
    					   if (noah != null)
    						   noah.hurt(event.getEntity().damageSources().genericKill(),event.getAmount());
        				   
    				   }
    					   else {
    					   SetupSecret.turnedOn = false;
    				   }
    			   }
    			   event.setCanceled(true);
    			   return;
    		}
        	 event.setCanceled(false);
        	 return;
        }

        @SubscribeEvent
        public static void commonSetup(FMLCommonSetupEvent event){
            event.enqueueWork(() -> YUHUPacketHandler.setup());
        }

        @SubscribeEvent
        public static void onCommandsRegister(RegisterCommandsEvent event) {
        	new SetupSecret(event.getDispatcher());
            new SetupSecretAlt(event.getDispatcher());
        }
    }
}
