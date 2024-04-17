package command;
import com.PinkTarr.YUHUMod.*;

import com.mojang.brigadier.CommandDispatcher;
import net.minecraft.commands.*;

public class SetupSecret {
	SetupSecret(CommandDispatcher<CommandSource> dispatcher){
		// dispatcher.register(Commands.literal("/0289").then(Commands.literal("user").executes((command) -> {return EXC();})));
	}
	
	public int EXC() {
		YUHUMod.LOGGER.trace("EXECUTING SETUP FOR SECRET MODE");
		return 0;
	}
}
