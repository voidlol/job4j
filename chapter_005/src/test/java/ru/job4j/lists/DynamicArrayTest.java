package ru.job4j.lists;

import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * @author - Andrey Savelov
 * @version - 1.0
 * @since - 22.12.2018
 */
public class DynamicArrayTest {

    private DynamicArray<Integer> da = new DynamicArray<>();

    @Test
    public void add() {
        da.add(5);
        Iterator<Integer> it = da.iterator();
        assertThat(it.next(), is(5));
    }

    @Test
    public void grow() {
        da.add(5);
        da.add(5);
        da.add(5);
        da.add(5);
        da.add(5);
        da.add(5);
        da.add(5);
        da.add(5);
        da.add(5);
        da.add(5);
        da.add(5);
        da.add(5);
    }

    @Test
    public void get() {
        da.add(10);
        assertThat(da.get(0), is(10));
    }

    @Test (expected = ConcurrentModificationException.class)
    public void iterator() {
        da.add(4);
        Iterator<Integer> it = da.iterator();
        da.add(3);
        it.next();
    }
}