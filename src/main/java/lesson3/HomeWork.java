package lesson3;

import java.util.Arrays;
import java.util.Random;

public class HomeWork {
    public static final int SIZE = 9;

    public static void main(String[] args) {
        int[] arr = new int[SIZE];
        toFill(arr);
        System.out.println(Arrays.toString(arr));
        int lose = toSearch(arr);
        System.out.println("Пропущенное число: " + lose);
    }

    /**
     * Заполняем массив.
     * @param arr массив
     */
    public static void toFill(int[] arr) {
        Random random = new Random();
        int lose = random.nextInt(SIZE) + 1;
        for (int i = 0; i < arr.length; i++) {
            if (i < lose - 1) {
                arr[i] = i + 1;
            }
            else {
                arr[i] = i + 2;
            }
        }
    }

    /**
     * Ищем пропущенное число.
     * @param arr массив
     * @return искомое число
     */
    public static int toSearch(int[] arr) {
        int start = 0;
        int end = arr.length -1;
        int center = (start + end)/2;
        while (start != end || center != start) {
            if (center == arr[center] - 1) {
                if (start == center) {
                    start = center + 1;
                }
                else {
                    start = center;
                }
            }
            else {
                end = center;
            }
            center = (start + end)/2;
        }
        return center + 1;
    }
}