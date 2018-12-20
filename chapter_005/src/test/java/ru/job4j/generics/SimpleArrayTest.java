package ru.job4j.generics;

import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * @author - Andrey Savelov
 * @since - 21.12.2018
 */
public class SimpleArrayTest {

    private SimpleArray<Integer> sa = new SimpleArray<>(5);
    private Iterator it = sa.iterator();

    @Test
    public void add() {
        sa.add(2);
        assertThat(it.next(), is(2));
    }

    @Test
    public void get() {
        sa.add(5);
        assertThat(sa.get(0), is(5));
    }

    @Test
    public void remove() {
        sa.add(2);
        sa.add(3);
        sa.add(4);
        sa.remove(1);
        assertThat(sa.get(1), is(4));
    }

    @Test
    public void set() {
        sa.add(3);
        sa.set(0, 15);
        assertThat(sa.get(0), is(15));
    }
}