package com.droids;

import com.utils.BattleHistory;

import java.util.List;
import java.util.Random;

public class Battle {
    public static StringBuilder battleLog = new StringBuilder();  // Лог бою

    public static void oneOnOne(Droid droid1, Droid droid2) {
        Random random = new Random();
        battleLog.append("Бій між ").append(droid1.getName()).append(" і ").append(droid2.getName()).append(" розпочався!\n");

        while (droid1.isAlive() && droid2.isAlive()) {
            if (random.nextBoolean()) {
                droid1.attack(droid2);
                battleLog.append(droid1.getName()).append(" атакує ").append(droid2.getName()).append(", залишок HP у ").append(droid2.getName()).append(": ").append(droid2.getHealth()).append("\n");
            } else {
                droid2.attack(droid1);
                battleLog.append(droid2.getName()).append(" атакує ").append(droid1.getName()).append(", залишок HP у ").append(droid1.getName()).append(": ").append(droid1.getHealth()).append("\n");
            }
        }

        if (droid1.isAlive()) {
            battleLog.append(droid1.getName()).append(" переміг!\n");
        } else {
            battleLog.append(droid2.getName()).append(" переміг!\n");
        }

        BattleHistory.saveBattle(battleLog.toString(), "battle_result.txt");
        System.out.println("Результат бою збережено у файл 'battle_result.txt'.");
    }

    public static void teamBattle(List<Droid> team1, List<Droid> team2) {
        Random random = new Random();
        battleLog.setLength(0); // Очищаємо лог для нового бою
        battleLog.append("Бій між командами розпочався!\n");

        while (isTeamAlive(team1) && isTeamAlive(team2)) {
            Droid droid1 = getRandomAliveDroid(team1, random);
            Droid droid2 = getRandomAliveDroid(team2, random);

            if (random.nextBoolean()) {
                droid1.attack(droid2);
                battleLog.append(droid1.getName()).append(" атакує ").append(droid2.getName()).append(", залишок HP у ").append(droid2.getName()).append(": ").append(droid2.getHealth()).append("\n");
            } else {
                droid2.attack(droid1);
                battleLog.append(droid2.getName()).append(" атакує ").append(droid1.getName()).append(", залишок HP у ").append(droid1.getName()).append(": ").append(droid1.getHealth()).append("\n");
            }
        }

        if (isTeamAlive(team1)) {
            battleLog.append("Команда 1 перемогла!\n");
        } else {
            battleLog.append("Команда 2 перемогла!\n");
        }

        BattleHistory.saveBattle(battleLog.toString(), "team_battle_result.txt");
        System.out.println("Результат командного бою збережено у файл 'team_battle_result.txt'.");
    }

    private static boolean isTeamAlive(List<Droid> team) {
        for (Droid droid : team) {
            if (droid.isAlive()) {
                return true;
            }
        }
        return false;
    }

    private static Droid getRandomAliveDroid(List<Droid> team, Random random) {
        Droid droid;
        do {
            droid = team.get(random.nextInt(team.size()));
        } while (!droid.isAlive());
        return droid;
    }
}
