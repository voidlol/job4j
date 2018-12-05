package ru.job4j.bank;

import java.util.Objects;

public class Account {

    private double value;
    private String requisites;

    public Account(double value, String requisites) {
        this.requisites = requisites;
        this.value = value;
    }

    public void addValue(double value) {
        this.value += value;
    }

    public boolean transfer(Account dest, double amount) {
        boolean result = false;
        if (amount > 0 && amount <= this.value && dest != null) {
            result = true;
            this.value -= amount;
            dest.addValue(amount);
        }
        return result;
    }

    public double getValue() {
        return this.value;
    }

    public String getRequisites() {
        return this.requisites;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Account account = (Account) o;
        return this.getRequisites().equals(account.getRequisites());
    }

    @Override
    public int hashCode() {
        return Objects.hash(requisites);
    }
}
