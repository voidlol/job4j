package ru.job4j.analyze;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * @author - Andrey Savelov
 * @version - 1.0
 * @since - 31.12.2018
 */
public class AnalyzeTest {
    private Analyze a = new Analyze();
    private Analyze.User u1 = new Analyze.User(1, "1");
    private Analyze.User u2 = new Analyze.User(2, "2");
    private Analyze.User u3 = new Analyze.User(3, "3");
    private Analyze.User u4 = new Analyze.User(4, "4");
    private Analyze.User u5 = new Analyze.User(5, "5");

    @Test
    public void whenZeroChangedOneAddedOneDeletedThenInfoHasZeroOneOne() {
        List<Analyze.User> prev = new ArrayList<>(List.of(u1, u2, u3, u4));
        List<Analyze.User> curr = new ArrayList<>(List.of(u1, u2, u3, u5));
        Analyze.Info rst = a.diff(prev, curr);
        assertThat(rst.added, is(1));
        assertThat(rst.deleted, is(1));
        assertThat(rst.changed, is(0));
    }

    @Test
    public void whenTwoChangedZeroAddedOneDeletedThenInfoHasTwoZeroOne() {
        List<Analyze.User> prev = new ArrayList<>(List.of(u1, u2, u3, u4));
        Analyze.User nu3 = new Analyze.User(3, "asd");
        Analyze.User nu4 = new Analyze.User(4, "asasd");
        List<Analyze.User> curr = new ArrayList<>(List.of(u1, nu3, nu4));
        Analyze.Info rst = a.diff(prev, curr);
        assertThat(rst.added, is(0));
        assertThat(rst.deleted, is(1));
        assertThat(rst.changed, is(2));
    }
}