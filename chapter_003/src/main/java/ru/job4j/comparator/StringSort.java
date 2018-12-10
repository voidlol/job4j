package ru.job4j.comparator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StringSort {

    private List<String[]> getDepartments(String[] value) {
        List<String> list = new ArrayList<>(Arrays.asList(value));
        addDepartments(list);
        return list.stream().map(s -> s.split("\\\\")).collect(Collectors.toList());
    }

    private void addDepartments(List<String> list) {
        for (int i = 0; i < list.size(); i++) {
            int index = list.get(i).lastIndexOf('\\');
            if (index != -1 && !list.contains(list.get(i).substring(0, index))) {
                list.add(list.get(i).substring(0, index));
            }
        }
    }

    private String[] convert(List<String[]> departments) {
        String[] result = new String[departments.size()];
        StringBuilder tmp;
        int index = 0;
        for (String[] strings : departments) {
            tmp = new StringBuilder();
            for (int i = 0; i < strings.length; i++) {
                if (i > 0) {
                    tmp.append("\\").append(strings[i]);
                } else {
                    tmp.append(strings[i]);
                }
            }
            result[index++] = tmp.toString();
        }
        return result;
    }

    public String[] sortUp(String[] value) {
        List<String[]> departments = getDepartments(value);
        Comparator<String[]> departmentCompar = Comparator.comparing(o -> o[0]);
        departments.sort(departmentCompar.thenComparingInt(o -> o.length));
        return convert(departments);
    }

    public String[] sortDown(String[] value) {
        List<String[]> departments = getDepartments(value);
        Comparator<String[]> departmentCompar = (o1, o2) -> o2[0].compareTo(o1[0]);
        departments.sort(departmentCompar.thenComparingInt(o -> o.length).thenComparing((o1, o2) -> o2[o2.length - 1].compareTo(o1[o1.length - 1])));
        return convert(departments);
    }
}
