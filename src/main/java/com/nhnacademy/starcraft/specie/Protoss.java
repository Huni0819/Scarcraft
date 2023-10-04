package com.nhnacademy.starcraft.specie;

import com.nhnacademy.starcraft.protoss.Carrier;
import com.nhnacademy.starcraft.protoss.Corsair;
import com.nhnacademy.starcraft.protoss.Dragoon;
import com.nhnacademy.starcraft.protoss.HighTempler;
import com.nhnacademy.starcraft.protoss.Scout;
import com.nhnacademy.starcraft.protoss.Zealot;
import java.util.Random;

public class Protoss extends Specie {
    public Protoss() {
        super("Protoss");
    }

    @Override
    public void createUnit() {
        Random random = new Random();
        for (int i = 0; i < 4; i++) {
            int createNumber = random.nextInt(6) + 1;

            switch (createNumber) {
                case 1:
                    this.add(new Zealot());
                    break;
                case 2:
                    this.add(new Dragoon());
                    break;
                case 3:
                    this.add(new HighTempler());
                    break;
                case 4:
                    this.add(new Scout());
                    break;
                case 5:
                    this.add(new Corsair());
                    break;
                default:
                    this.add(new Carrier());
            }
        }
    }
}
