package io.github.sn0wflake0.cmd.registry;

import io.github.sn0wflake0.cmd.commands.TestMeCommand;
import io.github.sn0wflake0.cmd.events.CommandRegistry;
import io.github.sn0wflake0.cmd.modifiers.MinecraftCmdModifier;
import io.github.sn0wflake0.cmd.events.CommandModifier;
import io.github.sn0wflake0.main.registrybuilder.RegistryBuilder;
import net.minecraft.util.Identifier;

public class Registry {
    public static final RegistryBuilder REGISTRY = new RegistryBuilder();
    private static final CommandModifier.Event MinecraftCommands = new MinecraftCmdModifier();
    private static final CommandRegistry.Event TestMeCommand = new TestMeCommand();
    public static void init() {
        REGISTRY.add(RegistryTypes.COMMAND_MODIFIER, new Identifier("snowflakemc:mc"), MinecraftCommands);
        REGISTRY.add(RegistryTypes.COMMAND_REGISTRY, new Identifier("snowflakemc:testme"), TestMeCommand);
    }
}
