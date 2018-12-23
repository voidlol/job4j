package ru.job4j.lists;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * @author - Andrey Savelov
 * @version - 1.0
 * @since - 23.12.2018
 */
public class NodeTest {
    private Node<Integer> node1 = new Node<>(5);
    private Node<Integer> node2 = new Node<>(10);
    private Node<Integer> node3 = new Node<>(15);
    private Node<Integer> node4 = new Node<>(20);

    @Test
    public void whenFourthNodeLinksToFirstThenHasCycleIsTrue() {
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node1;

        assertThat(Node.hasCycle(node1), is(true));
    }

    @Test
    public void whenThirdNodeLinksToSecondThenHasCycleIsTrue() {
        node1.next = node2;
        node2.next = node3;
        node3.next = node2;
        node4.next = node1;

        assertThat(Node.hasCycle(node1), is(true));
    }

    @Test
    public void whenNoLoopThenHasCycleIsFalse() {
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        assertThat(Node.hasCycle(node1), is(false));
    }
}