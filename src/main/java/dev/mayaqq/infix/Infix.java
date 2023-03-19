package dev.mayaqq.infix;

import dev.mayaqq.infix.config.InfixConfig;
import net.fabricmc.api.ModInitializer;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

import java.util.logging.Logger;

public class Infix implements ModInitializer {

    public static final Logger LOGGER = Logger.getLogger("Infix");

    public static final TagKey<Item> EXCLUDED = TagKey.of(RegistryKeys.ITEM, new Identifier("infix", "excluded_arrows"));

    @Override
    public void onInitialize() {
        InfixConfig.load();
    }
}
