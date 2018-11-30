package ru.job4j.pseudo;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class PaintTest {

    private final PrintStream STDOUT = System.out;
    private final ByteArrayOutputStream OUT = new ByteArrayOutputStream();

    @Before
    public void loadOutput() {
        System.setOut(new PrintStream(this.OUT));
    }

    @After
    public void backOutput() {
        System.setOut(this.STDOUT);
    }

    @Test
    public void drawSquare() {
        new Paint().draw(new Square());
        assertThat(this.OUT.toString(), is(new StringBuilder().append("####").append("####").append("####").append("####").append(System.lineSeparator()).toString()));
    }

    @Test
    public void drawTriangle() {
        new Paint().draw(new Triangle());
        assertThat(this.OUT.toString(), is(new StringBuilder().append("   #   ").append("  ###  ").append(" ##### ").append("#######").append(System.lineSeparator()).toString()));
    }
}