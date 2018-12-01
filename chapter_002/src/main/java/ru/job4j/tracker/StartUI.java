package ru.job4j.tracker;

public class StartUI {
    private static final int EXIT = 6;

    private final Tracker tracker;
    private final Input input;

    public StartUI(Tracker tracker, Input input) {
        this.input = input;
        this.tracker = tracker;
    }

    public void init() {
        MenuTracker menu = new MenuTracker(this.input, this.tracker);
        int answer = -1;
        menu.fillMenu();
        do {
            menu.showMenu();
            answer = input.getString("Выберите пункт меню: ", menu.getRange());
            menu.select(answer);
        } while (EXIT != answer);
    }

    public static void main(String[] args) {
        new StartUI(new Tracker(), new ValidateInput()).init();
    }
}
