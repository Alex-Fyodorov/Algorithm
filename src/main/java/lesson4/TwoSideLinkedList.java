package lesson4;

public interface TwoSideLinkedList<T> {

    T getFirst();

    T getLast();

    void insertFirst(T value);

    void insertLast(T value);

    T deleteFirst();

    T deleteLast();

    boolean delete(T value);

    int size();

    boolean isEmpty();

    void displayNext();

    void displayPrev();

    class Node<T> {
        T value;
        Node<T> next;
        Node<T> prev;

        public Node(T value, Node<T> next, Node<T> prev) {
            this.value = value;
            this.next = next;
            this.prev = prev;
        }
    }
}
