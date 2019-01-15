package ru.job4j.concurrency;

/**
 * @author - Andrey Savelov
 * @version - 1.0
 * @since - 16.01.2019
 */
public class User {

    private int amount;
    private int id;

    public User(int id, int amount) {
        this.id = id;
        this.amount = amount;
    }

    public int getAmount() {
        return this.amount;
    }

    public int getId() {
        return this.id;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
