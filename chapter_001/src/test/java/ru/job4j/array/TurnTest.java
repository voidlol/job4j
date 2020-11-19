package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class TurnTest {

    @Test
    public void backWhenEven() {
        Turn turn = new Turn();
        int[] array = new int[] {1, 2, 3, 4, 5, 6};
        int[] expected = new int[] {6, 5, 4, 3, 2, 1};
        assertThat(turn.back(array), is(expected));
    }

    @Test
    public void backWhenOdd() {
        Turn turn = new Turn();
        int[] array = new int[] {1, 2, 3, 4, 5, 6, 7};
        int[] expected = new int[] {7, 6, 5, 4, 3, 2, 1};
        assertThat(turn.back(array), is(expected));
    }
}