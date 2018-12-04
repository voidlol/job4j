package ru.job4j.tracker;


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
        actions.add(new AddNewItem(0, "Добавить новую заявку"));
        actions.add(new ShowAll(1, "Показать все заявки"));
        actions.add(new EditItem(2, "Изменить заявку"));
        actions.add(new DeleteItem(3, "Удалить заявку"));
        actions.add(new FindById(4, "Поиск заявки по ID"));
        actions.add(new FindByName(5, "Поиск заявок по имени"));
        actions.add(new Exit(6, "Выход"));
    }

    public void select(int key) {
        this.actions.get(key).execute(this.input, this.tracker);
    }

    public void showMenu() {
        System.out.println("============МЕНЮ===========");
        for (UserAction action : actions) {
            System.out.println(action.info());
        }
        System.out.println("===========================");
    }

    public int[] getRange() {
        int[] range = new int[this.actions.size()];
        for (UserAction action : this.actions) {
            range[action.key()] = action.key();
        }
        return range;
    }

    private static class AddNewItem extends BaseAction {
        protected AddNewItem(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("==Добавление новой заявки==");
            String name = input.getString("Введите имя заявки: ");
            String desc = input.getString("Введите описание заявки: ");
            Item item = tracker.add(new Item(name, desc));
            System.out.println("Новая заявка с ID: " + item.getId());
        }
    }

    private static class EditItem extends BaseAction {


        protected EditItem(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
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

    private static class DeleteItem extends BaseAction {


        protected DeleteItem(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("=======Удалить заявку======");
            String id = input.getString("Введите ID заявки: ");
            if (tracker.delete(id)) {
                System.out.println("Заявка с ID: " + id + " удалена.");
            } else {
                System.out.println("Заявка с ID: " + id + " не найдена.");
            }
        }
    }

    private static class FindById extends BaseAction {


        protected FindById(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("=====Поиск заявки по ID====");
            String id = input.getString("Введите ID заявки: ");
            Item item = tracker.findById(id);
            if (item != null) {
                System.out.println(item);
            } else {
                System.out.println("Заявка с ID: " + id + " не найдена.");
            }
        }
    }

    private static class FindByName extends BaseAction {

        protected FindByName(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("===Поиск заявок по имени===");
            String name = input.getString("Введите имя заявки: ");
            Item[] items = tracker.findByName(name);
            for (Item item : items) {
                System.out.println(item);
            }
        }
    }

    private static class ShowAll extends BaseAction {


        protected ShowAll(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {
            System.out.println("====Показать все заявки====");
            Item[] items = tracker.findAll();
            for (Item item : items) {
                System.out.println(item);
            }
        }
    }

    private static class Exit extends BaseAction {

        protected Exit(int key, String name) {
            super(key, name);
        }

        @Override
        public void execute(Input input, Tracker tracker) {

        }
    }
}
