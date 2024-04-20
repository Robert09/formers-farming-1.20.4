package me.formercanuck.formersfarming;

import me.formercanuck.formersfarming.event_handlers.BlockRightClickedHandler;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FormersFarming implements ModInitializer {

    public static final String MOD_ID = "formers-farming";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    private BlockRightClickedHandler blockRightClickedHandler = new BlockRightClickedHandler();

    @Override
    public void onInitialize() {
        registerHandlers();
    }

    private void registerHandlers() {
        blockRightClickedHandler.register();
    }
}