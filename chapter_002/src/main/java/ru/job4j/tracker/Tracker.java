package ru.job4j.tracker;

import java.util.*;


/**
 * @author Andrey Savelov (udroguedozed@gmail.com)
 * @version 1.2
 * @since 2018
 *
 * Хранилище заявок
 */
public class Tracker {
    private List<Item> items = new ArrayList<>();
    private static final Random RN = new Random();

    /**
     * Добавить новую заявку
     * @param item - заявка
     * @return - добавленная заявка
     */
    public Item add(Item item) {
        item.setId(this.generateId());
        this.items.add(item);
        return item;
    }

    /**
     * Заменить заявку по ID
     * @param id - ID
     * @param item - новая заявка
     */
    public boolean replace(String id, Item item) {
        boolean result = false;
        for (int i = 0; i < this.items.size(); i++) {
            if (this.items.get(i).getId().equals(id)) {
                result = true;
                item.setId(this.items.get(i).getId());
                this.items.set(i, item);
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
        for (int i = 0; i < this.items.size(); i++) {
            if (this.items.get(i).getId().equals(id)) {
                result = true;
                this.items.remove(i);
                break;
            }
        }
        return result;
    }

    /**
     * Найти все заявки
     * @return - все заявки
     */
    public List<Item> findAll() {
        return this.items.isEmpty() ? null : this.items;
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
    public List<Item> findByName(String name) {
        List<Item> result = new ArrayList<>();
        for (Item item : this.items) {
            if (item != null && item.getName().equals(name)) {
                result.add(item);
            }
        }
        return result;
    }

    private String generateId() {
        return String.valueOf(System.currentTimeMillis() + RN.nextInt());
    }
}
