package ru.job4j.array;

/**
 * @author Andrey Savelov (udroguedozed@gmail.com)
 * @version 1.0
 * @since 2018
 */

public class Check {

    /**
     * Проверяет массив на заполнение однотипными элементами
     * @param data - массив
     * @return - true или false
     */
    public boolean mono(boolean[] data) {
        boolean result = true;
        for (int index = 0; index < data.length - 1; index++) {
            if (data[index] != data[index + 1]) {
                result = false;
            }
        }
        return result;
    }
}
