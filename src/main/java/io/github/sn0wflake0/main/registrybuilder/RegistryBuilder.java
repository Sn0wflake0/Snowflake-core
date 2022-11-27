package io.github.sn0wflake0.main.registrybuilder;

import net.minecraft.util.Identifier;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RegistryBuilder {
    private final HashMap<RegistryKey<?>,Object> registries = new HashMap<>();
    public <T> T add(RegistryType<? super T> registryType, Identifier id, T item) {
        registries.put(new RegistryKey<>(registryType, id), item);
        return item;
    }

    public <T> T get(RegistryType<? super T> registryType, Identifier id) {
        var find = registries.get(new RegistryKey<>(registryType, id));
        if(find == null) {
            return null;
        }
        return (T) find;
    }
    public <T> List<T> getList(RegistryType<? super T> registryKey) {
        List<T> values = new ArrayList<>();
        registries.forEach((type, object) -> {
            if(type.registryType() != registryKey) return;
            values.add((T) object);
        });
        return values;
    }
}
