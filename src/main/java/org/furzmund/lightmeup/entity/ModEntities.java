package org.furzmund.lightmeup.entity;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.furzmund.lightmeup.LightMeUp;
import org.furzmund.lightmeup.entity.projectile.TorchArrowEntity;

public class ModEntities {

    public static final EntityType<TorchArrowEntity> TORCH_ARROW = Registry.register(
            Registries.ENTITY_TYPE,
            new Identifier(LightMeUp.MOD_ID, "torch_arrow"),
            FabricEntityTypeBuilder.<TorchArrowEntity>create(SpawnGroup.MISC, TorchArrowEntity::new)
                    .dimensions(EntityDimensions.fixed(0.5f, 0.5f)).build());

    public static void registerModEntities() {
        LightMeUp.LOGGER.info("Registering Entities");
    }
}
