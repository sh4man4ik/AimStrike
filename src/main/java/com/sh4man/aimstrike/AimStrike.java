package com.sh4man.aimstrike;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

@Mod(modid = AimStrike.MODID, name = AimStrike.NAME, version = AimStrike.VERSION)
public class AimStrike
{
    public static final String MODID = "aimstrike";
    public static final String NAME = "AimStrike";
    public static final String VERSION = "1.0";

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void onClientTick(TickEvent.ClientTickEvent event)
    {
        Minecraft mc = Minecraft.getMinecraft();
        EntityPlayer player = mc.player;

        if (event.phase != TickEvent.Phase.END || mc.world == null || player == null)
        {
            return;
        }

        Entity closestEntity = NearestEntity.getNearestEntity(mc, player);

        if (closestEntity != null)
        {
            Camera.moveCamera(player, closestEntity);
        }
    }
}
