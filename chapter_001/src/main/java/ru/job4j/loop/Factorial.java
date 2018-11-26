package ru.job4j.loop;

/**
 * @author Andrey Savelov
 * @version $Id$
 * @since 0.1
 */
public class Factorial {
    /**
     * Считаем факториал числа
     * @param value - число
     * @return - факториал
     */
    public int calc(int value) {
        int result = 1;
        for (int i = 1; i <= value; i++) {
            result *= i;
        }
        return result;
    }
}
