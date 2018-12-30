package ru.job4j.trees;

import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * @author - Andrey Savelov
 * @version - 1.0
 * @since - 29.12.2018
 */
public class TreeTest {

    @Test
    public void when6ElFindLastThen6() {
        Tree<Integer> tree = new Tree<>(1);
        tree.add(1, 2);
        tree.add(1, 3);
        tree.add(1, 4);
        tree.add(4, 5);
        tree.add(5, 6);
        assertThat(tree.findBy(6).isPresent(), is(true));
        assertThat(tree.add(2, 4), is(false));
    }

    @Test
    public void when6ElFindNotExitThenOptionEmpty() {
        Tree<Integer> tree = new Tree<>(1);
        tree.add(1, 2);
        assertThat(
                tree.findBy(7).isPresent(),
                is(false)
        );
    }


    @Test
    public void whenIteratorHasNextThenTrue() {
        Tree<Integer> tree = new Tree<>(1);
        tree.add(1, 2);
        Iterator it = tree.iterator();
        assertThat(it.hasNext(), is(true));
    }

    @Test
    public void whenIteratorHasNotNextThenFalse() {
        Tree<Integer> tree = new Tree<>(1);
        tree.add(1, 2);
        Iterator it = tree.iterator();
        it.next();
        it.next();
        assertThat(it.hasNext(), is(false));
    }
}