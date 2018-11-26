package ru.job4j.condition;


import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class DummyBotTest {
    @Test
    public void answerHelloTest() {
        DummyBot bot = new DummyBot();
        assertThat(bot.answer("Привет, Бот."), is("Привет, умник."));
    }

    @Test
    public void answerByeTest() {
        DummyBot bot = new DummyBot();
        assertThat(bot.answer("Пока."), is("До скорой встречи."));
    }

    @Test
    public void answerOtherTest() {
        DummyBot bot = new DummyBot();
        assertThat(bot.answer("Как дела?"), is("Не знаю ответ на этот вопрос"));
    }
}
