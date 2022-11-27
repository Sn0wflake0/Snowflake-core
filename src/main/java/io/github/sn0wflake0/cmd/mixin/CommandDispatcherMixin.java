package io.github.sn0wflake0.cmd.mixin;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.tree.LiteralCommandNode;
import com.mojang.brigadier.tree.RootCommandNode;
import io.github.sn0wflake0.cmd.events.CommandModifier;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(CommandDispatcher.class)
public abstract class CommandDispatcherMixin<S> {
    @Shadow @Final private RootCommandNode<S> root;

    @Inject(method = "register", at = @At("HEAD"), cancellable = true, remap=false)
    public void registry(LiteralArgumentBuilder<S> command, CallbackInfoReturnable<LiteralCommandNode<?>> cir) {
        new CommandModifier().onEvent(command, cir, root);
    }
}
