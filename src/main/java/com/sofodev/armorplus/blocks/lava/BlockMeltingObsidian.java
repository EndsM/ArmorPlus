/*
 * Copyright (c) Sokratis Fotkatzikis (sokratis12GR) 2015-2019.
 */

package com.sofodev.armorplus.blocks.lava;

import net.minecraft.block.BlockBreakable;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

import static com.sofodev.armorplus.util.Utils.setRL;

public class BlockMeltingObsidian extends BlockBreakable {

    public BlockMeltingObsidian() {
        super(Properties.create(Material.ROCK).hardnessAndResistance(0.5f).lightValue(3).tickRandomly().sound(SoundType.STONE));
    }

    // /**
    //  * Convert the BlockState into the correct metadata value
    //  */
    // public int getMetaFromState(IBlockState state) {
    //     return state.getValue(AGE);
    // }

    // /**
    //  * Convert the given metadata into a BlockState for this Block
    //  */
    // public IBlockState getStateFromMeta(int meta) {
    //     return this.getDefaultState().withProperty(AGE, MathHelper.clamp(meta, 0, 3));
    // }

    // /**
    //  * Returns the quantity of items to drop on block destruction.
    //  */
    // @Override
    // public int quantityDropped(Random random) {
    //     return 0;
    // }

    // @Override
    // public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {
    //     if ((rand.nextInt(3) == 0 || this.countNeighbors(worldIn, pos) < 4) && worldIn.getLightFromNeighbors(pos) > 11 - state.getValue(AGE) - state.getLightOpacity(worldIn, pos)) {
    //         this.slightlyMelt(worldIn, pos, state, rand, true);
    //     } else {
    //         worldIn.scheduleUpdate(pos, this, MathHelper.getInt(rand, 20, 40));
    //     }
    // }

    // protected void turnIntoLava(World worldIn, BlockPos pos) {
    //     if (worldIn.provider.isNether()) {
    //         worldIn.setBlockState(pos, Blocks.LAVA.getDefaultState());
    //         worldIn.neighborChanged(pos, Blocks.LAVA, pos);
    //     } else {
    //         this.dropBlockAsItem(worldIn, pos, worldIn.getBlockState(pos), 0);
    //         worldIn.setBlockState(pos, Blocks.LAVA.getDefaultState());
    //         worldIn.neighborChanged(pos, Blocks.LAVA, pos);
    //     }
    // }

    // /**
    //  * Spawns the block's drops in the world. By the time this is called the Block has possibly been set to air via
    //  * Block.removedByPlayer
    //  */
    // @Override
    // public void harvestBlock(World worldIn, EntityPlayer player, BlockPos pos, IBlockState state, @Nullable TileEntity te, ItemStack stack) {
    //     player.addStat(StatList.getBlockStats(this));
    //     player.addExhaustion(0.005F);

    //     if (this.canSilkHarvest(worldIn, pos, state, player) && EnchantmentHelper.getEnchantmentLevel(Enchantments.SILK_TOUCH, stack) > 0) {
    //         List<ItemStack> items = new ArrayList<>();
    //         items.add(this.getSilkTouchDrop(state));

    //         ForgeEventFactory.fireBlockHarvesting(items, worldIn, pos, state, 0, 1.0f, true, player);
    //         for (ItemStack is : items)
    //             spawnAsEntity(worldIn, pos, is);
    //     } else {
    //         if (worldIn.provider.isNether()) {
    //             worldIn.setBlockState(pos, Blocks.LAVA.getDefaultState());
    //             return;
    //         }

    //         int i = EnchantmentHelper.getEnchantmentLevel(Enchantments.FORTUNE, stack);
    //         harvesters.set(player);
    //         this.dropBlockAsItem(worldIn, pos, state, i);
    //         harvesters.set(null);
    //         Material material = worldIn.getBlockState(pos.down()).getMaterial();

    //         if (material.blocksMovement() || material.isLiquid()) {
    //             worldIn.setBlockState(pos, Blocks.LAVA.getDefaultState());
    //         }
    //     }
    // }

    // /**
    //  * Called when a neighboring block was changed and marks that this state should perform any checks during a neighbor
    //  * change. Cases may include when redstone power is updated, cactus blocks popping off due to a neighboring solid
    //  * block, etc.
    //  */
    // @SuppressWarnings("deprecation")
    // @Override
    // public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos) {
    //     if (worldIn.getBlockState(pos).getBlock() == this) {
    //         int count = this.countNeighbors(worldIn, pos);

    //         if (count < 2) {
    //             this.turnIntoLava(worldIn, pos);
    //         }
    //     }
    // }

    // private int countNeighbors(World access, BlockPos pos) {
    //     return (int) Arrays.stream(EnumFacing.values()).filter(enumfacing -> access.getBlockState(pos.offset(enumfacing)).getBlock() == this).limit(4).count();
    // }

    // protected void slightlyMelt(World worldIn, BlockPos pos, IBlockState state, Random rand, boolean meltNeighbors) {
    //     int age = state.getValue(AGE);

    //     if (age < 3) {
    //         worldIn.setBlockState(pos, state.withProperty(AGE, age + 1), 2);
    //         worldIn.scheduleUpdate(pos, this, MathHelper.getInt(rand, 20, 40));
    //     } else {
    //         this.turnIntoLava(worldIn, pos);

    //         if (meltNeighbors) {
    //             for (EnumFacing enumfacing : EnumFacing.values()) {
    //                 BlockPos blockpos = pos.offset(enumfacing);
    //                 IBlockState iblockstate = worldIn.getBlockState(blockpos);

    //                 if (iblockstate.getBlock() == this) {
    //                     this.slightlyMelt(worldIn, blockpos, iblockstate, rand, false);
    //                 }
    //             }
    //         }
    //     }

    // }

    // @Override
    // public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World world, BlockPos pos, EntityPlayer player) {
    //     return ItemStack.EMPTY;
    // }

    // protected BlockStateContainer createBlockState() {
    //     return new BlockStateContainer(this, AGE);
    // }


    // @Override
    // public Item getItemDropped(IBlockState state, Random rand, int fortune) {
    //     return Items.AIR;
    // }

    // @Override
    // public BlockRenderLayer getRenderLayer() {
    //     return BlockRenderLayer.SOLID;
    // }

    // @SuppressWarnings("deprecation")
    // @Override
    // public boolean isFullCube(IBlockState state) {
    //     return true;
    // }
}