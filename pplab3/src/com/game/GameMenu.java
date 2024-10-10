package com.game;

import com.droids.*;
import com.utils.BattleHistory;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GameMenu {
    private List<Droid> droids = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public void start() {
        while (true) {
            showMenu();
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    createDroid();
                    break;
                case 2:
                    showDroids();
                    break;
                case 3:
                    fightOneOnOne();
                    break;
                case 4:
                    // Реалізація бою команда на команду
                    break;
                case 5:
                    saveFight();
                    break;
                case 6:
                    replayFight();
                    break;
                case 7:
                    System.out.println("Вихід...");
                    return;
            }
        }
    }

    private void showMenu() {
        System.out.println("1. Створити дроїда");
        System.out.println("2. Показати список дроїдів");
        System.out.println("3. Бій 1 на 1");
        System.out.println("4. Бій команда на команду");
        System.out.println("5. Записати бій у файл");
        System.out.println("6. Відтворити бій");
        System.out.println("7. Вийти");
    }

    private void createDroid() {
        System.out.println("Виберіть тип дроїда:");
        System.out.println("1. Маг");
        System.out.println("2. Воїн");
        System.out.println("3. Паладін");
        System.out.println("4. Лучник");

        int choice = scanner.nextInt();
        System.out.println("Введіть ім'я для дроїда:");
        String name = scanner.next();

        Droid newDroid;
        switch (choice) {
            case 1:
                newDroid = new Mage(name);
                break;
            case 2:
                newDroid = new Warrior(name);
                break;
            case 3:
                newDroid = new Paladin(name);
                break;
            case 4:
                newDroid = new Archer(name);
                break;
            default:
                System.out.println("Невірний вибір. Створюється Воїн за замовчуванням.");
                newDroid = new Warrior(name);
                break;
        }

        droids.add(newDroid);
        System.out.println("Дроїд " + name + " створений.");
    }

    private void showDroids() {
        if (droids.isEmpty()) {
            System.out.println("Немає створених дроїдів.");
        } else {
            System.out.println("Список дроїдів:");
            for (int i = 0; i < droids.size(); i++) {
                System.out.println((i + 1) + ". " + droids.get(i).getName());
            }
        }
    }

    private void fightOneOnOne() {
        if (droids.size() < 2) {
            System.out.println("Недостатньо дроїдів для бою.");
            return;
        }

        showDroids();
        System.out.println("Виберіть першого дроїда:");
        int droid1Index = scanner.nextInt() - 1;
        System.out.println("Виберіть другого дроїда:");
        int droid2Index = scanner.nextInt() - 1;

        Droid droid1 = droids.get(droid1Index);
        Droid droid2 = droids.get(droid2Index);

        Battle.oneOnOne(droid1, droid2);
    }

    private void saveFight() {
        // Збереження результатів бою у файл
        System.out.println("Запис бою у файл...");
        BattleHistory.saveBattle("Результат бою", "fight_result.txt");
    }

    private void replayFight() {
        // Відтворення результатів бою
        String result = BattleHistory.loadBattle("fight_result.txt");
        System.out.println(result);
    }
}
