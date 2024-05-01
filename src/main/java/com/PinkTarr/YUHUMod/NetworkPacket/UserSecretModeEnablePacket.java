package com.PinkTarr.YUHUMod.NetworkPacket;

import net.minecraft.network.FriendlyByteBuf;

public class UserSecretModeEnablePacket {
    public String username;

    public UserSecretModeEnablePacket(String user){
        this.username = user;
    }

    public UserSecretModeEnablePacket(FriendlyByteBuf buffer){
        new UserSecretModeEnablePacket(buffer.readUtf());
    }
    public void encode(FriendlyByteBuf buffer){
        buffer.writeUtf(username);
    }
    
}
