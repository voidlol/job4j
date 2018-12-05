package ru.job4j.bank;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class BankTest {
    Bank bank = new Bank();

    @Test
    public void whenAddAccountToUser() {
        this.bank.addUser(new User("Andrey", "123"));
        this.bank.addAccountToUser("123", new Account(5, "1"));
        assertThat(this.bank.getUserAccounts("123").get(0), is(new Account(5, "1")));
    }

    @Test
    public void whenRemoveAccountFromUser() {
        this.bank.addUser(new User("Andrey", "123"));
        this.bank.addAccountToUser("123", new Account(5, "1"));
        this.bank.addAccountToUser("123", new Account(10, "2"));
        this.bank.deleteAccountFromUser("123", new Account(5, "1"));
        assertThat(this.bank.getUserAccounts("123").size(), is(1));
    }

    @Test
    public void whenTransferFromOneUserToSecondThenTrue() {
        this.bank.addUser(new User("Andrey", "123"));
        this.bank.addUser(new User("Alexey", "456"));
        this.bank.addAccountToUser("123", new Account(35, "1"));
        this.bank.addAccountToUser("456", new Account(10, "2"));
        boolean result = bank.transferMoney("123", "1", "456", "2", 10);
        assertThat(result, is(true));
    }
}