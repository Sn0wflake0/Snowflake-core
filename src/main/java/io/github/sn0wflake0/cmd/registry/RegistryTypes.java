package io.github.sn0wflake0.cmd.registry;

import io.github.sn0wflake0.cmd.events.CommandModifier;
import io.github.sn0wflake0.cmd.events.CommandRegistry;
import io.github.sn0wflake0.main.registrybuilder.RegistryType;

public class RegistryTypes {
    public static final RegistryType<CommandModifier.Event> COMMAND_MODIFIER = new RegistryType<>(CommandModifier.Event.class);
    public static final RegistryType<CommandRegistry.Event> COMMAND_REGISTRY = new RegistryType<>(CommandRegistry.Event.class);
}
