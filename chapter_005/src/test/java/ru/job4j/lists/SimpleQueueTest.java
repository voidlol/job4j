package ru.job4j.lists;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * @author - Andrey Savelov
 * @version - 1.0
 * @since - 23.12.2018
 */
public class SimpleQueueTest {

    private SimpleQueue<Integer> sq = new SimpleQueue<>();

    @Test
    public void poll() {
        sq.push(5);
        sq.push(9);
        sq.push(7);
        sq.push(6);
        assertThat(sq.poll(), is(5));
        assertThat(sq.poll(), is(9));
        assertThat(sq.poll(), is(7));
        assertThat(sq.poll(), is(6));
    }

    @Test
    public void push() {
        sq.push(5);
    }
}