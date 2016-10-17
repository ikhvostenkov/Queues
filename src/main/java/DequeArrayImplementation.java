import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by Igor Khvostenkov (ikhvostenkov@gmail.com)
 */
public class DequeArrayImplementation<Item> implements Iterable<Item> {
    private Item[] s = (Item[]) new Object[1];
    private int n = 0;
    private int first = 0;
    private int last = 0;

    // construct an empty deque
    public DequeArrayImplementation() {
    }

    // is the deque empty?
    public boolean isEmpty() {
        return n == 0;
    }

    // return the number of items on the deque
    public int size() {
        return n;
    }

    // add the item to the front
    public void addFirst(Item item) {
        checkForNull(item);

        if (n == s.length) {
            this.resize(2 * s.length);
        }
        System.arraycopy(s, 0, s, 1, n);
        s[0] = item;
        n++;
    }

    // add the item to the end
    public void addLast(Item item) {
        checkForNull(item);

        if (n == s.length) {
            this.resize(2 * s.length);
        }
        s[n++] = item;
    }

    // remove and return the item from the end
    public Item removeLast() {
        checkDequeIsEmpty();

        Item item = s[--n];
        s[n] = null;
        if (n > 0 && n == s.length / 4) {
            this.resize(s.length / 2);
        }
        return item;
    }

    // return an iterator over items in order from front to end
    public Iterator<Item> iterator() {
        return new DequeIterator();
    }

    // remove and return the item from the front
    public Item removeFirst() {
        checkDequeIsEmpty();

        Item item = s[0];
        if (size() != 1) {
            for (int i = 0; i < n - 1; i++) {
                s[i] = s[i + 1];
            }
        }
        s[--n] = null;
        if (n > 0 && n == s.length / 4) {
            this.resize(s.length / 2);
        }

        return item;
    }

    // unit testing
    public static void main(String[] args) {
    }

    private void resize(int capacity) {
        Item[] copy = (Item[]) new Object[capacity];
        for (int i = 0; i < n; i++) {
            copy[i] = s[i];
        }

        s = copy;
    }

    private void checkForNull(Item item) {
        if (item == null) {
            throw new NullPointerException("Value can not be NULL");
        }
    }

    private void checkDequeIsEmpty() {
        if (size() == 0) {
            throw new NoSuchElementException("DequeArrayImplementation is empty!");
        }
    }

    private class DequeIterator implements Iterator<Item> {
        private int i = 0;

        public boolean hasNext() {
            return i < size();
        }

        public Item next() {
            if (!hasNext()) {
                throw new NoSuchElementException("DequeArrayImplementation has no elements!");
            }
            return s[i++];
        }

        public void remove() {
            throw new UnsupportedOperationException("Remove is not supported!");
        }
    }
}
