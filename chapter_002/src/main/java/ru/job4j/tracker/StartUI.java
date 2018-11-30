package ru.job4j.tracker;

import java.io.IOException;

public class StartUI {
    private static final String EXIT = "6";

    private final Tracker tracker;
    private final Input input;

    public StartUI(Tracker tracker, Input input) {
        this.input = input;
        this.tracker = tracker;
    }

    public void init() throws IOException {
        MenuTracker menu = new MenuTracker(this.input, this.tracker);
        String answer = null;
        menu.fillMenu();
        do {
            menu.showMenu();
            answer = input.getString("Выберите пункт меню: ");
            menu.select(Integer.valueOf(answer));
        } while (!EXIT.equals(answer));
    }

    public static void main(String[] args) throws IOException {
        new StartUI(new Tracker(), new ConsoleInput()).init();
    }
}
