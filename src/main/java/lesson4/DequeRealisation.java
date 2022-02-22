package lesson4;

public class DequeRealisation<T> implements Deque<T> {

    private final TwoSideTwoLinkedList<T> data;

    public DequeRealisation() {
        this.data = new TwoSideTwoLinkedList<>();
    }

    @Override
    public boolean insertFirst(T value) {
        data.insertFirst(value);
        return true;
    }

    @Override
    public boolean insertLast(T value) {
        data.insertLast(value);
        return true;
    }

    @Override
    public T removeFirst() {
        return data.deleteFirst();
    }

    @Override
    public T removeLast() {
        return data.deleteLast();
    }

    @Override
    public T peekFront() {
        return data.getFirst();
    }

    @Override
    public T peekBack() {
        return data.getLast();
    }

    @Override
    public int size() {
        return data.size();
    }

    @Override
    public boolean isEmpty() {
        return data.isEmpty();
    }

    @Override
    public boolean isFull() {
        return false;
    }

    @Override
    public void displayNext() {
        data.displayNext();
    }

    @Override
    public void displayPrev() {
        data.displayPrev();
    }
}
