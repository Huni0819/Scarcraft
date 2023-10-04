package com.nhnacademy.starcraft.terran;

import com.nhnacademy.starcraft.unit.GroundUnit;

public class Goliath extends GroundUnit {

    public Goliath() {
        super("Goliath", 5, 15);
    }

    @Override
    public boolean isFlyAttack() {
        return true;
    }
}
