package ru.job4j.maps;

import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * @author - Andrey Savelov
 * @version - 1.0
 * @since - 26.12.2018
 */
public class SimpleMapTest {

    private SimpleMap<String, Integer> sm = new SimpleMap<>();

    @Test
    public void whenAddThenAdded() {
        sm.insert("Perviy", 15);
        assertThat(sm.insert("Perviy", 10), is(false));
    }

    @Test
    public void whenGetExistingItemThenTrue() {
        sm.insert("Test", 15);
        assertThat(sm.get("Test"), is(15));
    }

    @Test
    public void whenGetNotExistingItemThenFalse() {
        sm.insert("Test", 15);
        assertNull(sm.get("tesst"));
    }

    @Test
    public void iteratorTest() {
        sm.insert("Perviy", 15);
        sm.insert("Vtoroy", 10);
        sm.insert("Tretiy", 5);
        sm.insert("Chetvertiy", 0);
        Iterator it = sm.iterator();
        System.out.println(it.next() + "\n" + it.next() + "\n" + it.next() + "\n" + it.next());
        assertThat(it.hasNext(), is(false));
    }

    @Test
    public void whenDeleteExistingItemThenDelete() {
        sm.insert("test", 10);
        assertThat(sm.delete("test"), is(true));
    }

    @Test
    public void whenDeleteNotExistingItemThenDeleteIsFalse() {
        sm.insert("test", 10);
        assertThat(sm.delete("test2"), is(false));
    }

    @Test
    public void growTest() {
        int count = 0;
        for (int i = 0; i < 30; i++) {
            if (sm.insert(String.valueOf(i), i)) {
                count++;
            }
        }
        System.out.println(count);
        assertThat(count > 16, is(true));
    }
}