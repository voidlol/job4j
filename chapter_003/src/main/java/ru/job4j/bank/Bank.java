package ru.job4j.bank;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Bank {

    private Map<User, List<Account>> db = new TreeMap<>();

    private User findByPassport(String passport) {
        return db.keySet().stream().filter(user -> passport.equals(user.getPassport())).findAny().orElse(null);
    }

    private Account findByRequisites(User user, String requisites) {
        return db.get(user).stream().filter(account -> requisites.equals(account.getRequisites())).findAny().orElse(null);
    }

    public void addUser(User user) {
        db.putIfAbsent(user, new ArrayList<>());
    }

    public void deleteUser(User user) {
        db.remove(user);
    }

    public void addAccountToUser(String passport, Account account) {
        if (db.get(findByPassport(passport)).indexOf(account) == -1) {
            db.get(findByPassport(passport)).add(account);
        }
    }

    public void deleteAccountFromUser(String passport, Account account) {
        if (db.get(findByPassport(passport)).indexOf(account) != -1) {
            db.get(findByPassport(passport)).remove(account);
        }
    }

    public List<Account> getUserAccounts(String passport) {
        return db.get(findByPassport(passport));
    }

    public boolean transferMoney(String srcPassport, String srcRequisite, String destPassport, String dstRequisite, double amount) {
        Account source = findByRequisites(findByPassport(srcPassport), srcRequisite);
        Account dest = findByRequisites(findByPassport(destPassport), dstRequisite);
        return source != null && source.transfer(dest, amount);
    }
}
