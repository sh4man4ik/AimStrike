package com.sh4man.aimstrike.helpers;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.AxisAlignedBB;

import java.util.List;

public class closestEntity
{
    public static Entity getClosestEntity(Minecraft mc, EntityPlayer player)
    {
        AxisAlignedBB box = player.getEntityBoundingBox().grow(5);
        List<EntityLivingBase> entities = player.world.getEntitiesWithinAABB(EntityLivingBase.class, box);

        Entity closestEntity = null;
        double closestDistance = Double.MAX_VALUE;

        for (Entity entity : entities)
        {
            if (entity == player || entity.isDead)
            {
                continue;
            }

            double distance = player.getDistance(entity);

            if (distance < closestDistance)
            {
                closestDistance = distance;
                closestEntity = entity;
            }
        }

        return closestEntity;
    }
}
