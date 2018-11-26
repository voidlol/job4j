package ru.job4j.calculate;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CalculatorTest {
    @Test
    public void whenAddOnePlusOneThenTwo() {
        Calculator calc = new Calculator();
        calc.add(1D, 1D);
        double result = calc.getResult();
        double expected = 2D;
        assertThat(result, is(expected));
    }

    @Test
    public void whenDivFiveByOneThenFive() {
        Calculator calc = new Calculator();
        calc.div(5D, 1D);
        double result = calc.getResult();
        double expected = 5D;
        assertThat(result, is(expected));
    }

    @Test
    public void whenMultiplyThreeByTwoThenSix() {
        Calculator calc = new Calculator();
        calc.multiply(3D, 2D);
        double result = calc.getResult();
        double expected = 6D;
        assertThat(result, is(expected));
    }

    @Test
    public void whenSubtractTenByTwoThenEight() {
        Calculator calc = new Calculator();
        calc.subtract(10D, 2D);
        double result = calc.getResult();
        double expected = 8D;
        assertThat(result, is(expected));
    }
}
