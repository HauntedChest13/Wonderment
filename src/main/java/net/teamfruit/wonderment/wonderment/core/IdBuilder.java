package net.teamfruit.wonderment.wonderment.core;

import net.teamfruit.wonderment.wonderment.WondermentMod;
import net.minecraft.util.Identifier;

public interface IdBuilder {

    static Identifier mod(String path) {
        return new Identifier(WondermentMod.MOD_ID, path);
    }

    static Identifier mc(String path) {
        return new Identifier(path);
    }

}
