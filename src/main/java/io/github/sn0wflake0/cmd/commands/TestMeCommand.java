package io.github.sn0wflake0.cmd.commands;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import io.github.sn0wflake0.cmd.events.CommandRegistry;
import net.minecraft.command.argument.BlockPosArgumentType;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.tag.BlockTags;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import org.quiltmc.qsl.tag.api.TagType;

public class TestMeCommand implements CommandRegistry.Event {
    private static void register(CommandDispatcher<ServerCommandSource> dispatcher) {
        dispatcher.register(CommandManager.literal("snow:meme").then(
                CommandManager.argument("blockpos", BlockPosArgumentType.blockPos()).executes(TestMeCommand::execute)
        ));
    }

    private static int execute(CommandContext<ServerCommandSource> ctx) throws CommandSyntaxException {
        if (ctx.getSource().getPlayer() == null) {
            return 0;
        }
        var blockPos = BlockPosArgumentType.getBlockPos(ctx, "blockpos");
        var source = ctx.getSource();
        var blockState = source.getWorld().getBlockState(blockPos);
        if (!source.getWorld().getBlockState(blockPos).isIn(BlockTags.SIGNS)) {
            source.sendError(Text.literal("Block is not a sign!").formatted(Formatting.RED));
            return 0;
        }
        return 1;
    }
    @Override
    public void onEvent(CommandRegistry.EventWrapper event) {
        register(event.commandManager().getDispatcher());
    }
}
