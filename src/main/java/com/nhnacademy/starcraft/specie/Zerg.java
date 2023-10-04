package com.nhnacademy.starcraft.specie;

import com.nhnacademy.starcraft.zerg.Guardian;
import com.nhnacademy.starcraft.zerg.Hydralisk;
import com.nhnacademy.starcraft.zerg.Mutalisk;
import com.nhnacademy.starcraft.zerg.Queen;
import com.nhnacademy.starcraft.zerg.Ultralisk;
import com.nhnacademy.starcraft.zerg.Zergling;
import java.util.Random;

public class Zerg extends Specie {
    public Zerg() {
        super("Zerg");
    }

    @Override
    public void createUnit() {
        Random random = new Random();
        for (int i = 0; i < 8; i++) {
            int createNumber = random.nextInt(5) + 1;

            switch (createNumber) {
                case 1:
                    this.add(new Zergling());
                    break;
                case 2:
                    this.add(new Hydralisk());
                    break;
                case 3:
                    this.add(new Ultralisk());
                    break;
                case 4:
                    this.add(new Mutalisk());
                    break;
                case 5:
                    this.add(new Guardian());
                    break;
                default:
                    this.add(new Queen());
            }
        }
    }

}
