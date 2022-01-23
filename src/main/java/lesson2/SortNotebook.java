package lesson2;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class SortNotebook {
    public static void main(String[] args) {
        Random random = new Random();
        Notebook[] note = new Notebook[10000];

        Map<Integer, String> prod = new HashMap<>();
        prod.put(0, "Xamiou");
        prod.put(1, "Eser");
        prod.put(2, "MacNote");
        prod.put(3, "Asos");
        prod.put(4, "Lenuvo");

        int index;
        for (int i = 0; i < note.length; i++) {
            index = random.nextInt(5);
            note[i] = new Notebook(500 + 50 * random.nextInt(31),
                    4 + 4 * random.nextInt(6), index, prod.get(index));
        }

        int k;
        for (int i = 1; i < note.length; i++) {
            Notebook buffer = note[i];
            k = i;
            while (k > 0 && note[k - 1].getPrice() > buffer.getPrice()) {
                note[k] = note[k - 1];
                k--;
            }
            while (k > 0 && note[k - 1].getPrice() == buffer.getPrice() &&
                    note[k - 1].getRam() > buffer.getRam()) {
                note[k] = note[k - 1];
                k--;
            }
            while (k > 0 && note[k - 1].getPrice() == buffer.getPrice() &&
                    note[k - 1].getRam() == buffer.getRam() &&
                    note[k - 1].getIndex() > buffer.getIndex()) {
                note[k] = note[k - 1];
                k--;
            }
            note[k] = buffer;
        }

        for (int i = 0; i < note.length; i++) {
            System.out.println(note[i].toString());
        }
    }
}