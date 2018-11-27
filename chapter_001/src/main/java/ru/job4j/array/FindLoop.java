package ru.job4j.array;

/**
 * @author Andrey Savelov (udroguedozed@gmail.com)
 * @version 1.0
 * @since 2018
 */

public class FindLoop {
    /**
     * Ищет индекс элемента в массиве
     * @param data - массив
     * @param el - элемент
     * @return - индекс или -1 если элемента нет
     */
    public int indexOf(int[] data, int el) {
        int rst = -1;
        for (int index = 0; index < data.length; index++) {
            if (data[index] == el) {
                rst = index;
                break;
            }
        }
        return rst;
    }
}
