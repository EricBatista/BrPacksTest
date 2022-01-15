package br.erbatista.brpackstest.entity.custom;

import net.minecraft.block.BlockState;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.inventory.container.ChestContainer;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.item.ItemStack;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.vector.*;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

import javax.annotation.Nullable;

public class ColheitadeiraEntity extends AnimalEntity implements IAnimatable, IInventory, INamedContainerProvider
{
    private NonNullList<ItemStack> itemStacks = NonNullList.withSize(36, ItemStack.EMPTY);
    private AnimationFactory factory = new AnimationFactory(this);

    public ColheitadeiraEntity(EntityType<? extends AnimalEntity> type, World worldIn) {
        super(type, worldIn);
        this.noCulling = true;
    }

    @Override
    public ActionResultType mobInteract(PlayerEntity player, Hand hand) {
        if (!this.isVehicle()) {
            player.startRiding(this);
            return super.mobInteract(player, hand);
        }
        return super.mobInteract(player, hand);
    }

    @Override
    protected void playStepSound(BlockPos pos, BlockState blockIn) {
        this.playSound(SoundEvents.HOGLIN_STEP, 0.20F, 0.5F);
    }

    @Override
    public void travel(Vector3d pos) {
        if (this.isAlive()) {
            if (this.isVehicle()) {
                LivingEntity livingentity = (LivingEntity) this.getControllingPassenger();
                this.yRot = livingentity.yRot;
                this.yRotO = this.yRot;
                this.xRot = livingentity.xRot * 0.5F;
                this.setRot(this.yRot, this.xRot);
                this.yBodyRot = this.yRot;
                this.yHeadRot = this.yBodyRot;
                float f = livingentity.xxa * 0.5F;
                float f1 = livingentity.zza;
                if (f1 <= 0.0F) {
                    f1 *= 0.25F;
                }

                this.setSpeed(0.3F);
                super.travel(new Vector3d((double) f, pos.y, (double) f1));
            }
        }
    }

    @Nullable
    public Entity getControllingPassenger() {
        return this.getPassengers().isEmpty() ? null : this.getPassengers().get(0);
    }

    @Override
    public boolean canBeControlledByRider() {
        return true;
    }


    @Override
    public void registerControllers(AnimationData data) {

    }

    @Override
    public AnimationFactory getFactory() {
        return this.factory;
    }

    @Override
    public AgeableEntity getBreedOffspring(ServerWorld p_241840_1_, AgeableEntity p_241840_2_) {
        return null;
    }

    public static AttributeModifierMap.MutableAttribute setCustomAttributes(){
        return MobEntity.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 20.0D)
                .add(Attributes.MOVEMENT_SPEED, 2.0D)
                .add(Attributes.ATTACK_DAMAGE, 1.0D);
    }

    @Override
    public int getContainerSize() {
        return 27;
    }

    @Override
    public boolean isEmpty() {
        for(ItemStack itemstack : this.itemStacks) {
            if (!itemstack.isEmpty()) {
                return false;
            }
        }

        return true;
    }

    @Override
    public ItemStack getItem(int pIndex) {
        return this.itemStacks.get(pIndex);
    }

    @Override
    public ItemStack removeItem(int pIndex, int pCount) {
        return ItemStackHelper.removeItem(this.itemStacks, pIndex, pCount);
    }

    @Override
    public ItemStack removeItemNoUpdate(int pIndex) {
        ItemStack itemstack = this.itemStacks.get(pIndex);
        if (itemstack.isEmpty()) {
            return ItemStack.EMPTY;
        } else {
            this.itemStacks.set(pIndex, ItemStack.EMPTY);
            return itemstack;
        }
    }

    @Override
    public void setItem(int pIndex, ItemStack pStack) {
        this.itemStacks.set(pIndex, pStack);
        if (!pStack.isEmpty() && pStack.getCount() > this.getMaxStackSize()) {
            pStack.setCount(this.getMaxStackSize());
        }
    }

    @Override
    public void setChanged() {

    }

    @Override
    public boolean stillValid(PlayerEntity pPlayer) {
        if (this.removed) {
            return false;
        } else {
            return !(pPlayer.distanceToSqr(this) > 64.0D);
        }
    }

    @Override
    public void clearContent() {
        this.itemStacks.clear();
    }

    @Nullable
    @Override
    public Container createMenu(int p_createMenu_1_, PlayerInventory p_createMenu_2_, PlayerEntity p_createMenu_3_) {

        return this.createMenu(p_createMenu_1_, p_createMenu_2_);

    }

    public Container createMenu(int pId, PlayerInventory pPlayerInventory) {
        return ChestContainer.threeRows(pId, pPlayerInventory, this);
    }

    @Override
    public ActionResultType interactAt(PlayerEntity pPlayer, Vector3d pVec, Hand pHand) {
        ActionResultType ret = super.interact(pPlayer, pHand);
        if (ret.consumesAction()) return ret;
        pPlayer.openMenu(this);
        if (!pPlayer.level.isClientSide) {
            return ActionResultType.CONSUME;
        } else {
            return ActionResultType.SUCCESS;
        }
    }


    @Override
    public void tick() {
        super.tick();
        if(this.level.isClientSide()){
            if(getControllingPassenger() == null) return;

            Vector3f smokePos = new Vector3f(-5f,4.5f,-1f);
            double ang = ((this.getControllingPassenger().getYHeadRot()+90)*Math.PI)/180*(-1);

            double xResult = smokePos.x()*Math.cos(ang)+smokePos.z()*Math.sin(ang);
            double yResult = smokePos.y();
            double zResult = smokePos.z()*Math.cos(ang)-smokePos.x()*Math.sin(ang);

            this.level.addParticle(
                    ParticleTypes.SMOKE,getX() + xResult,getY() + yResult,getZ() + zResult,
                    0 ,0,0);


        }
    }


}
