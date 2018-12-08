package ru.job4j.comparator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class StringSort {

    private void addDepartments(List<String> list) {
        for (int i = 0; i < list.size(); i++) {
            int index = list.get(i).lastIndexOf('\\');
            if (index != -1 && !list.contains(list.get(i).substring(0, index))) {
                list.add(list.get(i).substring(0, index));
            }
        }
    }

    public String[] sortUp(String[] value) {
        List<String> list = new ArrayList<>(Arrays.asList(value));
        addDepartments(list);
        Comparator<String> departmentCompar = (o1, o2) -> {
            int index1 = o1.indexOf('\\') != -1 ? o1.indexOf('\\') : o1.length();
            int index2 = o2.indexOf('\\') != -1 ? o2.indexOf('\\') : o2.length();
            return o1.substring(0, index1).compareTo(o2.substring(0, index2));
        };
        list.sort(departmentCompar.thenComparing((o1, o2) -> o1.length() - o2.length()));
        return list.toArray(new String[list.size()]);
    }

    public String[] sortDown(String[] value) {
        List<String> list = new ArrayList<>(Arrays.asList(value));
        addDepartments(list);
        Comparator<String> departmentCompar = (o1, o2) -> {
            int index1 = o1.indexOf('\\') != -1 ? o1.indexOf('\\') : o1.length();
            int index2 = o2.indexOf('\\') != -1 ? o2.indexOf('\\') : o2.length();
            return o2.substring(0, index2).compareTo(o1.substring(0, index1));
        };
        list.sort(departmentCompar.thenComparing((o1, o2) -> o1.length() - o2.length()).thenComparing((o1, o2) -> o2.compareTo(o1)));
        return list.toArray(new String[list.size()]);
    }
}
