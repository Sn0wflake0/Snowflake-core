package io.github.sn0wflake0.main.registrybuilder;

import net.minecraft.util.Identifier;

public record RegistryKey<T extends RegistryType<?>>(T registryType, Identifier id) {
}
