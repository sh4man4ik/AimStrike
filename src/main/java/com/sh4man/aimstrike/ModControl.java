package com.sh4man.aimstrike;

import net.minecraft.client.Minecraft;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import org.lwjgl.input.Keyboard;

public class ModControl
{
    public static boolean enabled = false;
    private boolean wasClicked = false;

    Minecraft mc = Minecraft.getMinecraft();

    @SubscribeEvent
    public void onClientTick(TickEvent.ClientTickEvent event)
    {
        if (event.phase == TickEvent.Phase.START)
        {
            return;
        }

        boolean clicked = Keyboard.isKeyDown(Keyboard.KEY_P);

        if (clicked && !wasClicked && mc.currentScreen == null)
        {
            enabled = !enabled;
            mc.player.sendStatusMessage(new TextComponentString(enabled ? "AIMSTRIKE ENABLED" : "AIMSTRIKE DISABLED"), true);
        }

        wasClicked = clicked;
    }
}
