package ru.job4j.io;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

public class ConfigTest {
    @Test
    public void whenPairWithoutComment() {
        String path = "./data/app.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("name"), is("Petr Arsentev"));
    }

    @Test
    public void whenOnlyComment() {
        String path = "./data/appComment.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("name"), is(nullValue()));
    }

    @Test (expected = IllegalArgumentException.class)
    public void whenNoValue() {
        String path = "./data/appNoValue.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("myKey"), is(nullValue()));
    }

    @Test
    public void whenThereEmptyLine() {
        String path = "./data/appWithEmptyLine.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value(System.lineSeparator()), is(nullValue()));
    }
}