package ru.job4j.tracker;

import java.util.*;


/**
 * @author Andrey Savelov (udroguedozed@gmail.com)
 * @version 1.1
 * @since 2018
 *
 * Хранилище заявок
 */
public class Tracker {
    private Item[] items = new Item[100];
    private int index = 0;
    private static final Random RN = new Random();

    /**
     * Добавить новую заявку
     * @param item - заявка
     * @return - добавленная заявка
     */
    public Item add(Item item) {
        item.setId(this.generateId());
        this.items[this.index++] = item;
        return item;
    }

    /**
     * Заменить заявку по ID
     * @param id - ID
     * @param item - новая заявка
     */
    public boolean replace(String id, Item item) {
        boolean result = false;
        for (int i = 0; i < this.index; i++) {
            if (this.items[i].getId().equals(id)) {
                result = true;
                item.setId(this.items[i].getId());
                this.items[i] = item;
                break;
            }
        }
        return result;
    }

    /**
     * Удалить заявку по ID
     * @param id - ID
     */
    public boolean delete(String id) {
        boolean result = false;
        for (int i = 0; i < this.index; i++) {
            if (this.items[i].getId().equals(id)) {
                result = true;
                System.arraycopy(this.items, i + 1, this.items, i, this.index - i - 1);
                this.index--;
                break;
            }
        }
        return result;
    }

    /**
     * Найти все заявки
     * @return - все заявки
     */
    public Item[] findAll() {
        return this.index == 0 ? null : Arrays.copyOf(this.items, this.index);
    }

    /**
     * Найти заявку по ID
     * @param id - ID
     * @return - заявка
     */
    public Item findById(String id) {
        Item result = null;
        for (Item item : this.items) {
            if (item != null && item.getId().equals(id)) {
                result = item;
                break;
            }
        }
        return result;
    }

    /**
     * Найти все заявки с именем
     * @param name - имя
     * @return - список заявок
     */
    public Item[] findByName(String name) {
        Item[] tmp = new Item[this.index];
        int i = 0;
        for (Item item : this.items) {
            if (item != null && item.getName().equals(name)) {
                tmp[i++] = item;
            }
        }
        return Arrays.copyOf(tmp, i);
    }

    private String generateId() {
        return String.valueOf(System.currentTimeMillis() + RN.nextInt());
    }
}
