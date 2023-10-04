package com.nhnacademy.starcraft.unit;

public abstract class FlyerUnit extends Unit{
    protected FlyerUnit(String unitName, int attackPower, int defensivePower) {
        super(unitName, attackPower, defensivePower);
    }

    @Override
    public void attack(Unit unit) {
        unit.defense(this);
    }
}
