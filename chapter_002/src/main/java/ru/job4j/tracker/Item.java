package ru.job4j.tracker;

/**
 * @author Andrey Savelov (udroguedozed@gmail.com)
 * @version 1.0
 * @since 2018
 *
 * Класс заявки
 */
public class Item {
    private String name;
    private String id;
    private String description;
    private long created;

    /**
     * Конструктор заявки
     * @param name - имя
     * @param description - описание
     */
    public Item(String name, String description) {
        this.name = name;
        this.description = description;
        this.setCreated();
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return this.id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return this.description;
    }

    private void setCreated() {
        this.created = System.currentTimeMillis();
    }

    public long getCreated() {
        return this.created;
    }

    @Override
    public String toString() {
        return String.format("%s%s%s%s", "Заявка: ", this.getName(), System.lineSeparator(), this.getDescription());
    }
}
