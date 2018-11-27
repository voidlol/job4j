package ru.job4j.array;

import java.util.Arrays;

/**
 * @author Andrey Savelov (udroguedozed@gmail.com)
 * @version 1.0
 * @since 2018
 */

public class ArrayDuplicate {
    public String[] remove(String[] array) {
        int endIndex = array.length - 1;
        int loopSize = array.length;
        String tmp;
        for (int index = 0; index < loopSize; index++) {
            for (int j = index + 1; j < loopSize; j++) {
                if (array[index].equals(array[j])) {
                    loopSize--;
                    tmp = array[j];
                    array[j] = array[endIndex];
                    array[endIndex] = tmp;
                    endIndex--;
                }
            }
        }

        array = Arrays.copyOf(array, loopSize);
        return array;
    }

}
