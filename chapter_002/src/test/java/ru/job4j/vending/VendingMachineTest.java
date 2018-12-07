package ru.job4j.vending;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class VendingMachineTest {

    @Test
    public void change() {
        VendingMachine vm = new VendingMachine();
        int[] expected = new int[] {1};
        assertThat(vm.change(100, 99), is(expected));
    }
}