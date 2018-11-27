package ru.job4j.array;

/**
 * @author Andrey Savelov (udroguedozed@gmail.com)
 * @version 1.0
 * @since 2018
 */

public class Matrix {
    /**
     * Создает таблицу умножения
     * @param size - размер
     * @return - таблица
     */
    public int[][] multiple(int size) {
        int[][] table = new int[size][size];
        for (int row = 0; row < size; row++) {
            for (int column = 0; column < size; column++) {
                table[row][column] = (row + 1) * (column + 1);
            }
        }
        return table;
    }
}
