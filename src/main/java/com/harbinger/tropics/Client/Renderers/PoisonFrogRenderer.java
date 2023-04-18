package com.harbinger.tropics.Client.Renderers;

import com.harbinger.tropics.Client.Models.PoisonFrogModel;
import com.harbinger.tropics.Tentities.PoisonousFrogs;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class PoisonFrogRenderer extends GeoEntityRenderer<PoisonousFrogs> {
    public PoisonFrogRenderer(EntityRendererProvider.Context context) {
        super(context, new PoisonFrogModel());
    }


}