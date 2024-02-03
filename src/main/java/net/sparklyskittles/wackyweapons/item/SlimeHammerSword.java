package net.sparklyskittles.wackyweapons.item;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.enchantment.KnockbackEnchantment;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.Vec3d;
import org.apache.commons.lang3.ObjectUtils;

import java.util.Objects;

public class SlimeHammerSword extends SwordItem {
    public SlimeHammerSword(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
        super(toolMaterial, attackDamage, attackSpeed, settings);
    }
    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        if (Objects.requireNonNull(context.getPlayer()).getItemCooldownManager().getCooldownProgress(context.getStack().getItem(), 1) == 0) {
            Vec3d direction = new Vec3d(((context.getPlayer().getEyePos().getX() - context.getHitPos().getX())),
                    ((context.getPlayer().getEyePos().getY() - context.getHitPos().getY())),
                    ((context.getPlayer().getEyePos().getZ() - context.getHitPos().getZ())));
            Objects.requireNonNull(context.getPlayer()).addVelocity(direction.normalize().multiply(2.0));
            context.getPlayer().getItemCooldownManager().set(context.getStack().getItem(), 20);
            context.getPlayer().swingHand(context.getHand());
        }
        return super.useOnBlock(context);
    }
    @Override
    public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        target.takeKnockback(4, attacker.getX() - target.getX(), attacker.getZ() - target.getZ());
        return super.postHit(stack, target, attacker);
    }
}
