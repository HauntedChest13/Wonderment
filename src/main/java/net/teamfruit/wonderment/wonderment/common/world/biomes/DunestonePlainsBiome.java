package net.teamfruit.wonderment.wonderment.common.world.biomes;

import net.minecraft.block.Blocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeEffects;
import net.minecraft.world.biome.GenerationSettings;
import net.minecraft.world.biome.SpawnSettings;
import net.minecraft.world.gen.feature.DefaultBiomeFeatures;
import net.minecraft.world.gen.surfacebuilder.ConfiguredSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilder.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilder.TernarySurfaceConfig;
import net.teamfruit.wonderment.wonderment.core.BlockInit;

public class DunestonePlainsBiome {
    private static final ConfiguredSurfaceBuilder<TernarySurfaceConfig> DUNESTONE_PLAINS_SURFACE_BUILDER = SurfaceBuilder.NETHER_FOREST
            .withConfig(new TernarySurfaceConfig(
                    Blocks.SAND.getDefaultState(),
                    BlockInit.DUNESTONE.getDefaultState(),
                    Blocks.SANDSTONE.getDefaultState()));

    private static final Biome DUNESTONE_PLAIN = createDunestonePlain();

    public static Biome createDunestonePlain() {
        SpawnSettings.Builder spawnSettings = new SpawnSettings.Builder();
        DefaultBiomeFeatures.addFarmAnimals(spawnSettings);
        DefaultBiomeFeatures.addMonsters(spawnSettings, 95, 15, 100);

        GenerationSettings.Builder generationSettings = new GenerationSettings.Builder();
        generationSettings.surfaceBuilder(DUNESTONE_PLAINS_SURFACE_BUILDER);
        DefaultBiomeFeatures.addDefaultUndergroundStructures(generationSettings);
        DefaultBiomeFeatures.addAmethystGeodes(generationSettings);
        DefaultBiomeFeatures.addBadlandsVegetation(generationSettings);
        DefaultBiomeFeatures.addDungeons(generationSettings);
        DefaultBiomeFeatures.addMineables(generationSettings);
        DefaultBiomeFeatures.addDesertDeadBushes(generationSettings);
        DefaultBiomeFeatures.addDefaultDisks(generationSettings);

        return (new Biome.Builder())
                .precipitation(Biome.Precipitation.RAIN)
                .category(Biome.Category.DESERT)
                .depth(0.25f)
                .scale(0.5f)
                .temperature(2f)
                .downfall(0.1f)
                .effects((new BiomeEffects.Builder())
                        .waterColor(0x8af4e3)
                        .waterFogColor(0x114c42)
                        .fogColor(0xc4b87c)
                        .skyColor(0xb3ab84)
                        .build())
                .spawnSettings(spawnSettings.build())
                .generationSettings(generationSettings.build())
                .build();


    }


}
