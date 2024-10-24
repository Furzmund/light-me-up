package org.furzmund.lightmeup;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import org.furzmund.lightmeup.entity.ModEntities;
import org.furzmund.lightmeup.entity.renderer.TorchArrowEntityRenderer;

public class LightMeUpClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.register(ModEntities.TORCH_ARROW, TorchArrowEntityRenderer::new);
    }
}
