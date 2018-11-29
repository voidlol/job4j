package ru.job4j.tracker;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleInput {
    private final static BufferedReader BR = new BufferedReader(new InputStreamReader(System.in));

    public String getString(String output) throws IOException {
        System.out.print(output);
        return BR.readLine();
    }
}
