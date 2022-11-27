package io.github.sn0wflake0.cmd.modifiers;

import io.github.sn0wflake0.cmd.events.CommandModifier;
import io.github.sn0wflake0.cmd.interfaces.ArgumentBuilderInterface;
import io.github.sn0wflake0.cmd.interfaces.LiteralArgumentBuilderInterface;

public class MinecraftCmdModifier implements CommandModifier.Event {
    @Override
    public void onEvent(CommandModifier.EventWrapper event) {
        var eventCommand = event.command();
        if(eventCommand.getLiteral().startsWith("snow:")) {
            ((LiteralArgumentBuilderInterface)eventCommand).setLiteral(eventCommand.getLiteral().substring(5));
            event.registry().addCommand(event.root(), eventCommand);
            event.event().cancel();
            return;
        }
        ((LiteralArgumentBuilderInterface)eventCommand).setLiteral(":"+ event.command().getLiteral());
        ((ArgumentBuilderInterface)eventCommand).setPermissions((source) -> source.hasPermissionLevel(4));
        event.registry().addCommand(event.root(), eventCommand);
        event.event().cancel();
    }
}
