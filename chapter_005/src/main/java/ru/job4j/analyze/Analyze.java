package ru.job4j.analyze;

import java.util.*;

/**
 * @author - Andrey Savelov
 * @version - 1.0
 * @since - 31.12.2018
 */
public class Analyze {

    private Map<Integer, String> analizator = new HashMap<>();

    public Info diff(List<User> previous, List<User> current) {
        Info rst = new Info();
        for (User u : previous) {
            analizator.put(u.id, u.name);
        }

        for (User u : current) {
            if (!analizator.containsKey(u.id)) {
                rst.added++;
            } else if (!analizator.get(u.id).equals(u.name)) {
                rst.changed++;
            }
        }
        rst.deleted = rst.added - current.size() + previous.size();
        return rst;

    }

    public static class User {
        int id;
        String name;

        public User(int id, String name) {
            this.id = id;
            this.name = name;
        }
    }

    public static class Info {
        int added = 0;
        int changed = 0;
        int deleted = 0;
    }
}
