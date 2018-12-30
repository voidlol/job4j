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

    public boolean isBinary() {
        boolean rst = true;
        Iterator<T> it = this.iterator();
        while (it.hasNext()) {
            if (findBy(it.next()).get().leaves().size() > 2) {
                rst = false;
                break;
            }
        }
        return rst;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {

            private Queue<Node<T>> treeNodes = null;

            @Override
            public boolean hasNext() {
                if (treeNodes == null) {
                    treeNodes = new LinkedList<>();
                    treeNodes.offer(root);
                }
                return !treeNodes.isEmpty();
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                Node<T> element = treeNodes.poll();
                if (!element.leaves().isEmpty()) {
                    for (Node<T> node : element.leaves()) {
                        treeNodes.offer(node);
                    }
                }
                return element.getValue();
            }
        };
    }

}
