package ru.job4j.tracker;

import java.util.Arrays;

public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public Item[] findAll() {
        return Arrays.copyOf(items, size);
    }

    public Item[] findByName(String key) {
        Item[] rsl = new Item[items.length];
        int rsl_size = 0;
        for (Item item : items) {
            if (item.getName().equals(key)) {
                rsl[rsl_size++] = item;
            }
        }
        return Arrays.copyOf(rsl, rsl_size);
    }

    public Item findById(int id) {
        /* Находим индекс */
        int index = indexOf(id);
        /* Если индекс найден возвращаем item, иначе null */
        return index != -1 ? items[index] : null;
    }

    private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < size; index++) {
            if (items[index].getId() == id) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }

    public boolean replace(int id, Item item) {
        if (findById(id) == null) {
            return false;
        }
        item.setId(id);             //Присваиваем номер новому обьекту
        items[indexOf(id)] = item;  //Вносим обьект в массив
        return true;
    }
}