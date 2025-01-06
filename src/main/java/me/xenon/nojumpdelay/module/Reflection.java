package me.xenon.nojumpdelay.module;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class Reflection {

    private static List<HashedField> fields = new ArrayList<HashedField>();

    public static Field getField(Class<?> target, String... names) {
        for (String s : names) {
            HashedField hashedField = findField(target, s);
            if (hashedField != null)
                return hashedField.getField();
            else {
                for (Field f : target.getDeclaredFields()) {
                    f.setAccessible(true);
                    if (f.getName().equals(s)) {
                        fields.add(new HashedField(target, f, s));
                        return f;
                    }
                }
            }
        }
        return null;
    }

    private static HashedField findField(Class<?> declared, String name) {
        for (HashedField hashedField : fields) {
            if (hashedField != null) {
                int hash = 0;
                for (char c : name.toCharArray()) {
                    hash += c ^ 16;
                }
                for (char c : declared.getName().toCharArray()) {
                    hash += c ^ 16;
                }
                if (hashedField.getHash() == hash)
                    return hashedField;
            }
        }
        return null;
    }

    public static void setField(Object instance, String fieldName, Object value) {
        Field field = getField(instance.getClass(), fieldName);
        if (field != null) {
            try {
                field.setAccessible(true);
                field.set(instance, value);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    public static void setField(Object instance, Field field, Object value) {
        if (field != null) {
            try {
                field.setAccessible(true);
                field.set(instance, value);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    public static class HashedField {

        private int hash;
        private Field field;

        public HashedField(Class<?> declared, Field field, String name) {
            for (char c : name.toCharArray()) {
                hash += c ^ 16;
            }
            for (char c : declared.getName().toCharArray()) {
                hash += c ^ 16;
            }
            this.field = field;
        }

        public int getHash() {
            return hash;
        }

        public Field getField() {
            return field;
        }
    }
}

