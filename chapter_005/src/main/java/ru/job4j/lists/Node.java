package ru.job4j.lists;

import java.util.HashSet;
import java.util.Set;

/**
 * @author - Andrey Savelov
 * @version - 1.0
 * @since - 23.12.2018
 */
public class Node<T> {
    T value;
    Node<T> next;

    public Node(T value) {
        this.value = value;
        this.next = null;
    }

    public static boolean hasCycle(Node first) {
        Set<Node> set = new HashSet<>();
        boolean rst = false;
        while (first != null) {
            if (set.contains(first)) {
                rst = true;
                break;
            }
            set.add(first);
            first = first.next;
        }

        return rst;
    }
}
