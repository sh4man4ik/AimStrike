package com.sh4man.aimstrike;

import com.sh4man.aimstrike.helpers.Camera;
import com.sh4man.aimstrike.helpers.Mouse;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import org.lwjgl.input.Keyboard;

@Mod(modid = AimStrike.MODID, name = AimStrike.NAME, version = AimStrike.VERSION, clientSideOnly = true)
public class AimStrike
{
    public static final String MODID = "aimstrike";
    public static final String NAME = "AimStrike";
    public static final String VERSION = "1.0";
    public static ModControl aimControl;
    public static ModControl leftClickControl;
    public static ModControl rightClickControl;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        MinecraftForge.EVENT_BUS.register(this);
        aimControl = new ModControl("key.aimstrike.toggle_aim", Keyboard.KEY_I, "AIM");
        leftClickControl = new ModControl("key.aimstrike.toggle_left_click", Keyboard.KEY_O, "LEFT CLICK");
        rightClickControl = new ModControl("key.aimstrike.toggle_right_click", Keyboard.KEY_P, "RIGHT CLICK");
    }

    @SubscribeEvent
    public void onClientTick(TickEvent.ClientTickEvent event)
    {
        Minecraft mc = Minecraft.getMinecraft();
        EntityPlayer player = mc.player;

        if (event.phase == TickEvent.Phase.START || mc.world == null || player == null)
        {
            return;
        }

        if (aimControl.isEnabled())
        {
            Entity closestEntity = com.sh4man.aimstrike.helpers.closestEntity.getClosestEntity(mc, player);

            if (closestEntity != null)
            {
                Camera.moveCamera(player, closestEntity);
            }
        }

        if (leftClickControl.isEnabled())
        {
            Mouse.leftClick(mc, player);
        }

        if (rightClickControl.isEnabled())
        {
            Mouse.rightClick(mc);
        }
    }
}
