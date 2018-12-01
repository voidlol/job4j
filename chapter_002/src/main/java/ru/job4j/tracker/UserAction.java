package ru.job4j.tracker;

public interface UserAction {
    int key();
    String info();
    void execute(Input input, Tracker tracker);
}
