package util;

import java.util.UUID;

public class IdGenerator {
    public static String generateId() {
        return UUID.randomUUID().toString().substring(0, 6);
    }

    public static String formatId(String id) {
        if (id == null || id.length() < 4) return id;
        return id.substring(0, 3) + " " + id.substring(3);
    }
}