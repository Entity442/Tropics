package com.harbinger.tropics.Client.Models;

import com.harbinger.tropics.Tentities.PoisonousFrogs;
import com.harbinger.tropics.Tropics;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;

public class PoisonFrogModel extends DefaultedEntityGeoModel<PoisonousFrogs> {
    public PoisonFrogModel() {
        super(new ResourceLocation(Tropics.MODID, "trialfrog"));
    }




    @Override
    public ResourceLocation getTextureResource(PoisonousFrogs animatable) {
        ResourceLocation TEXTURE;
        if (animatable.getVariant() == 1){
            TEXTURE = new ResourceLocation(Tropics.MODID,"textures/entity/dark.png");
        }else if (animatable.getVariant() == 2){
            TEXTURE = new ResourceLocation(Tropics.MODID,"textures/entity/red.png");
        }else {
            TEXTURE = new ResourceLocation(Tropics.MODID,"textures/entity/green.png");
        }
        return TEXTURE;
    }
}
