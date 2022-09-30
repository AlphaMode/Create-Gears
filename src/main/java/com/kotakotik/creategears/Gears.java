package com.kotakotik.creategears;

import com.kotakotik.creategears.regitration.GearsBlocks;
import com.kotakotik.creategears.regitration.GearsStressProvider;
import com.kotakotik.creategears.regitration.GearsTiles;
import com.simibubi.create.foundation.block.BlockStressValues;
import com.simibubi.create.foundation.data.CreateRegistrate;
import io.github.fabricators_of_create.porting_lib.util.LazyItemGroup;
import net.fabricmc.api.ModInitializer;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
public class Gears implements ModInitializer {

    // Directly reference a log4j logger.
    public static final Logger LOGGER = LogManager.getLogger();

    public static final String modid = "creategears";

    public final CreateRegistrate REGISTRATE = CreateRegistrate.lazy(modid).get();

    public static CreativeModeTab itemGroup = new LazyItemGroup(modid) {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(GearsBlocks.GEAR.get());
        }
    };

    public void onInitialize() {
        BlockStressValues.registerProvider(modid, new GearsStressProvider());

        // registration

        REGISTRATE.creativeModeTab(() -> itemGroup, "Create Gears");
        new GearsBlocks(REGISTRATE).register();
        new GearsTiles(REGISTRATE).register();

        REGISTRATE.register();
    }
}

