package dev.mayaqq.infix.mixin;

import dev.mayaqq.infix.config.InfixConfig;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.InfinityEnchantment;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(InfinityEnchantment.class)
public class InfinityEnchantmentMixin {
    @Inject(at = @At("HEAD"), method = "canAccept", cancellable = true)
    private void infix$canAccept(Enchantment other, CallbackInfoReturnable<Boolean> cir) {
        if (InfixConfig.CONFIG.mendingWithInfinity) {
            cir.setReturnValue(true);
        }
    }
}
