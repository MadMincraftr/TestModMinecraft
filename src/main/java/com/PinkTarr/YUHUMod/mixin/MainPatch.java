package com.PinkTarr.YUHUMod.mixin;
import java.util.List;
import com.PinkTarr.YUHUMod.*;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.*;
import com.google.common.collect.Lists;

import jdk.jshell.execution.Util;

import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Final;

import net.minecraft.world.damagesource.CombatEntry;
import net.minecraft.world.damagesource.CombatTracker;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageSources;
import net.minecraft.world.damagesource.FallLocation;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.commands.arguments.EntityArgument;
@Mixin(LivingEntity.class)
public abstract class MainPatch {
	@Inject(at = @At("HEAD"), method = "hurt", cancellable = true)
	public boolean damage(DamageSource dmgSRC, float dmgAmount, CallbackInfoReturnable<LivingEntity> cir) {
	    //YUHUMod.LOGGER.debug(this.getStringUUID());
	    //YUHUMod.LOGGER.debug(p_289533_.type().toString());
		//if (Config.fuckYouNoah) {
		//	LivingEntity noah = EntityArgument.getPlayer(null, null)
		//}
		LivingEntity thisOBJ = (LivingEntity)(Object)this;
		
		if (dmgSRC.getEntity() != null) {
			   ((LivingEntity)dmgSRC.getEntity()).hurt(thisOBJ.damageSources().genericKill(), dmgAmount);
			   cir.cancel();
		}
		return true;
	}

}