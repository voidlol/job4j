package ru.job4j.stream;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Student implements Comparator<Student> {
    private String name;
    private int scope;

    public Student(String name, int scope) {
        this.name = name;
        this.scope = scope;
    }

    public String getName() {
        return this.name;
    }

    public int getScope() {
        return this.scope;
    }

    public List<Student> levelOf(List<Student> students, int bound) {
        return students.stream().sorted(this::compare).flatMap(Stream::ofNullable).takeWhile(s -> s.getScope() > bound).collect(Collectors.toList());
    }

    @Override
    public int compare(Student o1, Student o2) {
        return o2 == null || o1 == null ? 1 : o2.getScope() - o1.getScope();
    }

}
