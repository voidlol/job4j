package ru.job4j.io;

import java.io.FileOutputStream;

public class ResultFile {
    public static void main(String[] args) {

        int[][] table = new int[10][10];

        try (FileOutputStream out = new FileOutputStream("result.txt")) {
            for (int row = 0; row < 10; row++) {
                if (row > 0) {
                    out.write(System.lineSeparator().getBytes());
                }
                for (int column = 0; column < 10; column++) {
                    table[row][column] = (row + 1) * (column + 1);
                    out.write(Integer.toString(table[row][column]).getBytes());
                    out.write(" ".getBytes());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
