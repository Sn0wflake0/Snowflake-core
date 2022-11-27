package io.github.sn0wflake0.cmd.mixin;

import com.mojang.brigadier.builder.ArgumentBuilder;
import io.github.sn0wflake0.cmd.interfaces.ArgumentBuilderInterface;
import net.minecraft.command.CommandSource;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

import java.util.function.Predicate;

@Mixin(ArgumentBuilder.class)
public abstract class ArgumentBuilderMixin implements ArgumentBuilderInterface {


    @Shadow private Predicate<?> requirement;

    @Override
    public void setPermissions(Predicate<CommandSource> predicate) {
        this.requirement = predicate;
    }
}
