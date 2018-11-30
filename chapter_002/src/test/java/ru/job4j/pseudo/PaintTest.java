package ru.job4j.pseudo;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class PaintTest {

    @Test
    public void drawSquare() {
        PrintStream stdout = System.out;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        new Paint().draw(new Square());
        assertThat(out.toString(), is(new StringBuilder().append("####").append("####").append("####").append("####").append(System.lineSeparator()).toString()));
    }

    @Test
    public void drawTriangle() {
        PrintStream stdout = System.out;
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
        new Paint().draw(new Triangle());
        assertThat(out.toString(), is(new StringBuilder().append("   #   ").append("  ###  ").append(" ##### ").append("#######").append(System.lineSeparator()).toString()));
    }
}