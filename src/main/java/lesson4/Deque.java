package lesson4;

public interface Deque<T> {

    boolean insertFirst(T value);

    boolean insertLast(T value);

    T removeFirst();

    T removeLast();

    T peekFront();

    T peekBack();

    int size();

    boolean isEmpty();

    boolean isFull();

    void displayNext();

    void displayPrev();
}
