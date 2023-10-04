package com.nhnacademy.starcraft.zerg;

import com.nhnacademy.starcraft.unit.GroundUnit;

public class Hydralisk extends GroundUnit {

    public Hydralisk() {
        super("Hydralisk", 3, 7);
    }

    @Override
    public boolean isFlyAttack() {
        return true;
    }
}
