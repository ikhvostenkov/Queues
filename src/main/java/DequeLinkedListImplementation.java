import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by ikhvostenkov on 17.10.16.
 */
public class DequeLinkedListImplementation<Item> implements Iterable<Item> {

    private int size;

    private Node first;
    private Node last;

    private class Node {
        private Item item;
        private Node next;
        private Node prev;
    }

    // construct an empty deque
    public DequeLinkedListImplementation() {
        size = 0;
        first = null;
        last = null;
    }

    // is the deque empty?
    public boolean isEmpty() {
        return size == 0;
    }

    // return the number of items on the deque
    public int size() {
        return size;
    }

    // add the item to the front
    public void addFirst(Item item) {
        if (item == null)
            throw new NullPointerException();

        size++;

        Node n = new Node();
        n.item = item;

        if (first == null && last == null) {
            first = n;
            last = n;
            return;
        }

        first.prev = n;
        n.next = first;
        first = n;
    }

    // add the item to the end
    public void addLast(Item item) {
        if (item == null)
            throw new NullPointerException();

        size++;

        Node n = new Node();
        n.item = item;

        if (first == null && last == null) {
            first = n;
            last = n;
            return;
        }

        last.next = n;
        n.prev = last;
        last = n;
    }

    // remove and return the item from the front
    public Item removeFirst() {
        if (first == null)
            throw new NoSuchElementException();

        size--;

        Item i = first.item;

        if (first == last) {
            first = null;
            last = null;
            return i;
        }

        first = first.next;
        first.prev = null;

        return i;
    }

    // remove and return the item from the end
    public Item removeLast() {
        if (last == null)
            throw new NoSuchElementException();

        size--;

        Item i = last.item;

        if (first == last) {
            first = null;
            last = null;
            return i;
        }

        last = last.prev;
        last.next = null;

        return i;
    }

    // return an iterator over items in order from front to end
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item> {
        private Node current = first;

        public boolean hasNext() {
            return current != null;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next;
            return item;
        }
    }

    // unit testing
    public static void main(String[] args) {
    }
}
