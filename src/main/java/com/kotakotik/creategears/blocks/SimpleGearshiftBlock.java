package com.kotakotik.creategears.blocks;

import com.kotakotik.creategears.regitration.GearsTiles;
import com.kotakotik.creategears.util.GenericUtils;
import com.simibubi.create.AllBlocks;
import com.simibubi.create.content.contraptions.relays.encased.GearshiftBlock;
import com.tterrag.registrate.providers.RegistrateRecipeProvider;
import net.minecraft.core.BlockPos;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class SimpleGearshiftBlock extends GearshiftBlock implements GenericUtils {
    public SimpleGearshiftBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.defaultBlockState().setValue(POWERED, true));
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return super.getStateForPlacement(context).setValue(POWERED, true);
    }

    @Override
    public void neighborChanged(BlockState state, Level worldIn, BlockPos pos, Block blockIn, BlockPos fromPos, boolean isMoving) {
        // ignore redstone stuff
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return GearsTiles.SIMPLE_GEARSHIFT.create(pos, state);
    }

    public ShapedRecipeBuilder recipe(RegistrateRecipeProvider prov) {
        return ShapedRecipeBuilder.shaped(this)
                .define('c', AllBlocks.ANDESITE_CASING.get())
                .define('w', AllBlocks.COGWHEEL.get())
                .unlockedBy("has_cogwheel", RegistrateRecipeProvider.has(AllBlocks.COGWHEEL.get()));
    }

    public void recipe(ShapedRecipeBuilder builder, RegistrateRecipeProvider prov, String type) {
        builder.save(prov, modLoc(getRegistryName().getPath() + "_" + type));
    }
}
