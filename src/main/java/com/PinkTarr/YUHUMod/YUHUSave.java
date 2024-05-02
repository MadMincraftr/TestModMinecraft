/*package com.PinkTarr.YUHUMod;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.level.saveddata.SavedData;

public class YUHUSave extends SavedData{
    public static final String NAME = YUHUMod.MODID + "_main";

    

    public static YUHUSave create(){
        return new YUHUSave();
    }
    public CompoundTag save(CompoundTag nbt){

    }
    static class YUHUStorage{
        private final int modeID;
        private final String userFocus;
        YUHUStorage(int mode, String user){
            this.modeID = mode;
            this.userFocus = user;
        }
        public CompoundTag deserialize(){
            var nbt = new CompoundTag();
            nbt.putInt("mode",modeID);
            nbt.putString("user", userFocus);
            return nbt;
        }

        public YUHUStorage serialize(CompoundTag nbt){
            return new YUHUStorage(nbt.getInt("mode"), nbt.getString("user"));
        }
    }
}*/
// not done