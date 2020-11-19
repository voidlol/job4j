package ru.job4j.loop;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class CounterTest {
    @Test
    public void whenOneToTenThenThirty() {
        Counter count = new Counter();
        assertThat(count.add(1, 10), is(30));
    }
}
