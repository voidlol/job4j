package ru.job4j.lists;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * @author - Andrey Savelov
 * @version - 1.0
 * @since - 22.12.2018
 */
public class SimpleStackTest {

    private SimpleStack<Integer> ss = new SimpleStack<>();

    @Test
    public void poll() {
        ss.push(1);
        ss.push(2);
        ss.push(15);
        assertThat(ss.poll(), is(15));
        assertThat(ss.poll(), is(2));
    }

}