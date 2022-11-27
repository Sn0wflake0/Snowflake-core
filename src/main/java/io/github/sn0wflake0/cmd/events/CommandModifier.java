package io.github.sn0wflake0.cmd.events;

import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.tree.CommandNode;
import com.mojang.brigadier.tree.LiteralCommandNode;
import com.mojang.brigadier.tree.RootCommandNode;
import io.github.sn0wflake0.cmd.registry.Registry;
import io.github.sn0wflake0.cmd.registry.RegistryTypes;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

public class CommandModifier {
    public void addCommand(RootCommandNode<?> root, LiteralArgumentBuilder<?> command) {
        root.addChild((CommandNode) command.build());
    }
    public void onEvent(LiteralArgumentBuilder<?> command, CallbackInfoReturnable<LiteralCommandNode<?>> event, RootCommandNode<?> root) {
        Registry.REGISTRY.getList(RegistryTypes.COMMAND_MODIFIER).forEach((commandRegistry) -> commandRegistry.onEvent(new EventWrapper(command, event, root, this)));
    }
    public interface Event {
        void onEvent(EventWrapper event);
    }

    public record EventWrapper(LiteralArgumentBuilder<?> command,
                               CallbackInfoReturnable<LiteralCommandNode<?>> event, RootCommandNode<?> root,
                               CommandModifier registry) {

    }
}
