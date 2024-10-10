package com.droids;

import java.util.Random;

public class Battle {
    public static void oneOnOne(Droid droid1, Droid droid2) {
        Random random = new Random();
        while (droid1.isAlive() && droid2.isAlive()) {
            if (random.nextBoolean()) {
                droid1.attack(droid2);
            } else {
                droid2.attack(droid1);
            }
            System.out.println(droid1.getName() + ": " + droid1.getHealth() + " HP");
            System.out.println(droid2.getName() + ": " + droid2.getHealth() + " HP");
        }

        if (droid1.isAlive()) {
            System.out.println(droid1.getName() + " переміг!");
        } else {
            System.out.println(droid2.getName() + " переміг!");
        }
    }
}
