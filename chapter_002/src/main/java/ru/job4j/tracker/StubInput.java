package ru.job4j.tracker;

public class StubInput extends ConsoleInput {
    private final String[] answers;
    private int index = 0;

    public StubInput(String[] answers) {
        this.answers = answers;
    }

    @Override
    public String getString(String output) {
        return this.answers[index++];
    }
}
