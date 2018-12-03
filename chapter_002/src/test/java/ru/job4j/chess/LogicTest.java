package ru.job4j.chess;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import ru.job4j.chess.firuges.Cell;
import ru.job4j.chess.firuges.white.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class LogicTest {
    private final Logic logic = new Logic();
    private final PrintStream stdout = System.out;
    private final ByteArrayOutputStream out = new ByteArrayOutputStream();
    private final String wrongWay = "Так ходить нельзя!" + System.lineSeparator();

    @Before
    public void init() {
        this.logic.add(new RookWhite(Cell.A1));
        this.logic.add(new PawnWhite(Cell.A4));
        this.logic.add(new BishopWhite(Cell.B4));
        this.logic.add(new KnightWhite(Cell.C4));
        this.logic.add(new QueenWhite(Cell.D4));
        this.logic.add(new KingWhite(Cell.E4));
        System.setOut(new PrintStream(this.out));
    }

    @After
    public void backOutput() {
        System.setOut(this.stdout);
    }

    @Test
    public void whenFigureNotFoundThenNotFoundError() {
        assertThat(logic.validateMove(Cell.D8, Cell.A5), is(false));
        assertThat(this.out.toString(), is("Здесь нет фигуры!" + System.lineSeparator()));
    }

    @Test
    public void whenFigureWayOccupiedThenOccupiedError() {
        assertThat(logic.validateMove(Cell.A1, Cell.A5), is(false));
        assertThat(this.out.toString(), is("Путь занят." + System.lineSeparator()));
    }

    @Test
    public void whenFigureWayFreeThenNoError() {
        assertThat(logic.validateMove(Cell.A1, Cell.A3), is(true));
    }

    @Test
    public void whenRookWrongWayThenWrongWayError() {
        assertThat(logic.validateMove(Cell.A1, Cell.C3), is(false));
        assertThat(this.out.toString(), is(wrongWay));
    }

    @Test
    public void whenRookRightWayThenNoError() {
        assertThat(logic.validateMove(Cell.A1, Cell.A3), is(true));
    }

    @Test
    public void whenPawnWrongWayThenWrongWayError() {
        assertThat(logic.validateMove(Cell.A4, Cell.C3), is(false));
        assertThat(this.out.toString(), is(wrongWay));
    }

    @Test
    public void whenPawnRightWayThenNoError() {
        assertThat(logic.validateMove(Cell.A4, Cell.A5), is(true));
    }

    @Test
    public void whenBishopWrongWayThenWrongWayError() {
        assertThat(logic.validateMove(Cell.B4, Cell.B5), is(false));
        assertThat(this.out.toString(), is(wrongWay));
    }

    @Test
    public void whenBishopRightWayThenNoError() {
        assertThat(logic.validateMove(Cell.B4, Cell.A3), is(true));
    }

    @Test
    public void whenKnightWrongWayThenWrongWayError() {
        assertThat(logic.validateMove(Cell.C4, Cell.C3), is(false));
        assertThat(this.out.toString(), is(wrongWay));
    }

    @Test
    public void whenKnightRightWayThenNoError() {
        assertThat(logic.validateMove(Cell.C4, Cell.E5), is(true));
    }

    @Test
    public void whenKingWrongWayThenWrongWayError() {
        assertThat(logic.validateMove(Cell.E4, Cell.C3), is(false));
        assertThat(this.out.toString(), is(wrongWay));
    }

    @Test
    public void whenKingRightWayThenNoError() {
        assertThat(logic.validateMove(Cell.E4, Cell.E5), is(true));
    }

    @Test
    public void whenQueenWrongWayThenWrongWayError() {
        assertThat(logic.validateMove(Cell.D4, Cell.B7), is(false));
        assertThat(this.out.toString(), is(wrongWay));
    }

    @Test
    public void whenQueenRightWayThenNoError() {
        assertThat(logic.validateMove(Cell.D4, Cell.D1), is(true));
    }
}