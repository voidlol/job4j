package ru.job4j.tracker;

public class ValidateInput implements Input {

    private final Input input;

    public ValidateInput(Input input) {
        this.input = input;
    }

    @Override
    public String getString(String output) {
        return this.input.getString(output);
    }

    @Override
    public int getString(String output, int[] range) {
        boolean pass = false;
        int key = -1;
        do {
            try {
                key = this.input.getString(output, range);
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
