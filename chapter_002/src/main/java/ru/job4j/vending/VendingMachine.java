package ru.job4j.vending;

import java.util.ArrayList;
import java.util.List;

public class VendingMachine {
    private static final int[] COINS = new int[] {1, 2, 5, 10};

    public int[] change(int value, int price) {
        int change = value - price;
        int tmp = 0;
        List<Integer> list = new ArrayList<>();
        int index = COINS.length - 1;
        while (change >= 2) {
            if (change >= COINS[index]) {
                tmp = change / COINS[index];
                for (int i = 0; i < tmp; i++) {
                    list.add(COINS[index]);
                }
                change -= (change / COINS[index]) * COINS[index];
            }
            index--;
        }
        if (change > 0) {
            list.add(change);
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

}
