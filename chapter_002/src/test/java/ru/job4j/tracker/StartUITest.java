package ru.job4j.tracker;

import org.junit.Test;
import java.io.IOException;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class StartUITest {
    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() throws IOException {
        Tracker tracker = new Tracker();
        ConsoleInput input = new StubInput(new String[]{"0", "test name", "desc", "6"});
        new StartUI(tracker, input).init();
        assertThat(tracker.findAll()[0].getName(), is("test name"));
    }

    @Test
    public void whenUserEditItemThenTrackerHasNewItem() throws IOException {
        Tracker tracker = new Tracker();
        Item item = new Item("Privet", "Kak dela");
        tracker.add(item);
        ConsoleInput input = new StubInput(new String[]{"2", item.getId(), "test name", "desc", "6"});
        new StartUI(tracker, input).init();
        assertThat(tracker.findAll()[0].getName(), is("test name"));
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
    }
}