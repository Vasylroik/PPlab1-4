package com.droids;

public class Mage extends Droid {
    private int mana;

    public Mage(String name) {
        super(name, 70, 30);
        this.mana = 100;
    }

    public void castSpell(Droid enemy) {
        if (mana >= 20) {
            System.out.println(this.name + " використовує закляття на " + enemy.getName());
            enemy.takeDamage(this.damage);
            mana -= 20;
        } else {
            System.out.println(this.name + " не вистачає мани для закляття.");
        }
    }

    @Override
    public void attack(Droid enemy) {
        if (mana >= 20) {
            castSpell(enemy);
        } else {
            System.out.println(this.name + " завдає звичайного удару.");
            super.attack(enemy);
        }
    }
}
