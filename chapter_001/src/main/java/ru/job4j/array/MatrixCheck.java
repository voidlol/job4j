package ru.job4j.array;

/**
 * @author Andrey Savelov (udroguedozed@gmail.com)
 * @version 1.1
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
            if ((data[row][row] != data[row + 1][row + 1]) ||
                    (data[data.length - row - 1][data.length - row - 1] != data[data.length - row - 2][data.length - row - 2])) {
                result = false;
                break;
            }
        }
        return result;
    }
}
