package ru.job4j.lambda;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class LambdaFuncTest {
    private final LambdaFunc lf = new LambdaFunc();

    @Test
    public void whenLineFunc() {
        List<Double> list = new ArrayList<>(lf.diapason(1, 10, lf::line));
        assertThat(list.get(3), is(4d));
    }

    @Test
    public void whenSquareFunc() {
        List<Double> list = new ArrayList<>(lf.diapason(1, 10, lf::square));
        assertThat(list.get(1), is(4d));
    }
    @Test
    public void whenLogFunc() {
        List<Double> list = new ArrayList<>(lf.diapason(1, 10, lf::log));
        assertThat(list.get(9), is(1d));
    }

}