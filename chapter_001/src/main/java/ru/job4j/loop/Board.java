package ru.job4j.loop;

public class Board {
    /**
     * Рисуем доску по условию:
     * Если сумма координат является четным числом - рисуем X, в противном случае - ничего.
     *
     * @param wight - ширина доски
     * @param height - высота доски
     * @return - доска
     */
    public String paint(int wight, int height) {
        StringBuilder result = new StringBuilder();
        String ln = System.lineSeparator();

        for (int i = 0; i < wight; i++) {
            for (int j = 0; j < height; j++) {
                if ((i + j) % 2 == 0) {
                    result.append("X");
                } else {
                    result.append(" ");
                }
            }
            result.append(ln);
        }

        return result.toString();
    }
}
