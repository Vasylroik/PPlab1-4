package com.droids;

public class Paladin extends Droid {
    private int healingPower;

    public Paladin(String name) {
        super(name, 120, 25);
        this.healingPower = 20;
    }

    public void heal() {
        if (this.health > 0) {
            this.health += healingPower;
            System.out.println(this.name + " відновлює здоров'я на " + healingPower + " одиниць.");
        }
    }

    @Override
    public void attack(Droid enemy) {
        super.attack(enemy);
        if (Math.random() > 0.7) { // 30% шанс зцілення
            heal();
        }
    }
}
