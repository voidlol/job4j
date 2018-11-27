package ru.job4j.array;

/**
 * @author Andrey Savelov (udroguedozed@gmail.com)
 * @version 1.0
 * @since 2018
 */

public class Turn {
    /**
     * Переворачивает массив
     * @param array - массив
     * @return - перевернутый массив
     */
    public int[] back(int[] array) {
        int length = array.length - 1;
        int tmp;
        for (int index = 0; index < (length + 1) / 2; index++) {
            tmp = array[index];
            array[index] = array[length - index];
            array[length - index] = tmp;
        }
        return array;
    }
}
