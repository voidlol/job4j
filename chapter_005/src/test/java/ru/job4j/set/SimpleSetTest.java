package ru.job4j.set;

import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * @author - Andrey Savelov
 * @version - 1.0
 * @since - 24.12.2018
 */
public class SimpleSetTest {

    private SimpleSet<Integer> set = new SimpleSet<>();

    @Test
    public void whenAdd2SameElementsAnd1OtherThenSetHas2Elements() {
        set.add(5);
        set.add(5);
        set.add(10);
        Iterator<Integer> it = set.iterator();
        assertThat(it.next(), is(5));
        assertThat(it.next(), is(10));
        assertThat(it.hasNext(), is(false));
    }
}