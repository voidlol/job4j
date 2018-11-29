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
    private final static Random RN = new Random();

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
        for (int index = 0; index < this.index; index++) {
            if (this.items[index].getId().equals(id)) {
                result = true;
                this.items[index] = item;
                item.setId(this.generateId());
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
        Item[] tmp = new Item[100];
        for (int index = 0; index < this.index; index++) {
            if (this.items[index].getId().equals(id)) {
                result = true;
                System.arraycopy(this.items, 0, tmp, 0, index);
                System.arraycopy(this.items, index + 1, tmp, index, this.index - 1 - index);
                this.items = tmp;
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
            if (item.getId().equals(id)) {
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
        int index = 0;
        for (Item item : this.items) {
            if (item != null && item.getName().equals(name)) {
                tmp[index++] = item;
            }
        }
        return Arrays.copyOf(tmp, index);
    }

    private String generateId() {
        return String.valueOf(System.currentTimeMillis() + RN.nextInt());
    }
}
