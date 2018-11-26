package ru.job4j.converter;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ConverterTest {
    @Test
    public void when152rubToEuroThenTwoEuro() {
        Converter conv = new Converter();
        int result = conv.rubToEuro(152);
        int expected = 2;
        assertThat(result, is(expected));
    }

    @Test
    public void when204rubToUsdThenThreeUsd() {
        Converter conv = new Converter();
        int result = conv.rubToUsd(204);
        int expected = 3;
        assertThat(result, is(expected));
    }

    @Test
    public void whenFiveUsdToRubThen340Rub() {
        Converter conv = new Converter();
        int result = conv.usdToRub(5);
        int expected = 340;
        assertThat(result, is(expected));
    }

    @Test
    public void whenFourEuroToRubThen304Rub() {
        Converter conv = new Converter();
        int result = conv.euroToRub(4);
        int expected = 304;
        assertThat(result, is(expected));
    }
}
