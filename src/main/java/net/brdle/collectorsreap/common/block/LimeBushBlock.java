package net.brdle.collectorsreap.common.block;

import net.brdle.collectorsreap.common.config.CRConfig;
import net.brdle.collectorsreap.common.item.CRItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.animal.Bee;
import net.minecraft.world.item.Item;
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
import org.jetbrains.annotations.NotNull;

public class LimeBushBlock extends FruitBushBlock {

	public static final VoxelShape SMALL_SHAPE = Block.box(4.0, 0.0, 4.0, 12.0, 11.0, 12.0);
	private static final VoxelShape MEDIUM_SHAPE = Shapes.or(
		Block.box(0.0D, 8.0D, 0.0D, 16.0D, 16.0D, 16.0D),
		Block.box(6.0D, 0.0D, 6.0D, 10.0D, 8.0D, 10.0D)
	);
	private static final VoxelShape SHAPE_LOWER = Shapes.or(
		Block.box(0.0D, 12.0D, 0.0D, 16.0D, 16.0D, 16.0D),
		Block.box(6.0D, 0.0D, 6.0D, 10.0D, 12.0D, 10.0D));
	private static final VoxelShape SHAPE_UPPER = Block.box(0.0D, 0.0D, 0.0D, 16.0D, 8.0D, 16.0D);

	public LimeBushBlock(Properties properties) {
		super(properties);
	}

	@Override
	public @NotNull VoxelShape getShape(@NotNull BlockState state, @NotNull BlockGetter pLevel, @NotNull BlockPos pPos, @NotNull CollisionContext pContext) {
		return switch(state.getValue(AGE)) {
			case 0 -> SMALL_SHAPE;
			case 1 -> MEDIUM_SHAPE;
			default -> state.hasProperty(HALF) && state.getValue(HALF) == DoubleBlockHalf.UPPER ?
				SHAPE_UPPER : SHAPE_LOWER;
		};
	}

	@Override
	public Item getFruit() {
		return CRItems.LIME.get();
	}

	@Override
	public Item getSeeds() {
		return CRItems.LIME_SEEDS.get();
	}

	@Override
	public void randomTick(BlockState state, @NotNull ServerLevel pLevel, @NotNull BlockPos pPos, @NotNull RandomSource pRandom) {
		int age = state.getValue(AGE);
		if (
			!(CRConfig.LIME_POLLINATION.get() && age == MAX_AGE - 1) && // Making sure we aren't a flowering state bush that needs pollination
			age < MAX_AGE &&
			state.getValue(HALF) == DoubleBlockHalf.LOWER && !state.getValue(STUNTED) &&
			ForgeHooks.onCropsGrowPre(pLevel, pPos, state, pRandom.nextInt(12) == 0)
		) {
			this.performBonemeal(pLevel, pRandom, pPos, state);
			ForgeHooks.onCropsGrowPost(pLevel, pPos, state);
		}
	}

	// Can use Bone Meal up until reaching final stage
	@Override
	public boolean isValidBonemealTarget(@NotNull LevelReader pLevel, @NotNull BlockPos pPos, BlockState pState, boolean pIsClient) {
		return pState.getValue(AGE) < (MAX_AGE - 1);
	}

	@Override
	public boolean isBonemealSuccess(@NotNull Level pLevel, @NotNull RandomSource pRandom, @NotNull BlockPos pPos, @NotNull BlockState pState) {
		return true;
	}

	@Override
	public void entityInside(@NotNull BlockState pState, @NotNull Level pLevel, @NotNull BlockPos pPos, @NotNull Entity e) {
		if (!pLevel.isClientSide() &&
			CRConfig.LIME_POLLINATION.get() &&
			CRConfig.FAST_POLLINATE.get() &&
			e instanceof Bee &&
			pState.getValue(AGE) == MAX_AGE - 1 &&
			pLevel.getRandom().nextInt(150) == 0) {
			this.performBonemeal((ServerLevel) pLevel, pLevel.getRandom(), pPos, pState);
		}
	}

	@SuppressWarnings("deprecation")
	@Override
	public @NotNull VoxelShape getCollisionShape(@NotNull BlockState pState, @NotNull BlockGetter pLevel, @NotNull BlockPos pPos, @NotNull CollisionContext pContext) {
		if (pContext instanceof EntityCollisionContext ent && ent.getEntity() instanceof Bee && CRConfig.LIME_POLLINATION.get()) {
			return (
				pState.getValue(HALF) == DoubleBlockHalf.LOWER ?
					Block.box(0.0D, 0.0D, 0.0D, 16.0D, 8.0D, 16.0D) : Shapes.empty()
			);
		}
		return getShape(pState, pLevel, pPos, pContext);
	}

	@Override
	public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
		return 60;
	}

	@Override
	public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
		return 30;
	}
}
