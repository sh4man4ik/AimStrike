package com.sh4man.aimstrike;

import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import org.lwjgl.input.Keyboard;

public class ModControl
{
    public static boolean enabled = false;
    public static final KeyBinding toggleKey = new KeyBinding("key.aimstrike.toggle", Keyboard.KEY_H, "key.categories.aimstrike");

    Minecraft mc = Minecraft.getMinecraft();

    public static void register()
    {
        ClientRegistry.registerKeyBinding(toggleKey);
    }

    @SubscribeEvent
    public void onClientTick(TickEvent.ClientTickEvent event)
    {
        if (event.phase == TickEvent.Phase.START)
        {
            return;
        }

        while (toggleKey.isPressed())
        {
            enabled = !enabled;

            if (mc.player != null)
            {
                mc.player.sendStatusMessage(new TextComponentString(enabled ? "AIMSTRIKE ENABLED" : "AIMSTRIKE DISABLED"), true);
            }
        }
    }
}
