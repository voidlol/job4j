package ru.job4j.comparator;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Org {
    private List<String> deps;

    public Org(String deps) {
        this.deps = Arrays.asList(deps.split("\\\\"));
    }

    public Org(List<String> deps) {
        this.deps = deps;
    }

    public List<String> getDeps() {
        return deps;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.deps.size(); i++) {
            if (i > 0) {
                sb.append("\\").append(this.deps.get(i));
            } else {
                sb.append(this.deps.get(i));
            }
        }
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Org)) return false;
        Org org = (Org) o;
        return Objects.equals(getDeps(), org.getDeps());
    }

    @Override
    public int hashCode() {
        int rst = 0;
        for (String s : this.deps) {
            rst += s.hashCode();
        }
        return rst;
    }
}
