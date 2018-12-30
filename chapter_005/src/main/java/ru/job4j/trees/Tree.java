package ru.job4j.trees;

import java.util.*;

/**
 * @author - Andrey Savelov
 * @version - 1.0
 * @since - 29.12.2018
 */
public class Tree<T extends Comparable<T>> implements SimpleTree<T> {

    private Node<T> root;

    public Tree(T value) {
        this.root = new Node<>(value);
    }

    @Override
    public boolean add(T parent, T child) {
        boolean rst = false;
        Optional<Node<T>> opt = findBy(child);
        if (opt.isEmpty()) {
            findBy(parent).ifPresent(p -> p.add(new Node<>(child)));
            rst = true;
        }
        return rst;
    }

    @Override
    public Optional<Node<T>> findBy(T value) {
        Optional<Node<T>> rsl = Optional.empty();
        Queue<Node<T>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<T> el = data.poll();
            if (el.eqValue(value)) {
                rsl = Optional.of(el);
                break;
            }
            for (Node<T> child : el.leaves()) {
                data.offer(child);
            }
        }
        return rsl;
    }

    @Override
    public Iterator<T> iterator() {
        return new TreeIterator(this).values.iterator();
    }

    public class TreeIterator {

        List<T> values = new ArrayList<>();

        public TreeIterator(Tree<T> t) {
            makeList(t.root.leaves());
            values.add(t.root.getValue());
        }

        private void makeList(List<Node<T>> nodes) {
            if (nodes.isEmpty()) {
                return;
            }
            for (Node<T> node : nodes) {
                makeList(node.leaves());
                values.add(node.getValue());
            }
        }

        public List<T> getList() {
            return values;
        }
    }
}
