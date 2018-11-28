package ru.job4j.condition;
/**
 * @author Andrey Savelov (udroguedozed@gmail.com)
 * @version $Id$
 * @since 0.1
 */
public class DummyBot {
    /**
     * Бот, который отвечает на 3 вопроса
     */
    public String answer(String question) {
        String result = "Не знаю ответ на этот вопрос";
        if ("Привет, Бот.".equals(question)) {
            result = "Привет, умник.";
        } else if ("Пока.".equals(question)) {
            result = "До скорой встречи.";
        }
        return result;
    }
}
