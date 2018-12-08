package ru.job4j.tracker;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class StartUITest {
    private final PrintStream stdout = System.out;
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();
    private final String menu = "============МЕНЮ===========" + System.lineSeparator()
            + "0. Добавить новую заявку" + System.lineSeparator()
            + "1. Показать все заявки" + System.lineSeparator()
            + "2. Изменить заявку" + System.lineSeparator()
            + "3. Удалить заявку" + System.lineSeparator()
            + "4. Поиск заявки по ID" + System.lineSeparator()
            + "5. Поиск заявок по имени" + System.lineSeparator()
            + "6. Выход" + System.lineSeparator()
            + "===========================" + System.lineSeparator();

    @Before
    public void loadOutput() {
        System.setOut(new PrintStream(this.out));
    }

    @After
    public void backOutput() {
        System.setOut(this.stdout);
    }

    @Test
    public void whenInvalidInput() {
        ValidateInput input = new ValidateInput(new StubInput(new String[]{"sdfsdf", "1"}));
        input.getString("", new int[] {1});
        assertThat(this.out.toString(), is("Введите число." + System.lineSeparator()));
    }

    @Test
    public void whenInvalidNumberInput() {
        ValidateInput input = new ValidateInput(new StubInput(new String[]{"3", "1"}));
        input.getString("", new int[] {1});
        assertThat(this.out.toString(), is("Такого пункта нет, введите еще раз." + System.lineSeparator()));
    }

    @Test
    public void whenValidNumberInput() {
        ValidateInput input = new ValidateInput(new StubInput(new String[]{"1"}));
        input.getString("Enter", new int[] {1});
        assertThat(this.out.toString(), is(""));
    }

    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        Tracker tracker = new Tracker();
        ConsoleInput input = new StubInput(new String[]{"0", "test name", "desc", "6"});
        new StartUI(tracker, input).init();
        assertThat(tracker.findAll().get(0).getName(), is("test name"));
        assertThat(this.out.toString(), is(this.menu
                + "==Добавление новой заявки==" + System.lineSeparator()
                + "Новая заявка с ID: " + tracker.findAll().get(0).getId() + System.lineSeparator()
                + this.menu));
    }

    @Test
    public void whenUserEditItemThenTrackerHasNewItem() {
        Tracker tracker = new Tracker();
        Item item = new Item("Privet", "Kak dela");
        tracker.add(item);
        ConsoleInput input = new StubInput(new String[]{"2", item.getId(), "test name", "desc", "6"});
        new StartUI(tracker, input).init();
        assertThat(tracker.findAll().get(0).getName(), is("test name"));
        assertThat(this.out.toString(), is(this.menu
                + "======Изменить заявку======" + System.lineSeparator()
                + "Заявка с ID: " + item.getId() + " обновлена." + System.lineSeparator()
                + this.menu));
    }

    @Test
    public void whenUserDeleteItemThenTrackerRemovedItem() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("Privet", "Kak dela");
        Item item2 = new Item("Privet 2", "Kak dela 2");
        tracker.add(item1);
        tracker.add(item2);
        ConsoleInput input = new StubInput(new String[]{"3", item1.getId(), "6"});
        new StartUI(tracker, input).init();
        assertThat(tracker.findAll().get(0).getName(), is("Privet 2"));
        assertThat(this.out.toString(), is(this.menu
                + "=======Удалить заявку======" + System.lineSeparator()
                + "Заявка с ID: " + item1.getId() + " удалена." + System.lineSeparator()
                + this.menu));
    }

    @Test
    public void whenUserDeleteItemNotFoundThenTrackerShowError() {
        Tracker tracker = new Tracker();
        tracker.add(new Item("Privet", "Kak dela"));
        tracker.add(new Item("Privet 2", "Kak dela 2"));
        ConsoleInput input = new StubInput(new String[]{"3", "randomID", "6"});
        new StartUI(tracker, input).init();
        assertThat(this.out.toString(), is(this.menu
                + "=======Удалить заявку======" + System.lineSeparator()
                + "Заявка с ID: " + "randomID" + " не найдена." + System.lineSeparator()
                + this.menu));
    }

    @Test
    public void whenUserShowAllItemsThenTrackerShowsAll() {
        Tracker tracker = new Tracker();
        Item item1 = new Item("Privet", "Kak dela");
        Item item2 = new Item("Privet 2", "Kak dela 2");
        tracker.add(item1);
        tracker.add(item2);
        ConsoleInput input = new StubInput(new String[]{"1", "6"});
        new StartUI(tracker, input).init();
        assertThat(this.out.toString(), is(this.menu
                + "====Показать все заявки====" + System.lineSeparator()
                + "Заявка: Privet" + System.lineSeparator()
                + "Kak dela" + System.lineSeparator()
                + "Заявка: Privet 2" + System.lineSeparator()
                + "Kak dela 2" + System.lineSeparator()
                + this.menu));
    }

    @Test
    public void whenUserFindByIdThenTrackerShowsById() {
        Tracker tracker = new Tracker();
        tracker.add(new Item("Privet", "Kak dela"));
        Item item2 = tracker.add(new Item("Privet 2", "Kak dela 2"));
        ConsoleInput input = new StubInput(new String[]{"4", item2.getId(), "6"});
        new StartUI(tracker, input).init();
        assertThat(this.out.toString(), is(this.menu
                + "=====Поиск заявки по ID====" + System.lineSeparator()
                + "Заявка: Privet 2" + System.lineSeparator()
                + "Kak dela 2" + System.lineSeparator()
                + this.menu));
    }

    @Test
    public void whenUserFindByIdNotFoundThenTrackerShowsError() {
        Tracker tracker = new Tracker();
        tracker.add(new Item("Privet", "Kak dela"));
        tracker.add(new Item("Privet 2", "Kak dela 2"));
        ConsoleInput input = new StubInput(new String[]{"4", "randomID", "6"});
        new StartUI(tracker, input).init();
        assertThat(this.out.toString(), is(this.menu
                + "=====Поиск заявки по ID====" + System.lineSeparator()
                + "Заявка с ID: randomID не найдена." + System.lineSeparator()
                + this.menu));
    }

    @Test
    public void whenUserFindByNameThenTrackerShowsByName() {
        Tracker tracker = new Tracker();
        tracker.add(new Item("Privet 2", "Kak dela"));
        tracker.add(new Item("Privet 2", "Kak dela 2"));
        ConsoleInput input = new StubInput(new String[]{"5", "Privet 2", "6"});
        new StartUI(tracker, input).init();
        assertThat(this.out.toString(), is(this.menu
                + "===Поиск заявок по имени===" + System.lineSeparator()
                + "Заявка: Privet 2" + System.lineSeparator()
                + "Kak dela" + System.lineSeparator()
                + "Заявка: Privet 2" + System.lineSeparator()
                + "Kak dela 2" + System.lineSeparator()
                + this.menu));
    }
}