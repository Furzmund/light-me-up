package org.furzmund.lightmeup.entity.projectile;

import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.play.EntitySpawnS2CPacket;
import net.minecraft.util.hit.BlockHitResult;
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

    //@Override
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
    protected void onBlockHit(BlockHitResult blockHitResult) {
        if (!this.getWorld().isClient()) {
            this.getWorld().sendEntityStatus(this, (byte)3);
            this.getWorld().setBlockState(
                    getBlockPos(), Blocks.TORCH.getDefaultState(),3);
        }
        this.discard();
        super.onBlockHit(blockHitResult);
    }
}
