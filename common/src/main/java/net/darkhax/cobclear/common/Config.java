package net.darkhax.cobclear.common;

import net.darkhax.pricklemc.common.api.annotations.RangedFloat;
import net.darkhax.pricklemc.common.api.annotations.Value;

public class Config {

    @Value(comment = "The speed modifier to apply per-level of the effect.")
    @RangedFloat(min = 0f)
    public float speed = 1f;
}