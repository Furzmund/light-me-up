package org.furzmund.lightmeup.entity.projectile;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.WallTorchBlock;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.play.EntitySpawnS2CPacket;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import org.furzmund.lightmeup.entity.ModEntities;
import org.furzmund.lightmeup.item.ModItems;

public class TorchArrowEntity extends PersistentProjectileEntity {

    public TorchArrowEntity(EntityType<? extends TorchArrowEntity> entityType, World world) {
        super(entityType, world);
    }

    public TorchArrowEntity(World world, LivingEntity livingEntity) {
        super(ModEntities.TORCH_ARROW, livingEntity, world);
    }

    public TorchArrowEntity(World world, double x, double y, double z) {
        super(ModEntities.TORCH_ARROW, x, y, z, world);
    }

    protected Item getDefaultItem() {
        return ModItems.TORCH_ARROW;
    }

    @Override
    public Packet<ClientPlayPacketListener> createSpawnPacket() {
        return new EntitySpawnS2CPacket(this);
    }

    @Override
    protected ItemStack asItemStack() {
        return new ItemStack(ModItems.TORCH_ARROW);
    }

    @Override
    protected void onBlockHit(BlockHitResult result) {
        if(!this.getWorld().isClient()) {
            BlockPos position = result.getBlockPos();
            Direction direction = result.getSide();
            BlockPos finalPosition = position.offset(direction);
            BlockState state = this.getWorld().getBlockState(finalPosition);

            if((state.isAir() || state.isReplaceable()) && direction != Direction.DOWN) {
                BlockState blockState;
                if(direction == Direction.UP)
                    blockState = Blocks.TORCH.getDefaultState();
                else
                    blockState = Blocks.WALL_TORCH.getDefaultState().with(WallTorchBlock.FACING, direction);

                if(blockState.canPlaceAt(this.getWorld(), finalPosition)) {
                    this.getWorld().sendEntityStatus(this, (byte)3);
                    this.getWorld().setBlockState(
                            finalPosition, blockState, 3
                    );
                    this.discard();
                }
            }
        }

        super.onBlockHit(result);
    }

}
