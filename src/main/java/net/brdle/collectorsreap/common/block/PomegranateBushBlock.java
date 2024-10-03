package net.brdle.collectorsreap.common.block;

import net.brdle.collectorsreap.common.config.CRConfig;
import net.brdle.collectorsreap.common.item.CRItems;
import net.brdle.collectorsreap.data.CRBlockTags;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.animal.Bee;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.EntityCollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.common.PlantType;
import org.jetbrains.annotations.NotNull;

public class PomegranateBushBlock extends FruitBushBlock {

	private static final VoxelShape SAPLING_SHAPE = Block.box(3.0D, 0.0D, 3.0D, 13.0D, 5.0D, 13.0D);
	private static final VoxelShape MID_GROWTH_SHAPE = Block.box(2.0D, 0.0D, 2.0D, 14.0D, 15.0D, 14.0D);
	private static final VoxelShape SHAPE_LOWER = Block.box(5.0D, 0.0D, 5.0D, 11.0D, 16.0D, 11.0D);
	private static final VoxelShape SHAPE_UPPER = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D);

	public PomegranateBushBlock(Properties properties) {
		super(properties);
	}

	@Override
	protected boolean mayPlaceOn(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos) {
		return state.is(CRBlockTags.POMEGRANATE_FAST_ON) || super.mayPlaceOn(state, level, pos);
	}

	@Override
	public PlantType getPlantType(BlockGetter level, BlockPos pos) {
		return PlantType.NETHER;
	}

	@SuppressWarnings("deprecation")
	@Override
	public @NotNull VoxelShape getShape(@NotNull BlockState state, @NotNull BlockGetter pLevel, @NotNull BlockPos pPos, @NotNull CollisionContext pContext) {
		return switch (state.getValue(AGE)) {
			case 0 -> SAPLING_SHAPE;
			case 1 -> MID_GROWTH_SHAPE;
			default -> state.hasProperty(HALF) && state.getValue(HALF) == DoubleBlockHalf.UPPER ?
				SHAPE_UPPER : SHAPE_LOWER;
		};
	}

	@Override
	public Item getSeeds() {
		return CRItems.POMEGRANATE_SEEDS.get();
	}

	@Override
	public Item getFruit() {
		return CRItems.POMEGRANATE.get();
	}

	public ItemStack getSpecialFruit() {
		return new ItemStack(CRItems.STYGIAN_POMEGRANATE.get(), 1);
	}

	@Override
	public int getSpecialChance() {
		return 10;
	}

	// Can receive boost from Nether or block below.
	@SuppressWarnings("deprecation")
	@Override
	public void randomTick(@NotNull BlockState state, @NotNull ServerLevel level, @NotNull BlockPos pos, @NotNull RandomSource random) {
		if (state.getValue(AGE) < MAX_AGE && state.getValue(HALF) == DoubleBlockHalf.LOWER) {
			int growthRate = (level.getBlockState(pos.below()).is(CRBlockTags.POMEGRANATE_FAST_ON)) ? 8 : 12;
			if (level.dimension() == Level.NETHER) {
				growthRate -= 4;
			} else if (state.getValue(AGE) == MAX_AGE - 1 && CRConfig.POMEGRANATE_POLLINATION.get()) {
				return;
			}
			if (ForgeHooks.onCropsGrowPre(level, pos, state, random.nextInt(growthRate) == 0)) {
				this.performBonemeal(level, random, pos, state);
				ForgeHooks.onCropsGrowPost(level, pos, state);
			}
		}
	}

	@Override
	public boolean isValidBonemealTarget(@NotNull LevelReader pLevel, @NotNull BlockPos pPos, @NotNull BlockState pState, boolean pIsClient) {
		return false;
	}

	@Override
	public boolean isBonemealSuccess(@NotNull Level pLevel, @NotNull RandomSource pRandom, @NotNull BlockPos pPos, @NotNull BlockState pState) {
		return false;
	}

	@SuppressWarnings("deprecation")
	@Override
	public void entityInside(@NotNull BlockState pState, @NotNull Level pLevel, @NotNull BlockPos pPos, @NotNull Entity e) {
		if (
			!pLevel.isClientSide() &&
				CRConfig.POMEGRANATE_POLLINATION.get() &&
				CRConfig.FAST_POLLINATE.get() &&
				e instanceof Bee &&
				pState.getValue(AGE) == MAX_AGE - 1 &&
				pLevel.getRandom().nextInt(150) == 0
		) {
			this.performBonemeal((ServerLevel) pLevel, pLevel.getRandom(), pPos, pState);
		}
	}

	@SuppressWarnings("deprecation")
	@Override
	public @NotNull VoxelShape getCollisionShape(@NotNull BlockState pState, @NotNull BlockGetter pLevel, @NotNull BlockPos pPos, @NotNull CollisionContext pContext) {
		if (pContext instanceof EntityCollisionContext ent && ent.getEntity() instanceof Bee && CRConfig.POMEGRANATE_POLLINATION.get()) {
			return pState.getValue(HALF) == DoubleBlockHalf.LOWER ?
				Block.box(0.0D, 0.0D, 0.0D, 16.0D, 8.0D, 16.0D) : Shapes.empty();
		}
		return getShape(pState, pLevel, pPos, pContext);
	}

	@Override
	public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
		return 0;
	}

	@Override
	public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
		return 0;
	}
}