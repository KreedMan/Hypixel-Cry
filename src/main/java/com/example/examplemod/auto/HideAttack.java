package com.example.examplemod.auto;

import com.example.examplemod.Main;
import com.example.examplemod.events.AttackEntity;
import com.example.examplemod.events.PacketEvent;
import net.minecraft.network.play.client.C02PacketUseEntity;
import net.minecraft.network.play.client.C09PacketHeldItemChange;
import net.minecraft.network.play.client.C0BPacketEntityAction;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.EnumChatFormatting;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class HideAttack {
    int last_slot = -1;
    @SubscribeEvent
    public void onAttackEntity(AttackEntity event)
    {
        if (Main.configFile.HideAttack) {
            last_slot = Main.mc.thePlayer.inventory.currentItem;
            Main.mc.getNetHandler().getNetworkManager().sendPacket(new C09PacketHeldItemChange(Main.configFile.HideAttackWeaponSlot));
            Thread switch_delay = new Thread(() ->
            {
                try {
                    Thread.sleep(1);
                    Main.mc.thePlayer.sendQueue.addToSendQueue(new C09PacketHeldItemChange(last_slot));
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
            switch_delay.start();
        }
    }
}
