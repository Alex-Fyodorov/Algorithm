package lesson8.hw;

import java.util.ArrayList;
import java.util.LinkedList;


public class HashTableImpl<K, V> implements HashTable<K, V>{

    private ArrayList<LinkedList<Item<K, V>>> data;
    private int size;

    static class Item<K, V> implements Entry<K, V> {
        private final K key;
        private V value;

        public Item(K key, V value) {
            this.key = key;
            this.value = value;
        }


        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }

        @Override
        public void setValue(V value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Item{" +
                    "key=" + key +
                    ", value=" + value +
                    '}';
        }
    }

    public HashTableImpl(int initialCapacity) {
        data = new ArrayList<>(initialCapacity);
        for (int i = 0; i < initialCapacity; i++) {
            data.add(new LinkedList<>());
        }
    }

    public HashTableImpl(LinkedList<Item<K, V>>[] data) {
        this(16);
    }

    @Override
    public boolean put(K key, V value) {
        int index = hashFunc(key);
        if (data.get(index).isEmpty()) {
            data.get(index).add(new Item<>(key, value));
            size++;
            return true;
        }
        for (Item<K, V> item : data.get(index)) {
            if (item.getKey().equals(key)) {
                item.setValue(value);
                return true;
            }
        }
        data.get(index).add(new Item<>(key, value));
        size++;
        return true;
    }

    private int hashFunc(K key) {
        return Math.abs(key.hashCode() % data.size());
    }

    @Override
    public V get(K key) {
        int index = indexOf(key);
        if (index == -1) {
            return null;
        } else if (data.get(index).size() == 1) {
            if (data.get(index).getFirst().getKey().equals(key)) {
                return data.get(index).getFirst().getValue();
            }
        } else {
            for (Item<K, V> item : data.get(index)) {
                if (item.getKey().equals(key)) {
                    return item.getValue();
                }
            }
        }
        return null;
    }

    private int indexOf(K key) {
        int index = hashFunc(key);
        return data.get(index).isEmpty() ? -1 : index;
    }

    @Override
    public V remove(K key) {
        int index = indexOf(key);
        Item<K, V> temp = null;
        V removedValue = null;
        if (index == -1) {
            return null;
        } else if (data.get(index).getFirst().getKey().equals(key)) {
            removedValue = data.get(index).getFirst().getValue();
            data.get(index).removeFirst();
            return removedValue;
        } else if (data.get(index).getLast().getKey().equals(key)) {
            removedValue = data.get(index).getLast().getValue();
            data.get(index).removeLast();
            return removedValue;
        } else {
            while (!data.get(index).getFirst().getKey().equals(key)) {
                temp = data.get(index).getFirst();
                data.get(index).removeFirst();
                data.get(index).addLast(temp);
            }
            removedValue = data.get(index).getFirst().getValue();
            data.get(index).removeFirst();
        }
        return removedValue;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void display() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < data.size(); i++) {
            sb.append(String.format("%s = [%s]\n", i, data.get(i)));
        }
        return sb.toString();
    }
}