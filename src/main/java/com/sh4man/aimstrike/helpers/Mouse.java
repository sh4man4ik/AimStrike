package com.sh4man.aimstrike.helpers;

import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.player.EntityPlayer;

public class Mouse
{
    public static void leftClick(Minecraft mc, EntityPlayer player)
    {
        if (player.getCooledAttackStrength(0) >= 1.0F)
        {
            KeyBinding strike = mc.gameSettings.keyBindAttack;
            KeyBinding.onTick(strike.getKeyCode());
        }
    }

    public static void rightClick(Minecraft mc)
    {
        KeyBinding.onTick(mc.gameSettings.keyBindUseItem.getKeyCode());
    }
}
