package com.sh4man.aimstrike.helpers;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;

public class Camera
{
    public static void moveCamera(EntityPlayer player, Entity closestEntity)
    {
        double differenceX = closestEntity.posX - player.posX;
        double differenceY = (closestEntity.posY + closestEntity.getEyeHeight()) - (player.posY + player.getEyeHeight());
        double differenceZ = closestEntity.posZ - player.posZ;

        double distance = Math.sqrt(differenceX * differenceX + differenceZ * differenceZ);

        float yaw = (float) (Math.atan2(differenceZ, differenceX) * 180.0D / Math.PI) - 90.0F;
        float pitch = (float) -(Math.atan2(differenceY, distance) * 180.0D / Math.PI);

        player.rotationYaw = yaw;
        player.rotationPitch = pitch;
    }
}
