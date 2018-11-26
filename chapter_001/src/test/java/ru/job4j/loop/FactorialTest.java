package ru.job4j.loop;
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class FactorialTest {
    @Test
    public void factorialOfSix() {
        Factorial fact = new Factorial();
        assertThat(fact.calc(6), is(720));
    }

    @Test
    public void factorialOfZero() {
        Factorial fact = new Factorial();
        assertThat(fact.calc(0), is(1));
    }
}
