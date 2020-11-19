package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class BubbleSortTest {

    @Test
    public void sort() {
        BubbleSort bs = new BubbleSort();
        int[] array = new int[] {5, 3, 2, 4, 1};
        int[] expected = new int[] {1, 2, 3, 4, 5};
        assertThat(bs.sort(array), is(expected));
    }
}