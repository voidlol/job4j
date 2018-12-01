package ru.job4j.tracker;

import java.util.Scanner;

public class ConsoleInput implements Input {
    private final Scanner scanner = new Scanner(System.in);

    @Override
    public String getString(String output) {
        System.out.print(output);
        return scanner.nextLine();
    }

    @Override
    public int getString(String output, int[] range) {
        int key = Integer.parseInt(this.getString(output));
        boolean exists = false;
        for (int value : range) {
            if (key == value) {
                exists = true;
                break;
            }
        }
        if (exists) {
            return key;
        } else {
            throw new MenuOutException("Out of menu range.");
        }
    }
}
