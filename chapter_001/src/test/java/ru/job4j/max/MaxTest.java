package ru.job4j.max;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MaxTest {
    @Test
    public void whenFirstLesserSecond() {
        Max max = new Max();
        assertThat(max.max(5, 10), is(10));
    }

    @Test
    public void whenSecondLesserFirst() {
        Max max = new Max();
        assertThat(max.max(15, 10), is(15));
    }

    @Test
    public void whenThirdBiggerThanTwo() {
        Max max = new Max();
        assertThat(max.max(5, 10, 17), is(17));
    }
}
