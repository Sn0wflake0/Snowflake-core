package io.github.sn0wflake0.cmd;

import io.github.sn0wflake0.cmd.registry.Registry;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.server.DedicatedServerModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main implements DedicatedServerModInitializer {
    public static final Logger logger = LoggerFactory.getLogger("snowflakemc-cmd");

    @Override
    public void onInitializeServer(ModContainer mod) {
        Registry.init();
        logger.info("✅");
    }
}
