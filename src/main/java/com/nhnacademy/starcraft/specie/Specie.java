package com.nhnacademy.starcraft.specie;

import com.nhnacademy.starcraft.unit.FlyerUnit;
import com.nhnacademy.starcraft.unit.Unit;
import java.util.ArrayList;
import java.util.List;

public abstract class Specie {
    private final String specieName;
    private List<Unit> unitList;

    protected Specie(String specieName) {
        this.specieName = specieName;
        unitList = new ArrayList<>();

        createUnit();
    }

    public String getSpecieName() {
        return specieName;
    }

    public abstract void createUnit();

    public void add(Unit unit) {
        unitList.add(unit);
    }

    public void remove(int unitIndex) {
        unitList.remove(unitIndex);
    }

    public int getSize() {
        return unitList.size();
    }

    public void printUnitList() {
        System.out.println(specieName);

        for (int i = 0; i < unitList.size(); i++) {
            System.out.println(i + ". " + unitList.get(i));
        }
    }

    public Unit get(int i) {
        return unitList.get(i);
    }

    public boolean isUnitCheck() {

        for (Unit unit : unitList) {
            if (unit instanceof FlyerUnit) {
                return false;
            }
        }

        return true;
    }

    public String toString() {
        return this.getSpecieName();
    }
}
