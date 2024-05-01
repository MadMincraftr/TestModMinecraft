package com.PinkTarr.YUHUMod;

import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.config.ModConfigEvent;
import net.minecraftforge.registries.ForgeRegistries;

// An example config class. This is not required, but it's a good idea to have one to keep your config organized.
// Demonstrates how to use Forge's config APIs
@Mod.EventBusSubscriber(modid = YUHUMod.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class Config
{
    private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();

    private static final ForgeConfigSpec.BooleanValue ALL_WILL_KILL_NOAH = BUILDER
    .comment("(:")
    .define("fuckYouNoah", true);
    private static final ForgeConfigSpec.ConfigValue<String> CUSTOM_USER_NAME = BUILDER
    .comment("The Noah thing but for any player.")
    .define("customPlayerName", "Nooooooah820");
    
    static final ForgeConfigSpec SPEC = BUILDER.build();

    public static boolean fuckYouNoah;

    public static String customPlayerUsername;

    @SuppressWarnings("unused")
    private static boolean validateItemName(final Object obj)
    {
        return obj instanceof final String itemName && ForgeRegistries.ITEMS.containsKey(new ResourceLocation(itemName));
    }

    @SubscribeEvent
    static void onLoad(final ModConfigEvent event)
    {
    	fuckYouNoah = ALL_WILL_KILL_NOAH.get();
        customPlayerUsername = CUSTOM_USER_NAME.get();
    }
}
