package ru.job4j.loop;

/**
 * @author Andrey Savelov
 * @version $Id$
 * @since 0.1
 */
public class Counter {

    /**
     * Считаем сумму четных чисел в диапазоне
     * @param start - начало диапазона
     * @param finish - конец диапазона
     * @return - сумма
     */
    public int add(int start, int finish) {
        int result = 0;
        if (start % 2 == 1) {
            start++;
        }
        for (int i = start; i <= finish; i += 2) {
            result += i;
        }
        return result;
    }
}
