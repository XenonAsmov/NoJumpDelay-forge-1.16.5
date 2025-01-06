package me.xenon.nojumpdelay.module;

import me.xenon.nojumpdelay.Wrapper;
import net.minecraft.entity.LivingEntity;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
public class NoJumpDelay implements Wrapper {

    @SubscribeEvent
    public void onUpdate(TickEvent updateEvent) {
        assert mc.player != null;

        try {
            Reflection.getField(LivingEntity.class, "jumpTicks", "field_70773_bE").setInt(mc.player, 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


