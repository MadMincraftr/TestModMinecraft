package com.PinkTarr.YUHUMod.NetworkPacket;

import net.minecraft.network.FriendlyByteBuf;

// For sharing the broken render (why?)
public class DevWorldScaleSharePacket {
    public float val;

    public DevWorldScaleSharePacket(float value){
        this.val = value;
    }

    public DevWorldScaleSharePacket(FriendlyByteBuf buffer){
        new DevWorldScaleSharePacket(buffer.readFloat());
    }
    public void encode(FriendlyByteBuf buffer){
        buffer.writeFloat(val);
    }
    
}
