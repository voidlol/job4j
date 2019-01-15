package ru.job4j.concurrency;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * @author - Andrey Savelov
 * @version - 1.0
 * @since - 15.01.2019
 */
public class CounterTest {
    /**
     * Класс описывает нить со счетчиком.
     */
    private class ThreadCount extends Thread {
        private final Counter counter;

        private ThreadCount(final Counter counter) {
            this.counter = counter;
        }

        @Override
        public void run() {
            this.counter.increment();
        }
    }

    @Test
    public void whenExecute2ThreadThen2() throws InterruptedException {
        //Создаем счетчик.
        final Counter counter = new Counter();
        //Создаем нити.
        Thread first = new ThreadCount(counter);
        Thread second = new ThreadCount(counter);
        //Запускаем нити.
        first.start();
        second.start();
        //Заставляем главную нить дождаться выполнения наших нитей.
        first.join();
        second.join();
        //Проверяем результат.
        assertThat(counter.getCount(), is(2L));

    }

}