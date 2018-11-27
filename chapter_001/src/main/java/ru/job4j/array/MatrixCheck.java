package ru.job4j.array;

/**
 * @author Andrey Savelov (udroguedozed@gmail.com)
 * @version 1.0
 * @since 2018
 */

public class MatrixCheck {

    /**
     * Проверка диагоналей на идентичность
     * @param data - массив
     * @return - true или false
     */
    public boolean mono(boolean[][] data) {
        boolean result = true;
        for (int row = 0; row < data.length - 1; row++) {
            if (data[row][row] != data[row + 1][row + 1]) {
                result = false;
            }
        }
        for (int row = data.length - 1; row > 0; row--) {
            if (data[row][row] != data[row - 1][row - 1]) {
                result = false;
            }
        }
        return result;
    }
}
