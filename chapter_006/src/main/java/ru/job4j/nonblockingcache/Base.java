package ru.job4j.nonblockingcache;

public class Base {
    private final int id;
    private int version;

    public Base(int id, int version) {
        this.version = version;
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

    public int getVersion() {
        return this.version;
    }

    public void incrementVersion() {
        this.version++;
    }
}
