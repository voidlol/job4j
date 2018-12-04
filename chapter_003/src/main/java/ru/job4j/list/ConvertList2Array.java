package ru.job4j.list;

import java.util.List;

public class ConvertList2Array {
    public int[][] toArray(List<Integer> list, int rows) {
        int cells = list.size() % rows == 0 ? list.size() / rows : list.size() / rows + 1;
        int[][] array = new int[rows][cells];
        int r = 0, c = 0;
        for (Integer i : list) {
            array[r][c] = i;
            if (c == cells - 1) {
                c = 0;
                r++;
            } else {
                c++;
            }
        }
        return array;
    }
}