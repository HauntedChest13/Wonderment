package net.teamfruit.wonderment.wonderment.core;

import net.minecraft.block.*;
import net.minecraft.entity.EntityType;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.BlockView;
import net.teamfruit.wonderment.wonderment.common.blocks.ModStairs;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;


@SuppressWarnings("unused")
public class BlockInit {
    private static final Map<Block, String> REGISTRY = new HashMap<>();

    //Blocks Go Here
    public static final Block DUNESTONE = register("dunestone",
            new Block(AbstractBlock.Settings.copy(Blocks.BLACKSTONE)), (settings) -> settings.group(ItemGroup.BUILDING_BLOCKS));

    public static final Block DUNESTONE_STAIRS = register("dunestone_stairs",
            new ModStairs(DUNESTONE.getDefaultState(), AbstractBlock.Settings.copy(DUNESTONE)), (settings) -> settings.group(ItemGroup.BUILDING_BLOCKS));

    public static final Block DUNESTONE_SLAB = register("dunestone_slab",
            new SlabBlock(AbstractBlock.Settings.copy(DUNESTONE)), (settings) -> settings.group(ItemGroup.BUILDING_BLOCKS));

    public static final Block POLISHED_DUNESTONE = register("polished_dunestone",
            new Block(AbstractBlock.Settings.copy(DUNESTONE)), (settings) -> settings.group(ItemGroup.BUILDING_BLOCKS));

    public static final Block POLISHED_DUNESTONE_STAIRS = register("polished_dunestone_stairs",
            new ModStairs(POLISHED_DUNESTONE.getDefaultState(),AbstractBlock.Settings.copy(DUNESTONE)), (settings) -> settings.group(ItemGroup.BUILDING_BLOCKS));

    public static final Block POLISHED_DUNESTONE_SLAB = register("polished_dunestone_slab",
            new SlabBlock(AbstractBlock.Settings.copy(DUNESTONE)), (settings) -> settings.group(ItemGroup.BUILDING_BLOCKS));

    public static final Block DUNESTONE_BRICKS = register("dunestone_bricks",
            new Block(AbstractBlock.Settings.copy(DUNESTONE)), (settings) -> settings.group(ItemGroup.BUILDING_BLOCKS));

    public static final Block DUNESTONE_BRICK_STAIRS = register("dunestone_brick_stairs",
            new ModStairs(DUNESTONE_BRICKS.getDefaultState(), AbstractBlock.Settings.copy(DUNESTONE)), (settings) -> settings.group(ItemGroup.BUILDING_BLOCKS));

    public static final Block DUNESTONE_BRICK_SLAB = register("dunestone_brick_slab",
            new SlabBlock(AbstractBlock.Settings.copy(DUNESTONE)), (settings) -> settings.group(ItemGroup.BUILDING_BLOCKS));

    public static final Block CRACKED_DUNESTONE_BRICKS = register("cracked_dunestone_bricks",
            new Block(AbstractBlock.Settings.copy(DUNESTONE)), (settings) -> settings.group(ItemGroup.BUILDING_BLOCKS));

    public static final Block CHISELED_DUNESTONE = register("chiseled_dunestone",
            new Block(AbstractBlock.Settings.copy(DUNESTONE)), (settings) -> settings.group(ItemGroup.BUILDING_BLOCKS));



    public static final Block DRENCHSTONE = register("drenchstone",
            new Block(AbstractBlock.Settings.copy(Blocks.STONE).sounds(BlockSoundGroup.TUFF)),
            (settings) -> settings.group(ItemGroup.BUILDING_BLOCKS));

    public static final Block DRENCHSTONE_STAIRS = register("drenchstone_stairs",
            new ModStairs(DRENCHSTONE.getDefaultState(), AbstractBlock.Settings.copy(DRENCHSTONE)),
            (settings) -> settings.group(ItemGroup.BUILDING_BLOCKS));

    public static final Block DRENCHSTONE_SLAB = register("drenchstone_slab",
            new SlabBlock(AbstractBlock.Settings.copy(DRENCHSTONE)),
            (settings) -> settings.group(ItemGroup.BUILDING_BLOCKS));

    public static final Block POLISHED_DRENCHSTONE = register("polished_drenchstone",
            new Block(AbstractBlock.Settings.copy(DRENCHSTONE)),
            (settings) -> settings.group(ItemGroup.BUILDING_BLOCKS));

    public static final Block POLISHED_DRENCHSTONE_STAIRS = register("polished_drenchstone_stairs",
            new ModStairs(POLISHED_DRENCHSTONE.getDefaultState(),AbstractBlock.Settings.copy(DRENCHSTONE)),
            (settings) -> settings.group(ItemGroup.BUILDING_BLOCKS));

    public static final Block POLISHED_DRENCHSTONE_SLAB = register("polished_drenchstone_slab",
            new SlabBlock(AbstractBlock.Settings.copy(DRENCHSTONE)),
            (settings) -> settings.group(ItemGroup.BUILDING_BLOCKS));

    public static final Block DRENCHSTONE_BRICKS = register("drenchstone_bricks",
            new Block(AbstractBlock.Settings.copy(DRENCHSTONE)),
            (settings) -> settings.group(ItemGroup.BUILDING_BLOCKS));

    public static final Block DRENCHSTONE_BRICK_STAIRS = register("drenchstone_brick_stairs",
            new ModStairs(DRENCHSTONE_BRICKS.getDefaultState(), AbstractBlock.Settings.copy(DRENCHSTONE)),
            (settings) -> settings.group(ItemGroup.BUILDING_BLOCKS));

    public static final Block DRENCHSTONE_BRICK_SLAB = register("drenchstone_brick_slab",
            new SlabBlock(AbstractBlock.Settings.copy(DRENCHSTONE)),
            (settings) -> settings.group(ItemGroup.BUILDING_BLOCKS));

    public static final Block CRACKED_DRENCHSTONE_BRICKS = register("cracked_drenchstone_bricks",
            new Block(AbstractBlock.Settings.copy(DRENCHSTONE)),
            (settings) -> settings.group(ItemGroup.BUILDING_BLOCKS));

    private static <B extends Block> B register(String id, B block, Function<Item.Settings, Item.Settings> modifier) {
        Item.Settings defaultSettings = ItemInit.MISC.get();
        ItemInit.register(id, new BlockItem(block, modifier.apply(defaultSettings)));
        return registerNoItem(id, block);
    }

    private static <B extends Block> B register(String id, B block) {
        return register(id, block, Function.identity());
    }

    private static <B extends Block> B registerNoItem(String id, B block) {
        REGISTRY.putIfAbsent(block, id);
        return block;
    }
    private static Boolean never(BlockState state, BlockView world, BlockPos pos, EntityType<?> type) {
        return false;
    }

    private static PillarBlock createLogBlock(MapColor topMapColor, MapColor sideMapColor) {
        return new PillarBlock(AbstractBlock.Settings.of(Material.WOOD, (state) -> {
            return state.get(PillarBlock.AXIS) == Direction.Axis.Y ? topMapColor : sideMapColor;
        }).strength(2.0F).sounds(BlockSoundGroup.WOOD));
    }

    private static AbstractBlock.Settings copyOf(AbstractBlock block) {
        return AbstractBlock.Settings.copy(block);
    }

    public static void init() {
        REGISTRY.forEach((block, id) ->
                Registry.register(Registry.BLOCK, IdBuilder.mod(id), block)
        );
    }

}
