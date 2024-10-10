package com.droids;

public class Warrior extends Droid {
    public Warrior(String name) {
        super(name, 150, 20);
    }

    @Override
    public void attack(Droid enemy) {
        System.out.println(this.name + " завдає могутнього удару мечем.");
        super.attack(enemy);
    }
}
