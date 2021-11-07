package net.teamfruit.wonderment.wonderment.core;


import net.teamfruit.wonderment.wonderment.WondermentMod;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.decorator.RangeDecoratorConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.heightprovider.UniformHeightProvider;

@SuppressWarnings("unused")
public class ConfiguredFeatureInit {

    private static ConfiguredFeature<?, ?> ORE_DRENCHSTONE_OVERWORLD = Feature.ORE
            .configure(new OreFeatureConfig(
                    OreFeatureConfig.Rules.BASE_STONE_OVERWORLD,
                    BlockInit.DRENCHSTONE.getDefaultState(),
                    30)) // Vein size
            .range(new RangeDecoratorConfig(
                    // You can also use one of the other height providers if you don't want a uniform distribution
                    UniformHeightProvider.create(YOffset.aboveBottom(16), YOffset.fixed(32)))) // Inclusive min and max height
            .spreadHorizontally()
            .repeat(30); // Number of veins per chunk

    private static ConfiguredFeature<?, ?> ORE_DUNESTONE_OVERWORLD = Feature.ORE
            .configure(new OreFeatureConfig(
                    OreFeatureConfig.Rules.BASE_STONE_OVERWORLD,
                    BlockInit.DUNESTONE.getDefaultState(),
                    12)) // Vein size
            .range(new RangeDecoratorConfig(
                    // You can also use one of the other height providers if you don't want a uniform distribution
                    UniformHeightProvider.create(YOffset.aboveBottom(0), YOffset.fixed(64)))) // Inclusive min and max height
            .spreadHorizontally()
            .repeat(60); // Number of veins per chunk


    public static void init(){
        RegistryKey<ConfiguredFeature<?, ?>> oreDrenshstoneOverworld = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY,
                new Identifier(WondermentMod.MOD_ID, "ore_drenchstone_overworld"));
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, oreDrenshstoneOverworld.getValue(), ORE_DRENCHSTONE_OVERWORLD);
        BiomeModifications.addFeature(BiomeSelectors
                .includeByKey(BiomeKeys.OCEAN,BiomeKeys.COLD_OCEAN,BiomeKeys.DEEP_COLD_OCEAN
                        ,BiomeKeys.DEEP_OCEAN,BiomeKeys.LUKEWARM_OCEAN,BiomeKeys.FROZEN_OCEAN
                        ,BiomeKeys.DEEP_FROZEN_OCEAN,BiomeKeys.DEEP_LUKEWARM_OCEAN), GenerationStep.Feature.UNDERGROUND_ORES, oreDrenshstoneOverworld);

        RegistryKey<ConfiguredFeature<?, ?>> oreDunestoneOverworld = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY,
                new Identifier(WondermentMod.MOD_ID, "ore_dunestone_overworld"));
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, oreDunestoneOverworld.getValue(), ORE_DUNESTONE_OVERWORLD);
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.DESERT, BiomeKeys.DESERT_HILLS, BiomeKeys.DESERT_LAKES), GenerationStep.Feature.UNDERGROUND_ORES, oreDunestoneOverworld);

    }

}
