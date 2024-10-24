package org.furzmund.lightmeup.entity.renderer;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.ProjectileEntityRenderer;
import net.minecraft.util.Identifier;
import org.furzmund.lightmeup.LightMeUp;
import org.furzmund.lightmeup.entity.projectile.TorchArrowEntity;

@Environment(EnvType.CLIENT)
public class TorchArrowEntityRenderer extends ProjectileEntityRenderer<TorchArrowEntity> {
    public static final Identifier TEXTURE = new Identifier(
            LightMeUp.MOD_ID,
           "textures/entity/projectiles/torch_arrow.png"
    );

    public TorchArrowEntityRenderer(EntityRendererFactory.Context context) {
        super(context);
    }

    public Identifier getTexture(TorchArrowEntity torchArrowEntity) {
        return TEXTURE;
    }
}
