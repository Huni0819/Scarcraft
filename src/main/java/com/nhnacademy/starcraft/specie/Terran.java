package com.nhnacademy.starcraft.specie;

import com.nhnacademy.starcraft.terran.BattleCruzer;
import com.nhnacademy.starcraft.terran.Goliath;
import com.nhnacademy.starcraft.terran.Marine;
import com.nhnacademy.starcraft.terran.Tank;
import com.nhnacademy.starcraft.terran.Valkyrie;
import com.nhnacademy.starcraft.terran.Wraith;
import java.util.Random;

public class Terran extends Specie {

    public Terran() {
        super("Terran");
    }


    @Override
    public void createUnit() {
        Random random = new Random();
        for (int i = 0; i < 5; i++) {
            int createNumber = random.nextInt(6) + 1;

            switch (createNumber) {
                case 1:
                    this.add(new Marine());
                    break;
                case 2:
                    this.add(new Tank());
                    break;
                case 3:
                    this.add(new Goliath());
                    break;
                case 4:
                    this.add(new Wraith());
                    break;
                case 5:
                    this.add(new Valkyrie());
                    break;
                default:
                    this.add(new BattleCruzer());
            }
        }
    }
}