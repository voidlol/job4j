package ru.job4j.tracker;

public class ValidateInput extends ConsoleInput {

    @Override
    public int getString(String output, int[] range) {
        boolean pass = false;
        int key = -1;
        do {
            try {
                key = super.getString(output, range);
                pass = true;
            } catch (MenuOutException moe) {
                System.out.println("Такого пункта нет, введите еще раз.");
            } catch (NumberFormatException nfe) {
                System.out.println("Введите число.");
            }
        } while (!pass);
        return key;
    }
}
