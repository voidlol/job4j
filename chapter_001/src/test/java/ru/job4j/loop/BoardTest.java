package ru.job4j.loop;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class BoardTest {
    @Test
    public void board3x3() {
        Board board = new Board();
        String ln = System.lineSeparator();
        assertThat(board.paint(3, 3), is(String.format("X X%s X %sX X%s", ln, ln, ln)));
    }

    @Test
    public void board5x5() {
        Board board = new Board();
        String ln = System.lineSeparator();
        assertThat(board.paint(5, 5), is(String.format("X X X%s X X %sX X X%s X X %sX X X%s", ln, ln, ln, ln, ln)));
    }
}
