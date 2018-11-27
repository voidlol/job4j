package ru.job4j.array;

/**
 * @author Andrey Savelov (udroguedozed@gmail.com)
 * @version 1.0
 * @since 2018
 */

public class BubbleSort {
    /**
     * Сортиторвка пузырьковым методом
     * @param array - массив
     * @return - отсортированный масив
     */
    public int[] sort(int[] array) {
        int tmp, k, less;
        for (int index = 0; index < array.length - 1; index++) {
            less = array[index];
            k = index;
            for (int j = index + 1; j < array.length; j++) {
                if (array[j] < less) {
                    less = array[j];
                    k = j;
                }
            }
            if (k != index) {
               tmp = array[index];
               array[index] = less;
               array[k] = tmp;
            }
        }
        return array;
    }
}
