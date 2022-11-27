package io.github.sn0wflake0.cmd.mixin;

import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import io.github.sn0wflake0.cmd.interfaces.LiteralArgumentBuilderInterface;
import org.spongepowered.asm.mixin.*;

@Mixin(LiteralArgumentBuilder.class)
public abstract class LiteralArgumentBuilderMixin implements LiteralArgumentBuilderInterface  {
    @Mutable
    @Shadow @Final
    private String literal;

    @Override
    public void setLiteral(String literal) {
        this.literal = literal;
    }
}
