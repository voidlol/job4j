package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class CheckTest {

    @Test
    public void monoFalse() {
        Check check = new Check();
        boolean[] data = new boolean[] {true, true, true, true, false};
        boolean expected = false;
        assertThat(check.mono(data), is(expected));
    }

    @Test
    public void monoTrue() {
        Check check = new Check();
        boolean[] data = new boolean[] {true, true, true, true};
        boolean expected = true;
        assertThat(check.mono(data), is(expected));
    }

    @Test
    public void monoTrueWhenAllFalse() {
        Check check = new Check();
        boolean[] data = new boolean[] {false, false, false, false};
        boolean expected = true;
        assertThat(check.mono(data), is(expected));
    }
}