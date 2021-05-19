package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class LogFilter {
    public static List<String> filter(String file) {
        List<String> result = new ArrayList<>();
        try (BufferedReader in = new BufferedReader(new FileReader(file))) {
            in.lines().forEach((line) -> {
                String[] temp = line.split(" ");
                if (temp[temp.length - 2].equals("404")) {
                    result.add(line);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
    public static void main(String[] args) {
        List<String> log = filter("log.txt");
        System.out.println(log);
    }
}
