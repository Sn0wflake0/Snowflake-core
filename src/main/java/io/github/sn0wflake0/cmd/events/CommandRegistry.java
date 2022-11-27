package io.github.sn0wflake0.cmd.events;

import io.github.sn0wflake0.cmd.registry.RegistryTypes;
import io.github.sn0wflake0.cmd.registry.Registry;
import net.minecraft.command.CommandRegistryAccess;
import net.minecraft.server.command.CommandManager;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

public class CommandRegistry {


    public void onEvent(CommandManager.RegistrationEnvironment environment, CommandRegistryAccess commandRegistryAccess, CommandManager commandManager, CallbackInfo ci) {
        Registry.REGISTRY.getList(RegistryTypes.COMMAND_REGISTRY).forEach((commandRegistry) -> commandRegistry.onEvent(new CommandRegistry.EventWrapper(environment, commandRegistryAccess, commandManager, ci, this)));
    }

    public interface Event {
        void onEvent(CommandRegistry.EventWrapper event);
    }

    public record EventWrapper(CommandManager.RegistrationEnvironment environment,
                               CommandRegistryAccess commandRegistryAccess,
                               CommandManager commandManager,
                               CallbackInfo ci,
                               CommandRegistry commandRegistry
    ) {}
}
