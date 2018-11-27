package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class FindLoopTest {

    @Test
    public void indexOfNormalCase() {
        FindLoop fl = new FindLoop();
        int[] data = new int[] {7, 15, 4, 22};
        int expected = 1;
        assertThat(fl.indexOf(data, 15), is(expected));
    }

    @Test
    public void indexOfWhenNotFound() {
        FindLoop fl = new FindLoop();
        int[] data = new int[] {7, 15, 4, 22};
        int expected = -1;
        assertThat(fl.indexOf(data, 77), is(expected));
    }
}