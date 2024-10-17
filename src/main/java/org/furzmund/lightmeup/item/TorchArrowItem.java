package org.furzmund.lightmeup.item;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.entity.projectile.SpectralArrowEntity;
import net.minecraft.item.ArrowItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import org.furzmund.lightmeup.LightMeUp;

public class TorchArrowItem extends ArrowItem {
    public TorchArrowItem(Item.Settings settings) { super(settings); }

    @Override
    public PersistentProjectileEntity createArrow(World world, ItemStack stack, LivingEntity shooter) {
        return new SpectralArrowEntity(world, shooter);
    }
}
