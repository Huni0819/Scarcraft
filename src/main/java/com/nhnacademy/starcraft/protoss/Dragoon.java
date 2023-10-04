package com.nhnacademy.starcraft.protoss;

import com.nhnacademy.starcraft.unit.GroundUnit;

public class Dragoon extends GroundUnit {

    public Dragoon() {
        super("Dragoon", 3, 15);
    }

    @Override
    public boolean isFlyAttack() {
        return true;
    }
}
