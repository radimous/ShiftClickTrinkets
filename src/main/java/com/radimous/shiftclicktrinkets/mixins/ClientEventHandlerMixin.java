package com.radimous.shiftclicktrinkets.mixins;

import iskallia.vault.item.gear.TrinketItem;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import top.theillusivec4.curios.client.ClientEventHandler;
@Mixin(value = ClientEventHandler.class, remap = false)
public class ClientEventHandlerMixin {
    /**
     * remove tooltip automatically added by curios, vault mod adds its own
     */
    @Inject(method = "onTooltip", at = @At("HEAD"), cancellable = true)
    private void removeAutoTooltip(ItemTooltipEvent evt, CallbackInfo ci){
        if (evt.getItemStack().getItem() instanceof TrinketItem){
            ci.cancel();
        }

    }
}
