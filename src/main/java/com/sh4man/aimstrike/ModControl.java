package com.sh4man.aimstrike;

import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

public class ModControl
{
    private final Minecraft mc = Minecraft.getMinecraft();
    private final KeyBinding toggleKey;
    private final String displayName;
    private boolean enabled = false;

    public ModControl(String keyName, int defaultKey, String displayName)
    {
        this.displayName = displayName;
        this.toggleKey = new KeyBinding(keyName, defaultKey, "key.categories.aimstrike");

        ClientRegistry.registerKeyBinding(toggleKey);
        MinecraftForge.EVENT_BUS.register(this);
    }

    public boolean isEnabled() {
        return enabled;
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
                mc.player.sendStatusMessage(new TextComponentString(displayName + (enabled ? " ENABLED" : " DISABLED")), true);
            }
        }
    }
}
