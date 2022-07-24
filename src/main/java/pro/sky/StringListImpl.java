package pro.sky;

import pro.sky.StringList;

import java.util.Objects;

public class StringListImpl implements StringList {

    private static final int INITIAL_SIZE=15;
    private final String[] data;
    private int capacity;

    public StringListImpl() {
        data = new String[INITIAL_SIZE];
        capacity = 0;
    }
    public StringListImpl(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("Размер списка должен быть положительным");
        }
        data = new String[n];
        capacity = 0;
    }

    @Override
    public String add(String item) {
        if (Objects.isNull(item))
            throw new IllegalArgumentException("Нельзя добавлять 0 в список");
        if (capacity >= data.length) {
            throw new IllegalArgumentException("Список заполнен");
        }
        data[capacity++] = item;
        return item;
    }

    @Override
    public String add(int index, String item) {
        if (capacity >= data.length) {
            throw new IllegalArgumentException("Список заполнен");
        }
        if (Objects.isNull(item))
            throw new IllegalArgumentException("Нельзя добавлять 0 в список");
        if (index < 0) {
            throw new IllegalArgumentException("Индекс не может быть отрицательным");
        }
        if (index > capacity) {
            throw new IllegalArgumentException("Индекс:" + index + "Размер:" + capacity);
        }
        for (int i = capacity; i > index; i--) {
            data[i] = data[i - 1];
        }
        data[index] = item;
        capacity++;
        return item;
    }

    @Override
    public String set(int index, String item) {
        if (Objects.isNull(item))
            throw new IllegalArgumentException("Нельзя добавлять 0 в список");
        if (index < 0) {
            throw new IllegalArgumentException("Индекс не может быть отрицательным");
        }
        if (index > capacity) {
            throw new IllegalArgumentException("Индекс:" + index + "Размер:" + capacity);
        }
        data[index] = item;
        return item;
    }

    @Override
    public String remove(String item) {
        if (Objects.isNull(item))
            throw new IllegalArgumentException("Нельзя добавлять 0 в список");
        int indexRemov = -1;
        for (int i = 0; i < capacity; i++) {
            if (data[i].equals(item)) {
                indexRemov = i;
                break;
            }
        }
        if (indexRemov == -1) {
            throw new IllegalArgumentException("Элемент не найден");
        }
        return remove(indexRemov);
    }

    @Override
    public String remove(int index) {
        if (index >= capacity) {
            throw new IllegalArgumentException("Индекс:" + index + "Размер:" + capacity);
        }
        if (index < 0) {
            throw new IllegalArgumentException("Индекс не может быть отрицательным");
        }
        String removed = data[index];
        for (int i = index; i < capacity - 1; i++) {
            data[i] = data[i + 1];
        }
        data[--capacity] = null;
        return removed;
    }

    @Override
    public boolean contains(String item) {
        if (Objects.isNull(item)){
            throw new IllegalArgumentException("Нельзя добавлять 0 в список");
        }
        for (int i = 0; i < capacity; i++) {
            if (data[i].equals(item)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int indexOf(String item) {
        if (Objects.isNull(item)){
            throw new IllegalArgumentException("Нельзя добавлять 0 в список");
        }
        int index = - 1;
        for (int i = 0; i < capacity; i++) {
            if (data[i].equals(item)) {
                index = i;
                break;
            }
        }
        return index;
    }

    @Override
    public int lastIndexOf(String item) {
        if (Objects.isNull(item)){
            throw new IllegalArgumentException("Нельзя добавлять 0 в список");
        }
        int index = -1;
        for (int i = capacity; i >= 0; i--) {
            if (data[i].equals(item)) {
                index = i;
                break;
            }
        }
        return index;
    }

    @Override
    public String get(int index) {
        if (index < 0) {
            throw new IllegalArgumentException("Индекс не может быть отрицательным");
        }
        if (index >= capacity) {
            throw new IllegalArgumentException("Индекс:" + index + "Размер:" + capacity);
        }
        return data[index];
    }

    @Override
    public boolean equals(StringList otherList) {
        if (size() != otherList.size()) {
            return false;
        }
        for (int i = 0; i < capacity; i++) {
            if (!data[i].equals((otherList.get(i)))) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int size() {
        return capacity;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public void clear() {
        for (int i = 0; i < capacity; i++) {
            data[i] = null;
        }
        capacity = 0;
    }

    @Override
    public String[] toArray() {
        String[] result = new String[capacity];
        for (int i = 0; i < capacity; i++) {
            result[i] = data[i];
        }
        return result;
    }
}
