package com.droids;

public class Archer extends Droid {
    public Archer(String name) {
        super(name, 90, 15); // Здоров'я 90, атака 15
    }

    @Override
    public void attack(Droid enemy) {
        if (Math.random() > 0.8) { // 20% шанс на критичний удар
            System.out.println(this.name + " завдає критичний постріл!");
            enemy.takeDamage(this.damage * 2); // Подвійна шкода
        } else {
            System.out.println(this.name + " завдає точний постріл.");
            super.attack(enemy);
        }
    }
}
