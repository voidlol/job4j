package ru.job4j.generics;

/**
 * @author - Andrey Savelov
 * @version - 1.0
 * @since - 21.12.2018
 */
public class UserStore extends AbstractStore<User> {

    public UserStore(int size) {
        super(size);
    }
}
