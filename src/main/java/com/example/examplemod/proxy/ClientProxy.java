package com.example.examplemod.proxy;

import com.example.examplemod.MacrosRegister;
import com.example.examplemod.Main;
import com.example.examplemod.commands.OpenSettings;
import com.example.examplemod.commands.iteminfocommand;
import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.lwjgl.input.Keyboard;

import java.io.File;

import static com.example.examplemod.Main.keyBindings;

public class ClientProxy extends CommonProxy {
    @Override
    public void preInit(FMLPreInitializationEvent event)
    {
        super.preInit(event);
    }

    @Override
    public void init(FMLInitializationEvent event)
    {
        keyBindings = new KeyBinding[6];


        keyBindings[0] = new KeyBinding("Rogue Sword", Keyboard.KEY_P, "Hypixel Macros");
        keyBindings[1] = new KeyBinding("Wand of Healing", Keyboard.KEY_X, "Hypixel Macros");
        keyBindings[2] = new KeyBinding("Aspect of the End", Keyboard.KEY_X, "Hypixel Macros");

        keyBindings[3] = new KeyBinding("Ore nuker", Keyboard.KEY_X, "Hypixel Nuker");
        keyBindings[4] = new KeyBinding("Crop nuker", Keyboard.KEY_X, "Hypixel Nuker");
        keyBindings[5] = new KeyBinding("Sand nuker", Keyboard.KEY_X, "Hypixel Nuker");

        for (KeyBinding keyBinding : keyBindings) {
            ClientRegistry.registerKeyBinding(keyBinding);
        }

        new MacrosRegister().register(event);

        ClientCommandHandler.instance.registerCommand(new iteminfocommand());
        ClientCommandHandler.instance.registerCommand(new OpenSettings());
        super.init(event);
    }

    @Override
    public void postInit(FMLPostInitializationEvent event)
    {
        super.postInit(event);
    }
}
