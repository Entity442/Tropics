package com.harbinger.tropics.Tentities;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.navigation.GroundPathNavigation;
import net.minecraft.world.entity.ai.navigation.WaterBoundPathNavigation;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.Bucketable;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.AABB;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.constant.DefaultAnimations;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.util.GeckoLibUtil;

import java.util.List;

public class PoisonousFrogs extends Animal implements Bucketable , GeoEntity {
    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);
    private static final EntityDataAccessor<Integer> DATA_ID_TYPE_VARIANT = SynchedEntityData.defineId(PoisonousFrogs.class, EntityDataSerializers.INT);
    protected final WaterBoundPathNavigation waterNavigation;
    protected final GroundPathNavigation groundNavigation;
    public PoisonousFrogs(EntityType<? extends Animal> animal, Level level) {
        super(animal, level);
        this.waterNavigation = new WaterBoundPathNavigation(this, level);
        this.groundNavigation = new GroundPathNavigation(this, level);
    }

    @Nullable
    @Override
    public AgeableMob getBreedOffspring(ServerLevel p_146743_, AgeableMob p_146744_) {
        return null;
    }

    @Override
    public boolean fromBucket() {
        return false;
    }

    @Override
    public void setFromBucket(boolean p_148834_) {

    }

    @Override
    public void saveToBucketTag(ItemStack p_148833_) {

    }

    @Override
    public void loadFromBucketTag(CompoundTag p_148832_) {

    }

    @Override
    public ItemStack getBucketItemStack() {
        return null;
    }

    @Override
    public SoundEvent getPickupSound() {
        return null;
    }



    @Override
    public boolean canBreatheUnderwater() {
        return true;
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 8)
                .add(Attributes.MOVEMENT_SPEED, 0.2)
                .add(Attributes.FOLLOW_RANGE, 28)
                .add(Attributes.ATTACK_DAMAGE, 1);
    }

    protected void defineSynchedData() {
        super.defineSynchedData();
        RandomSource randomSource = RandomSource.create();
        int variant = randomSource.nextInt(0,3);
        this.entityData.define(DATA_ID_TYPE_VARIANT, variant);
    }

    public void addAdditionalSaveData(CompoundTag p_30716_) {
        super.addAdditionalSaveData(p_30716_);
        p_30716_.putInt("Variant", this.getVariant());
    }

    public void readAdditionalSaveData(CompoundTag p_30711_) {
        super.readAdditionalSaveData(p_30711_);
        this.setVariant(p_30711_.getInt("Variant"));
    }

    private void setVariant(int p_30737_) {
        this.entityData.set(DATA_ID_TYPE_VARIANT, p_30737_);
    }

    public int getVariant() {
        return this.entityData.get(DATA_ID_TYPE_VARIANT);
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {
        controllerRegistrar.add(DefaultAnimations.genericWalkIdleController(this));
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }


    protected void registerGoals() {
        this.goalSelector.addGoal(1, new PanicGoal(this, 1.25D));
        this.goalSelector.addGoal(2, new RandomStrollGoal(this, 1.0D));
        this.goalSelector.addGoal(3, new LookAtPlayerGoal(this, Player.class, 6.0F));
        this.goalSelector.addGoal(4, new RandomLookAroundGoal(this));
        this.goalSelector.addGoal(5,new PoisonAttackers(this));
    }


    public void updateSwimming() {
        if (!this.level.isClientSide) {
            if (this.isEffectiveAi() && this.isInWater()) {
                this.navigation = this.waterNavigation;
                this.setSwimming(true);
            } else {
                this.navigation = this.groundNavigation;
                this.setSwimming(false);
            }
        }
    }

    static class PoisonAttackers extends Goal{
        private final PoisonousFrogs frog;
        public PoisonAttackers(PoisonousFrogs frog){
            this.frog = frog;
        }

        @Override
        public boolean canUse() {

            return check();
        }

        boolean check(){
            AABB hitbox = this.frog.getBoundingBox();
            List<Entity> entities = this.frog.level.getEntities(this.frog, hitbox);
            for (Entity entity : entities) {
                if(entity instanceof LivingEntity livingEntity && !(livingEntity instanceof PoisonousFrogs)) {
                  return true;
                }
            }
            return false;
        }

        @Override
        public void tick() {
            super.tick();
            AABB hitbox = this.frog.getBoundingBox();
            List<Entity> entities = this.frog.level.getEntities(this.frog, hitbox);
            for (Entity entity : entities) {
                if(entity instanceof LivingEntity livingEntity && !(livingEntity instanceof PoisonousFrogs)) {
                    if (this.frog.getVariant() == 0) {
                        livingEntity.addEffect(new MobEffectInstance(MobEffects.WEAKNESS, 200, 1));
                    } else if (this.frog.getVariant() == 1) {
                        livingEntity.addEffect(new MobEffectInstance(MobEffects.POISON, 200, 0));
                    } else if (this.frog.getVariant() == 2) {
                        livingEntity.addEffect(new MobEffectInstance(MobEffects.WITHER, 200, 0));
                    }
                }
            }
        }
    }
}
