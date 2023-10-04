package com.nhnacademy.starcraft.unit;

public abstract class Unit {
    private final String unitName;
    private final int attackPower;
    private int defensivePower;

    protected Unit(String unitName, int attackPower, int defensivePower) {
        this.unitName = unitName;
        this.attackPower = attackPower;
        this.defensivePower = defensivePower;
    }

    public String getUnitName() {
        return unitName;
    }

    public int getAttackPower() {
        return attackPower;
    }

    public int getDefensivePower() {
        return defensivePower;
    }

    public void setDefensivePower(int defensivePower) {
        this.defensivePower = defensivePower;
    }


    public abstract void attack(Unit unit);

    public void defense(Unit unit) {
        this.setDefensivePower(this.getDefensivePower() - unit.getAttackPower());
    }


    public String toString() {
        return this.getUnitName() + " 공격력 : " + this.getAttackPower() + " (현재 방어력 : " + this.getDefensivePower() + ")";
    }
}
