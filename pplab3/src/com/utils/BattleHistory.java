package com.utils;

import java.io.*;

public class BattleHistory {

    public static void saveBattle(String battleResult, String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            writer.write(battleResult);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String loadBattle(String filename) {
        StringBuilder result = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                result.append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result.toString();
    }
}
