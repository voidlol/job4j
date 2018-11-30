package ru.job4j.tracker;

import java.io.IOException;

public interface UserAction {
    int key();
    String info();
    void execute(Input input, Tracker tracker) throws IOException;
}
