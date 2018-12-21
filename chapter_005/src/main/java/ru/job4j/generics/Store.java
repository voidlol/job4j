package ru.job4j.generics;

/**
 * @author - Andrey Savelov
 * @version - 1.0
 * @since - 21.12.2018
 */
public interface Store<T extends Base> {
    void add(T model);

    boolean replace(String id, T model);

    boolean delete(String id);

    T findById(String id);
}
