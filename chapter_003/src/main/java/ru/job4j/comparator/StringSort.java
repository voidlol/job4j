package ru.job4j.comparator;

import java.util.*;

public class StringSort {

    private List<Org> getDepartments(String[] value) {
        Set<Org> set = new HashSet<>();
        for (String s : value) {
            Org o = new Org(s);
            set.add(o);
            if (o.getDeps().size() > 1) {
                set.add(new Org(o.getDeps().subList(0, o.getDeps().size() - 1)));
            }
        }
        return new ArrayList<>(set);
    }

    private String[] convert(List<Org> departments) {
        String[] result = new String[departments.size()];
        int index = 0;
        for (Org o : departments) {
            result[index++] = o.toString();
        }
        return result;
    }

    public String[] sortUp(String[] value) {
        List<Org> departments = getDepartments(value);
        Comparator<Org> departmentCompar = Comparator.comparing(o -> o.getDeps().get(0));
        departments.sort(departmentCompar.thenComparing(o -> o.getDeps().get(o.getDeps().size() - 1)));
        return convert(departments);
    }

    public String[] sortDown(String[] value) {
        List<Org> departments = getDepartments(value);
        Comparator<Org> departmentCompar = (o1, o2) -> o2.getDeps().get(0).compareTo(o1.getDeps().get(0));
        departments.sort(departmentCompar.thenComparingInt(o -> o.getDeps().size()).thenComparing((o1, o2) -> o2.getDeps().get(o2.getDeps().size() - 1).compareTo(o1.getDeps().get(o1.getDeps().size() - 1))));
        return convert(departments);
    }
}
