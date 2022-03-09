package lesson4;

public class Main {
    public static void main(String[] args) {
        TwoSideTwoLinkedList<Integer> list = new TwoSideTwoLinkedList<>();
        list.insertLast(8);
        list.insertLast(12);
        list.insertFirst(1);
        list.insertFirst(2);
        list.insertFirst(3);
        list.insertLast(11);
        list.insertFirst(4);
        list.insertFirst(5);
        list.insertFirst(6);
        list.insertFirst(7);
        list.displayNext();
        list.insertLast(8);
        list.displayNext();
        list.deleteFirst();
        list.displayNext();
        list.deleteLast();
        list.displayNext();
        list.delete(11);
        list.displayNext();
        System.out.println(list.getFirst());
        System.out.println(list.getLast());
        System.out.println(list.size());
        list.displayNext();
        list.displayPrev();

        for (Integer n : list) {
            System.out.println(n);
        }
    }
}
