package ru.job4j.array;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SquareTest {

    @Test
    public void whenBound3Then149() {
        Square sq = new Square();
        int[] exptected = new int[] {1, 4, 9};
        assertThat(sq.calculate(3), is(exptected));
    }

    @Test
    public void whenBound5Then1491625() {
        Square sq = new Square();
        int[] exptected = new int[] {1, 4, 9, 16, 25};
        assertThat(sq.calculate(5), is(exptected));
    }

    @Test
    public void whenBound7Then14916253649() {
        Square sq = new Square();
        int[] exptected = new int[] {1, 4, 9, 16, 25, 36, 49};
        assertThat(sq.calculate(7), is(exptected));
    }
}