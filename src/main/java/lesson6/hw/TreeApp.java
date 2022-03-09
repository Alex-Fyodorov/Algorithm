package lesson6.hw;

import lesson6.lection.Tree;
import lesson6.lection.TreeImpl;
import lesson6.lection.Node;

import java.util.*;

public class TreeApp {

    public static final int QUANTITY = 10000;
    public static final int RANGE = 25;

    public static void main(String[] args) {
        List<TreeImpl<Integer>> list = new ArrayList<>();
        toInitAndToFillTrees(list);
        int balanced = 0;
        int count = 0;
        for (TreeImpl<Integer> tree : list) {
            count++;
            if (isBalanced(tree.getRoot())) {//Добавил метод getRoot в TreeImpl.
                balanced++;
            }
        }
        System.out.println("Метод из методички: " + balanced + " / " + count);
        balanced = 0;
        count = 0;
        for (TreeImpl<Integer> tree : list) {
            count++;
            if (isBalancedMyMethod(tree.getRoot())) {
                balanced++;
            }
        }
        System.out.println("Мой метод: " + balanced + " / " + count);

        //При помощи данного куска кода искал и изучал "спорные" деревья.

/*        System.out.println(balanced + " / " + count);
        for (TreeImpl<Integer> tree : list) {
            tree.display();
            if (isBalancedMyMethod(tree.getRoot())) {
                System.out.print("+ / ");
            } else {
                System.out.print("- / ");
            }
            if (isBalanced(tree.getRoot())) {
                System.out.println("+");
            } else {
                System.out.println("-");
            }
        }*/

    }

    /**
     * Увеличил количество заполняемых деревьев с 20 до 10000, чтобы получить
     * более точные данные о получаемом количестве сбалансированных деревьев.
     */
    public static void toInitAndToFillTrees(List<TreeImpl<Integer>> list) {
        Random random = new Random();
        for (int i = 0; i < QUANTITY; i++) {
            list.add(new TreeImpl<>());
            for (int j = 0; j < 15; j++) {//В 4-хуровневом дереве 15 узлов.
                list.get(i).add(random.nextInt(RANGE * 2 + 1) - RANGE);
            }
        }
    }

    /**
     * Данный метод приведён в разделе "Как решать" и выдаёт примерный результат
     * 1,7% сбалансированных деревьев изобщей массы.
     */
    public static boolean isBalanced(Node<Integer> node) {
        return (node == null) ||
                isBalanced(node.getLeftChild()) &&
                        isBalanced(node.getRightChild()) &&
                        Math.abs(height(node.getLeftChild()) -
                                height(node.getRightChild())) <= 1;
    }

    private static int height(Node<Integer> node) {
        return node == null ? 0 : 1 + Math.max(height(node.getLeftChild()),
                height(node.getRightChild()));
    }

    /**
     * Поскольку, не вполне понимаю, как работает метод, приведённый выше,
     * сделал свой собственный. Выяснилось, что результаты они выдают разные.
     * Искал "спорные" деревья. Выяснилось, что количество проходов от корня
     * до каждого листа мой метод считает абсолютно правильно. Если я всё же
     * где-то ошибся, буду благодарен за указание, где именно.
     */
    public static boolean isBalancedMyMethod(Node<Integer> node) {
        if (node == null) {
            return true;
        }
        int f = 0;
        Set<Integer> set = new HashSet<>();
        set = toFindPassages(node, f, set);
        int max = 0;
        for (Integer itemMax : set) {
            if (itemMax > max) {
                max = itemMax;
            }
        }
        int min = max;
        for (Integer itemMin : set) {
            if (min > itemMin) {
                min = itemMin;
            }
        }
//        System.out.println(set.toString());
        return (max - min) <= 1;
    }

    public static Set<Integer> toFindPassages(Node<Integer> node, int f,
                                              Set<Integer> set) {
        if (node.getLeftChild() != null) {
            toFindPassages(node.getLeftChild(), f + 1, set);
        } else {
            set.add(f);
        }
        if (node.getRightChild() != null) {
            toFindPassages(node.getRightChild(), f + 1, set);
        } else {
            set.add(f);
        }
        return set;
    }
}