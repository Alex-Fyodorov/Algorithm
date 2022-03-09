package lesson5;

import java.util.*;

public class BackpackApp {

    private static HashMap<List<Thing>, Integer> map;

    public static void main(String[] args) {
        map = new HashMap<>();
        Backpack backpack = new Backpack("Рюкзак", 6);
        List<Thing> list = new ArrayList<>();
        list.add(new Thing("Диван", 30975, 5));
        list.add(new Thing("Чемодан", 25467, 4));
        list.add(new Thing("Саквояж", 12654, 3));
        list.add(new Thing("Картина", 8234, 2));
        list.add(new Thing("Корзина", 5821, 2));
        list.add(new Thing("Картонка", 3498, 1));
        list.add(new Thing("Собачонка", 3846, 1));

        toFillBackpack(list, backpack.getCapacity());
        max();
    }
    
    public static void toFillBackpack(List<Thing> list, int capacity) {
        int mass = 0;
        int sum = 0;
        for (Thing arr : list) {
            mass += arr.getWeight();
            sum += arr.getPrice();
        }
        if (mass <= capacity) {
            map.put(list, sum);
        } else {
            for (int i = 0; i < list.size(); i++) {
                List<Thing> listActual = new ArrayList<>(list);
                listActual.remove(i);
                toFillBackpack(listActual, capacity);
            }
        }
    }

    public static void max() {
        int max = 0;
        List<Thing> listMax = null;
        for (Map.Entry<List<Thing>, Integer> i : map.entrySet()) {
            if (max < i.getValue()) {
                max = i.getValue();
                listMax = i.getKey();
            }
        }
        for (Thing j : listMax) {
            System.out.println(j.getName());
        }
        System.out.println(max);
    }
}
