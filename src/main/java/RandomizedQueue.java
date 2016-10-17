import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Random;

/**
 * Created by Igor Khvostenkov (ikhvostenkov@gmail.com)
 */
public class RandomizedQueue<Item> implements Iterable<Item> {
    private int length;
    private int n;
    private Item[] queue;
    private Random random;

    // construct an empty randomized queue
    public RandomizedQueue() {
        this.length = 1;
        this.n = 0;
        this.queue = (Item[]) new Object[this.length];
        this.random = new Random();
    }

    private void resize(int capacity) {
        Item[] itemList = (Item[]) new Object[capacity];
        for (int i = 0; i < this.n; i++) {
            itemList[i] = this.queue[i];
        }
        this.length = capacity;
        this.queue = itemList;
    }

    // is the queue empty?
    public boolean isEmpty() {
        return this.n == 0;
    }

    // return the number of items on the queue
    public int size() {
        return this.n;
    }

    // add the item
    public void enqueue(Item item) {
        if (item == null) {
            throw new NullPointerException();
        }
        if (this.length == this.n) {
            resize(2 * this.length);
        }
        this.queue[n++] = item;

    }

    // remove and return a random item
    public Item dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        int index = this.random.nextInt(n);
        Item item = this.queue[index];
        this.n--;
        this.queue[index] = this.queue[n];
        this.queue[n] = null;
        if (n > 0 && n == this.length / 4)
            resize(this.length / 2);
        return item;
    }

    // return (but do not remove) a random item
    public Item sample() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        int index = this.random.nextInt(n);
        return this.queue[index];
    }

    // return an independent iterator over items in random order
    public Iterator<Item> iterator() {
        return new RandomizedQueueIterator();
    }

    // unit testing
    public static void main(String[] args) {

    }

    private class RandomizedQueueIterator implements Iterator<Item> {

        private int current = 0;
        private Object[] mas;

        private RandomizedQueueIterator() {
            mas = new Object[n];
            System.arraycopy(queue, 0, mas, 0, n);
            StdRandom.shuffle(mas);
        }

        public boolean hasNext() {
            return this.current != n;
        }

        public Item next() {
            if (this.current == n) {
                throw new NoSuchElementException();
            } else {
                return (Item) mas[this.current++];
            }
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }
}
