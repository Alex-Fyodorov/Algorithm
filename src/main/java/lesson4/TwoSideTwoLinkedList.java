package lesson4;

import java.util.Iterator;
import java.util.function.Consumer;

public class TwoSideTwoLinkedList<T> implements TwoSideLinkedList<T>,
        Iterable<T> {

    protected int size;
    protected Node<T> first;
    protected Node<T> last;


    @Override
    public T getFirst() {
        return first.value;
    }

    @Override
    public T getLast() {
        return last.value;
    }

    @Override
    public void insertFirst(T value) {
        first = new Node<>(value, first, null);
        size++;
        if (size == 1) {
            last = first;
        } else {
            first.next.prev = first;
        }
    }

    @Override
    public void insertLast(T value) {
        last = new Node<>(value, null, last);
        size++;
        if (size == 1) {
            first = last;
        } else {
            last.prev.next = last;
        }
    }

    @Override
    public T deleteFirst() {
        if (isEmpty()) {
            return null;
        }
        Node<T> temp = first;
        first = first.next;
        temp.next = null;
        if (size == 1) {
            last = first;
        } else {
            first.prev = null;
        }
        size--;
        return temp.value;
    }

    @Override
    public T deleteLast() {
        if (isEmpty()) {
            return null;
        }
        Node<T> temp = last;
        last = last.prev;
        temp.prev = null;
        if (size == 1) {
            first = last;
        } else {
            last.next = null;
        }
        size--;
        return temp.value;
    }

    @Override
    public boolean delete(T value) {
        Node<T> current = first;
        while (current != null) {
            if (current.value.equals(value)) {
                if (current.equals(first)) {
                    deleteFirst();
                } else if (current.equals(last)) {
                    deleteLast();
                } else {
                    current.prev.next = current.next;
                    current.next.prev = current.prev;
                    current.prev = null;
                    current.next = null;
                    size--;
                }
                return true;
            }
            current = current.next;
        }
        return false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return first == null;
    }

    @Override
    public void displayNext() {
        StringBuilder sb = new StringBuilder("[");
        Node<T> current = first;
        while (current != null) {
            sb.append(current.value);
            if (current.next != null) {
                sb.append(" -> ");
            }
            current = current.next;
        }
        sb.append("]");
        System.out.println(sb.toString());
    }

    @Override
    public void displayPrev() {
        StringBuilder sb = new StringBuilder("[");
        Node<T> current = last;
        while (current != null) {
            sb.append(current.value);
            if (current.prev != null) {
                sb.append(" -> ");
            }
            current = current.prev;
        }
        sb.append("]");
        System.out.println(sb.toString());
    }

    @Override
    public Iterator<T> iterator() {
        return new ListIterator<>(this);
    }

    private class ListIterator<T> implements Iterator<T> {
        private Node<T> current;
        private TwoSideTwoLinkedList<T> list;

        public ListIterator(TwoSideTwoLinkedList<T> list) {
            this.list = list;
            this.reset();
        }

        public void reset() {
            current = list.first;
        }

        @Override
        public boolean hasNext() {
            if (current.next != null){
                return true;
            }
            return false;
        }

        @Override
        public T next() {
            T dd = current.value;
            current = current.next;
            return dd;
        }
    }

}
