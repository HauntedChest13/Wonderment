package net.teamfruit.wonderment.wonderment;

import net.teamfruit.wonderment.wonderment.core.BiomeInit;
import net.teamfruit.wonderment.wonderment.core.BlockInit;
import net.teamfruit.wonderment.wonderment.core.ConfiguredFeatureInit;
import net.teamfruit.wonderment.wonderment.core.ItemInit;
import net.fabricmc.api.ModInitializer;


public class WondermentMod implements ModInitializer {

    public static final String MOD_ID = "wonderment";
    @Override
    public void onInitialize() {

        BiomeInit.init();
        BlockInit.init();
        ItemInit.init();
        ConfiguredFeatureInit.init();

    }
}
