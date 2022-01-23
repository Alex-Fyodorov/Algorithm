package lesson2;

import java.util.Arrays;
import java.util.Random;

public class SortArray {
    private static final int QUANTITY = 100000;
    private static final int END = 400000;
    private static int[] arr = new int[QUANTITY];

    public static void main(String[] args) {
        toFill();

        //sortBubble(); 16.676 ms
        //sortSelect(); 14.373 ms
        //sortInsert(); 1.135 ms

        System.out.println(Arrays.toString(arr));
    }

    public static void toFill() {
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(END);
        }
    }

    public static void sortBubble() {
        long startTime = System.currentTimeMillis();
        int buffer;
        for (int i = arr.length - 1; i >= 1; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    change(j, j + 1);
                }
            }
        }
        long stopTime = System.currentTimeMillis() - startTime;
        System.out.println(stopTime);
    }

    public static void sortSelect() {
        long startTime = System.currentTimeMillis();
        int min;
        int max;
        for (int i = 0; i < arr.length; i++){
            min = i;
            max = i;
            for (int j = i + 1; j < arr.length - i; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
                if (arr[j] > arr[max]) {
                    max = j;
                }
                change(min, i);
                change(max, arr.length - i - 1);
            }
        }
        long stopTime = System.currentTimeMillis() - startTime;
        System.out.println(stopTime);
    }

    public static void sortInsert() {
        long startTime = System.currentTimeMillis();
        int j;
        for (int i = 0; i < arr.length; i++) {
            int buffer = arr[i];
            j = i;
            while (j > 0 && arr[j - 1] > buffer) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = buffer;
        }
        long stopTime = System.currentTimeMillis() - startTime;
        System.out.println(stopTime);
    }

    public static void change (int a, int b) {
        int buffer;
        buffer = arr[a];
        arr[a] = arr[b];
        arr[b] = buffer;
    }
}
