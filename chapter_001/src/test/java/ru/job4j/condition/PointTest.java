package ru.job4j.condition;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.number.IsCloseTo.closeTo;

public class PointTest {
    @Test
    public void distanceToTest() {
        Point a = new Point(10, 7);
        Point b = new Point(5, 2);
        assertThat(b.distanceTo(a), closeTo(7, 0.1D));
    }
}
