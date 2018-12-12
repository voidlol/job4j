package ru.job4j.tracker;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class TrackerSingleton1Test {

    private final TrackerSingleton1 tracker = TrackerSingleton1.getINSTANCE();
    private final Item item1 = new Item("Item 1", "Desc 1");
    private final Item item2 = new Item("Item 1", "Desc 2");
    private final Item item3 = new Item("Item 3", "Desc 3");
    private final Item item4 = new Item("Item 4", "Desc 4");

    @Test
    public void add() {
        tracker.add(item1);
        String id = item1.getId();
        assertThat(tracker.findById(id), is(item1));
    }

    @Test
    public void replace() {
        tracker.add(item1);
        tracker.replace(item1.getId(), item3);
        assertThat(tracker.findById(item1.getId()), is(item3));
    }

    @Test
    public void delete() {
        tracker.add(item1);
        tracker.add(item3);
        tracker.add(item4);
        tracker.delete(item3.getId());
        List<Item> expected = new ArrayList<Item>(Arrays.asList(new Item[]{item1, item4}));
        assertThat(tracker.findAll(), is(expected));
    }

    @Test
    public void findAll() {
        tracker.add(item1);
        tracker.add(item3);
        tracker.add(item4);
        List<Item> expected = new ArrayList<Item>(Arrays.asList(new Item[] {item1, item3, item4}));
        assertThat(tracker.findAll(), is(expected));
    }

    @Test
    public void findById() {
        tracker.add(item1);
        String id = item1.getId();
        assertThat(tracker.findById(id), is(item1));
    }

    @Test
    public void findByName() {
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        List<Item> expected = new ArrayList<>(Arrays.asList(new Item[] {item1, item2}));
        assertThat(tracker.findByName("Item 1"), is(expected));
    }

}