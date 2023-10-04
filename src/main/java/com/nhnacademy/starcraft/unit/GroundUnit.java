package com.nhnacademy.starcraft.unit;

public abstract class GroundUnit extends Unit {
    protected GroundUnit(String unitName, int attackPower, int defensivePower) {
        super(unitName, attackPower, defensivePower);
    }

    public boolean isFlyAttack() {
        return false;
    }

    @Override
    public void attack(Unit unit) {
        if(isFlyAttack()) {
            unit.defense(this);
        } else {
            if(unit instanceof FlyerUnit) {
                throw new IllegalArgumentException("해당 유닛은 공중 유닛을 공격 할 수 없습니다.");
            }

            unit.defense(this);
        }
    }
}
