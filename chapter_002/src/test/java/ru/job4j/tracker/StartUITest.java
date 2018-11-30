package ru.job4j.tracker;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class StartUITest {
    private final PrintStream stdout = System.out;
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();
    private final String menu = new StringBuilder()
            .append("============МЕНЮ===========").append(System.lineSeparator())
            .append("0. Добавить новую заявку").append(System.lineSeparator())
            .append("1. Показать все заявки").append(System.lineSeparator())
            .append("2. Изменить заявку").append(System.lineSeparator())
            .append("3. Удалить заявку").append(System.lineSeparator())
            .append("4. Поиск заявки по ID").append(System.lineSeparator())
            .append("5. Поиск заявок по имени").append(System.lineSeparator())
            .append("6. Выход").append(System.lineSeparator())
            .append("===========================").append(System.lineSeparator()).toString();

    @Before
    public void loadOutput() {
        System.setOut(new PrintStream(this.out));
    }

    @After
    public void backOutput() {
        System.setOut(this.stdout);
    }

    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() throws IOException {
        Tracker tracker = new Tracker();
        ConsoleInput input = new StubInput(new String[]{"0", "test name", "desc", "6"});
        new StartUI(tracker, input).init();
        assertThat(tracker.findAll()[0].getName(), is("test name"));
        assertThat(this.out.toString(), is(new StringBuilder()
                .append(this.menu)
                .append("==Добавление новой заявки==").append(System.lineSeparator())
                .append("Новая заявка с ID: ").append(tracker.findAll()[0].getId()).append(System.lineSeparator())
                .append(this.menu).toString()));
    }

    @Test
    public void whenUserEditItemThenTrackerHasNewItem() throws IOException {
        Tracker tracker = new Tracker();
        Item item = new Item("Privet", "Kak dela");
        tracker.add(item);
        ConsoleInput input = new StubInput(new String[]{"2", item.getId(), "test name", "desc", "6"});
        new StartUI(tracker, input).init();
        assertThat(tracker.findAll()[0].getName(), is("test name"));
        assertThat(this.out.toString(), is(new StringBuilder()
                .append(this.menu)
                .append("======Изменить заявку======").append(System.lineSeparator())
                .append("Заявка с ID: ").append(item.getId()).append(" обновлена.").append(System.lineSeparator())
                .append(this.menu).toString()));
    }

    @Test
    public void whenUserDeleteItemThenTrackerRemovedItem() throws IOException {
        Tracker tracker = new Tracker();
        Item item1 = new Item("Privet", "Kak dela");
        Item item2 = new Item("Privet 2", "Kak dela 2");
        tracker.add(item1);
        tracker.add(item2);
        ConsoleInput input = new StubInput(new String[]{"3", item1.getId(), "6"});
        new StartUI(tracker, input).init();
        assertThat(tracker.findAll()[0].getName(), is("Privet 2"));
        assertThat(this.out.toString(), is(new StringBuilder()
                .append(this.menu)
                .append("=======Удалить заявку======").append(System.lineSeparator())
                .append("Заявка с ID: ").append(item1.getId()).append(" удалена.").append(System.lineSeparator())
                .append(this.menu).toString()));
    }

    @Test
    public void whenUserDeleteItemNotFoundThenTrackerShowError() throws IOException {
        Tracker tracker = new Tracker();
        Item item1 = tracker.add(new Item("Privet", "Kak dela"));
        Item item2 = tracker.add(new Item("Privet 2", "Kak dela 2"));
        ConsoleInput input = new StubInput(new String[]{"3", "randomID", "6"});
        new StartUI(tracker, input).init();
        assertThat(this.out.toString(), is(new StringBuilder()
                .append(this.menu)
                .append("=======Удалить заявку======").append(System.lineSeparator())
                .append("Заявка с ID: ").append("randomID").append(" не найдена.").append(System.lineSeparator())
                .append(this.menu).toString()));
    }

    @Test
    public void whenUserShowAllItemsThenTrackerShowsAll() throws IOException {
        Tracker tracker = new Tracker();
        Item item1 = new Item("Privet", "Kak dela");
        Item item2 = new Item("Privet 2", "Kak dela 2");
        tracker.add(item1);
        tracker.add(item2);
        ConsoleInput input = new StubInput(new String[]{"1", "6"});
        new StartUI(tracker, input).init();
        assertThat(this.out.toString(), is(new StringBuilder()
                .append(this.menu)
                .append("====Показать все заявки====").append(System.lineSeparator())
                .append("Заявка: Privet").append(System.lineSeparator())
                .append("Kak dela").append(System.lineSeparator())
                .append("Заявка: Privet 2").append(System.lineSeparator())
                .append("Kak dela 2").append(System.lineSeparator())
                .append(this.menu).toString()));
    }

    @Test
    public void whenUserFindByIdThenTrackerShowsById() throws IOException {
        Tracker tracker = new Tracker();
        Item item1 = tracker.add(new Item("Privet", "Kak dela"));
        Item item2 = tracker.add(new Item("Privet 2", "Kak dela 2"));
        ConsoleInput input = new StubInput(new String[]{"4", item2.getId(), "6"});
        new StartUI(tracker, input).init();
        assertThat(this.out.toString(), is(new StringBuilder()
                .append(this.menu)
                .append("=====Поиск заявки по ID====").append(System.lineSeparator())
                .append("Заявка: Privet 2").append(System.lineSeparator())
                .append("Kak dela 2").append(System.lineSeparator())
                .append(this.menu).toString()));
    }

    @Test
    public void whenUserFindByIdNotFoundThenTrackerShowsError() throws IOException {
        Tracker tracker = new Tracker();
        Item item1 = tracker.add(new Item("Privet", "Kak dela"));
        Item item2 = tracker.add(new Item("Privet 2", "Kak dela 2"));
        ConsoleInput input = new StubInput(new String[]{"4", "randomID", "6"});
        new StartUI(tracker, input).init();
        assertThat(this.out.toString(), is(new StringBuilder()
                .append(this.menu)
                .append("=====Поиск заявки по ID====").append(System.lineSeparator())
                .append("Заявка с ID: randomID не найдена.").append(System.lineSeparator())
                .append(this.menu).toString()));
    }

    @Test
    public void whenUserFindByNameThenTrackerShowsByName() throws IOException {
        Tracker tracker = new Tracker();
        Item item1 = tracker.add(new Item("Privet 2", "Kak dela"));
        Item item2 = tracker.add(new Item("Privet 2", "Kak dela 2"));
        ConsoleInput input = new StubInput(new String[]{"5", "Privet 2", "6"});
        new StartUI(tracker, input).init();
        assertThat(this.out.toString(), is(new StringBuilder()
                .append(this.menu)
                .append("===Поиск заявок по имени===").append(System.lineSeparator())
                .append("Заявка: Privet 2").append(System.lineSeparator())
                .append("Kak dela").append(System.lineSeparator())
                .append("Заявка: Privet 2").append(System.lineSeparator())
                .append("Kak dela 2").append(System.lineSeparator())
                .append(this.menu).toString()));
    }
}