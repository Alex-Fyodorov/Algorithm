package lesson5;

import java.util.LinkedHashSet;
import java.util.Set;

public class Anagram {
    private Set<String> resultSet = new LinkedHashSet<>();
    private char[] chars;

    public static void main(String[] args) {
        System.out.println(new Anagram().findAll("aadd"));
    }

    private Set<String> findAll(String word) {
        resultSet.clear();
        chars = word.toCharArray();

        find(chars.length);

        return resultSet;
    }

    private void find(int lenhth) {
        if (lenhth == 1) {
            return;
        }
        for (int i = 0; i < lenhth; i++) {
            find(lenhth - 1);
            resultSet.add(String.valueOf(chars));
            rotate(lenhth);
        }
    }

    private void rotate(int lenhth) {
        int first = chars.length - lenhth;
        char temp = chars[first];
        for (int i = first + 1; i < chars.length; i++) {
            chars[i - 1] = chars[i];
        }
        chars[chars.length - 1] = temp;
    }
}
