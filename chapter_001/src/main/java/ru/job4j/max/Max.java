package ru.job4j.max;

/**
 * @author Andrey Savelov (udroguedozed@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class Max {
    /**
     * Возвращает большее число
     * @param first - первое число
     * @param second - второе
     * @return - большее
     */
    public int max(int first, int second) {
        return first > second ? first : second;
    }
}
