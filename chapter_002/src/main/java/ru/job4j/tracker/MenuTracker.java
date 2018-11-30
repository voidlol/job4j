package ru.job4j.tracker;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MenuTracker {
    private Input input;
    private Tracker tracker;
    private List<UserAction> actions = new ArrayList<>();

    public MenuTracker(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;
    }

    public void fillMenu() {
        actions.add(new AddNewItem());
        actions.add(new ShowAll());
        actions.add(new EditItem());
        actions.add(new DeleteItem());
        actions.add(new FindById());
        actions.add(new FindByName());
        actions.add(new Exit());
    }

    public void select(int key) throws IOException {
        this.actions.get(key).execute(this.input, this.tracker);
    }

    public void showMenu() {
        System.out.println("============МЕНЮ===========");
        for (UserAction action : actions) {
            System.out.println(action.info());
        }
        System.out.println("===========================");
    }

    private static class AddNewItem implements UserAction {

        @Override
        public int key() {
            return 0;
        }

        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Добавить новую заявку");
        }

        @Override
        public void execute(Input input, Tracker tracker) throws IOException {
            System.out.println("==Добавление новой заявки==");
            String name = input.getString("Введите имя заявки: ");
            String desc = input.getString("Введите описание заявки: ");
            Item item = tracker.add(new Item(name, desc));
            System.out.println("Новая заявка с ID: " + item.getId());
        }
    }

    private static class EditItem implements UserAction {

        @Override
        public int key() {
            return 2;
        }

        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Изменить заявку");
        }

        @Override
        public void execute(Input input, Tracker tracker) throws IOException {
            System.out.println("======Изменить заявку======");
            String id = input.getString("Введите ID заявки: ");
            String name = input.getString("Введите имя заявки: ");
            String desc = input.getString("Введите описание заявки: ");
            Item item = new Item(name, desc);
            if (tracker.replace(id, item)) {
                System.out.println("Заявка с ID: " + item.getId() + " обновлена.");
            } else {
                System.out.println("Заявка с ID: " + id + " не найдена.");
            }
        }
    }

    private static class DeleteItem implements UserAction {

        @Override
        public int key() {
            return 3;
        }

        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Удалить заявку");
        }

        @Override
        public void execute(Input input, Tracker tracker) throws IOException {
            System.out.println("=======Удалить заявку======");
            String id = input.getString("Введите ID заявки: ");
            if (tracker.delete(id)) {
                System.out.println("Заявка с ID: " + id + " удалена.");
            } else {
                System.out.println("Заявка с ID: " + id + " не найдена.");
            }
        }
    }

    private static class FindById implements UserAction {

        @Override
        public int key() {
            return 4;
        }

        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Поиск заявки по ID");
        }

        @Override
        public void execute(Input input, Tracker tracker) throws IOException {
            System.out.println("=====Поиск заявки по ID====");
            String id = input.getString("Введите ID заявки: ");
            Item item = tracker.findById(id);
            if (item != null) {
                System.out.println(item.toString());
            } else {
                System.out.println("Заявка с ID: " + id + " не найдена.");
            }
        }
    }

    private static class FindByName implements UserAction {

        @Override
        public int key() {
            return 5;
        }

        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Поиск заявок по имени");
        }

        @Override
        public void execute(Input input, Tracker tracker) throws IOException {
            System.out.println("===Поиск заявок по имени===");
            String name = input.getString("Введите имя заявки: ");
            Item[] items = tracker.findByName(name);
            for (Item item : items) {
                System.out.println(item.toString());
            }
        }
    }

    private static class ShowAll implements UserAction {

        @Override
        public int key() {
            return 1;
        }

        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Показать все заявки");
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("====Показать все заявки====");
            Item[] items = tracker.findAll();
            for (Item item : items) {
                System.out.println(item.toString());
            }
        }
    }

    private static class Exit implements UserAction {

        @Override
        public int key() {
            return 6;
        }

        @Override
        public String info() {
            return String.format("%s. %s", this.key(), "Выход");
        }

        @Override
        public void execute(Input input, Tracker tracker) {

        }
    }
}
