package me.xenon.nojumpdelay;

import me.xenon.nojumpdelay.module.NoJumpDelay;
import net.minecraftforge.fml.common.Mod;

@Mod("example")
public class Main implements Wrapper {

    public Main() {
        EVENT_BUS.register(new NoJumpDelay());
        EVENT_BUS.register(this);
    }
}