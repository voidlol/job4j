package ru.job4j.generics;

/**
 * @author - Andrey Savelov
 * @version - 1.0
 * @since - 21.12.2018
 */
public abstract class Base {
    private final String id;

    protected Base(final String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
