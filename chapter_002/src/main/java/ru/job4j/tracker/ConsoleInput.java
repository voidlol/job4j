package ru.job4j.tracker;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleInput implements Input {
    private final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    @Override
    public String getString(String output) throws IOException {
        System.out.print(output);
        return br.readLine();
    }
}
