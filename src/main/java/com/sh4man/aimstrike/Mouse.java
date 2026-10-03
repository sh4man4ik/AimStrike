package com.sh4man.aimstrike;

import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;

public class Mouse
{
    public static void click(Minecraft mc, EntityPlayer player, Entity closestEntity)
    {
        double distance = player.getDistance(closestEntity);

        if (distance < 3)
        {
            KeyBinding strike = mc.gameSettings.keyBindAttack;
            KeyBinding.onTick(strike.getKeyCode());
        }
    }
}
