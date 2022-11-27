package io.github.sn0wflake0.cmd.interfaces;

import net.minecraft.command.CommandSource;

import java.util.function.Predicate;

public interface ArgumentBuilderInterface {
    void setPermissions(Predicate<CommandSource> predicate);
}
