package ru.job4j.array;

/**
 * @author Andrey Savelov (udroguedozed@gmail.com)
 * @version 1.0
 * @since 2018
 */
public class Square {
    /**
     * Заполянет массив квадратами чисел в диапазоне от 1 до bound
     * @param bound - конец диапазона
     * @return - массив
     */
    public int[] calculate(int bound) {
        int[] rst = new int[bound];
            for (int i = 0; i < bound; i++) {
                rst[i] = (int) Math.pow(i + 1, 2);
            }
        return rst;
    }
}
