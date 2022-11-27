package io.github.sn0wflake0.cmd.mixin;

import io.github.sn0wflake0.cmd.events.CommandRegistry;
import net.minecraft.command.CommandRegistryAccess;
import net.minecraft.server.command.CommandManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(CommandManager.class)
public abstract class CommandManagerMixin {
    @Inject(method = "<init>", at = @At("RETURN"))
    public void onInit(CommandManager.RegistrationEnvironment environment, CommandRegistryAccess commandRegistryAccess, CallbackInfo ci) {
        new CommandRegistry().onEvent(environment, commandRegistryAccess, (CommandManager) (Object) this, ci);
    }
}
