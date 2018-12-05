package ru.job4j.list;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ConvertList2ArrayTest {
    @Test
    public void when7ElementsThen9() {
        ConvertList2Array list = new ConvertList2Array();
        int[][] result = list.toArray(
                Arrays.asList(1, 2, 3, 4, 5, 6, 7),
                3
        );
        int[][] expect = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 0, 0}
        };
        assertThat(result, is(expect));
    }

    @Test
    public void convertTest() {
        ConvertList2Array cl2a = new ConvertList2Array();
        List<int[]> list = new ArrayList<>();
        list.add(new int[] {7, 3, 5, 6});
        list.add(new int[] {1, 8, 19, 4, 0, 9});
        List<Integer> expected = new ArrayList<>();
        expected.addAll(Arrays.asList(7, 3, 5, 6, 1, 8, 19, 4, 0, 9));
        assertThat(cl2a.convert(list), is(expected));
    }
}