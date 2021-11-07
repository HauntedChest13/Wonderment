package net.teamfruit.wonderment.wonderment.core;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.registry.Registry;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Supplier;


@SuppressWarnings("unused")
public class ItemInit {

    public static final Supplier<Item.Settings> DEFAULT =
            FabricItemSettings::new;
    public static final Supplier<Item.Settings> MISC =
            () -> DEFAULT.get().group(ItemGroup.MISC);
    public static final Supplier<Item.Settings> FOODS =
            () -> DEFAULT.get().group(ItemGroup.FOOD);
    public static final Function<FoodComponent, Item.Settings> FOOD =
            FOODS.get()::food;
    private static final Map<Item, String> REGISTRY = new HashMap<>();

    //Items Go Here

    static <I extends Item> I register(String id, I item) {
        REGISTRY.putIfAbsent(item, id);
        return item;
    }

    public static void init() {
        REGISTRY.forEach((item, id) ->
                Registry.register(Registry.ITEM, IdBuilder.mod(id), item)
        );
    }

}
