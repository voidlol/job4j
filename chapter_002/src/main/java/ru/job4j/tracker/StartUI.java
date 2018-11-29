package ru.job4j.tracker;

import java.io.IOException;

public class StartUI {
    private static final String ADD = "0";
    private static final String SHOW = "1";
    private static final String EDIT = "2";
    private static final String DELETE = "3";
    private static final String FIND_BY_ID = "4";
    private static final String FIND_BY_NAME = "5";
    private static final String EXIT = "6";

    private final Tracker tracker;
    private final ConsoleInput input;

    public StartUI(Tracker tracker, ConsoleInput input) {
        this.input = input;
        this.tracker = tracker;
    }

    public void init() throws IOException {
        boolean exit = false;
        while (!exit) {
            this.showMenu();
            String answer = this.input.getString("Выберите пункт меню: ");
            switch (answer) {
                case ADD:
                    this.addNew();
                    break;
                case SHOW:
                    this.show();
                    break;
                case EDIT:
                    this.edit();
                    break;
                case DELETE:
                    this.delete();
                    break;
                case FIND_BY_ID:
                    this.findById();
                    break;
                case FIND_BY_NAME:
                    this.findByName();
                    break;
                case EXIT:
                    exit = true;
                    break;
                default:
                    System.out.println("Такого пункта нет.");
                    break;
            }

        }
    }

    private void showMenu() {
        System.out.println("============МЕНЮ===========");
        System.out.println("0. Добавить новую заявку");
        System.out.println("1. Показать все заявки");
        System.out.println("2. Изменить заявку");
        System.out.println("3. Удалить заявку");
        System.out.println("4. Поиск заявки по ID");
        System.out.println("5. Поиск заявок по имени");
        System.out.println("6. Выход");
        System.out.println("===========================");
    }

    private void addNew() throws IOException {
        System.out.println("==Добавление новой заявки==");
        String name = this.input.getString("Введите имя заявки: ");
        String desc = this.input.getString("Введите описание заявки: ");
        Item item = new Item(name, desc);
        this.tracker.add(item);
        System.out.println("Новая заявка с ID: " + item.getId());
    }

    private void edit() throws IOException {
        System.out.println("======Изменить заявку======");
        String id = this.input.getString("Введите ID заявки: ");
        String name = this.input.getString("Введите имя заявки: ");
        String desc = this.input.getString("Введите описание заявки: ");
        Item item = new Item(name, desc);
        if (this.tracker.replace(id, item)) {
            System.out.println("Новая заявка с ID: " + item.getId());
        } else {
            System.out.println("Заявка с ID: " + id + " не найдена.");
        }
    }

    private void delete() throws IOException {
        System.out.println("=======Удалить заявку======");
        String id = this.input.getString("Введите ID заявки: ");
        if (this.tracker.delete(id)) {
            System.out.println("Заявка с ID: " + id + " удалена");
        } else {
            System.out.println("Заявка с ID: " + id + " не найдена.");
        }
    }

    private void findById() throws IOException {
        System.out.println("=====Поиск заявки по ID====");
        String id = this.input.getString("Введите ID заявки: ");
        Item item = this.tracker.findById(id);
        if (item != null) {
            System.out.println("Заявка с ID: " + item.getName() + System.lineSeparator() + item.getDescription());
        } else {
            System.out.println("Заявка с ID: " + id + " не найдена.");
        }
    }

    private void findByName() throws IOException {
        System.out.println("===Поиск заявок по имени===");
        String name = this.input.getString("Введите имя заявки: ");
        Item[] items = this.tracker.findByName(name);
        for (Item item: items) {
            System.out.println("Заявка: " + item.getName() + System.lineSeparator() + item.getDescription());
        }
    }

    private void show() {
        System.out.println("====Показать все заявки====");
        Item[] items = this.tracker.findAll();
        for (Item item: items) {
            System.out.println("Заявка: " + item.getName() + System.lineSeparator() + item.getDescription());
        }
    }

    public static void main(String[] args) throws IOException {
        new StartUI(new Tracker(), new ConsoleInput()).init();
    }
}
