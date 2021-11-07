package net.teamfruit.wonderment.wonderment.core;

import net.fabricmc.fabric.api.biome.v1.OverworldBiomes;
import net.fabricmc.fabric.api.biome.v1.OverworldClimate;
import net.minecraft.block.Blocks;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.surfacebuilder.ConfiguredSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilder.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilder.TernarySurfaceConfig;
import net.teamfruit.wonderment.wonderment.common.world.biomes.DunestonePlainsBiome;

public class BiomeInit {
    //Dunestone Plains
    public static final RegistryKey<Biome> DUNESTONE_PLAINS_KEY = RegistryKey.of(Registry.BIOME_KEY, new Identifier("wonderment", "dunestone_plains"));
    private static final Biome DUNESTONE_PLAIN = DunestonePlainsBiome.createDunestonePlain();
    private static final ConfiguredSurfaceBuilder<TernarySurfaceConfig> DUNESTONE_PLAINS_SURFACE_BUILDER = SurfaceBuilder.NETHER_FOREST
            .withConfig(new TernarySurfaceConfig(
                    Blocks.SAND.getDefaultState(),
                    BlockInit.DUNESTONE.getDefaultState(),
                    Blocks.SANDSTONE.getDefaultState()));

    public static void init() {
        //Dunestone Plains
        Registry.register(BuiltinRegistries.CONFIGURED_SURFACE_BUILDER, new Identifier("wonderment", "dunestone"), DUNESTONE_PLAINS_SURFACE_BUILDER);
        Registry.register(BuiltinRegistries.BIOME, DUNESTONE_PLAINS_KEY.getValue(), DUNESTONE_PLAIN);
        OverworldBiomes.addContinentalBiome(DUNESTONE_PLAINS_KEY, OverworldClimate.COOL, 3D);
        OverworldBiomes.addContinentalBiome(DUNESTONE_PLAINS_KEY, OverworldClimate.DRY, 3D);
    }
}
