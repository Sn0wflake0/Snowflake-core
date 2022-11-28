package io.github.sn0wflake0.cmd.registry;

import io.github.sn0wflake0.cmd.commands.TestMeCommand;
import io.github.sn0wflake0.cmd.events.CommandRegistry;
import io.github.sn0wflake0.main.registrybuilder.RegistryBuilder;
import net.minecraft.util.Identifier;

public class Registry {
    public static final RegistryBuilder REGISTRY = new RegistryBuilder();
    private static final CommandRegistry.Event TestMeCommand = new TestMeCommand();
    public static void init() {
        REGISTRY.add(RegistryTypes.COMMAND_REGISTRY, new Identifier("snowflakemc:testme"), TestMeCommand);
    }
}
