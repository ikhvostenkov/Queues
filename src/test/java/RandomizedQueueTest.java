import org.junit.Test;

import java.util.NoSuchElementException;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItemInArray;
import static org.hamcrest.core.IsNot.not;

/**
 * Created by ikhvostenkov on 16.10.16.
 */
public class RandomizedQueueTest {
    @Test
    public void testIsEmpty() {
        RandomizedQueue randomizedQueue = new RandomizedQueue();
        assertThat(randomizedQueue.isEmpty(), is(true));
    }

    @Test
    public void testEmptySize() {
        RandomizedQueue randomizedQueue = new RandomizedQueue();
        assertThat(randomizedQueue.size(), is(0));
    }

    @Test(expected = NullPointerException.class)
    public void testAddNullElement() {
        RandomizedQueue randomizedQueue = new RandomizedQueue();
        randomizedQueue.enqueue(null);
    }

    @Test(expected = NoSuchElementException.class)
    public void testRemoveFromEmptyRandomizedQueue() {
        RandomizedQueue randomizedQueue = new RandomizedQueue();
        randomizedQueue.dequeue();
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testIteratorRemove() {
        RandomizedQueue randomizedQueue = new RandomizedQueue();
        randomizedQueue.iterator().remove();
    }

    @Test(expected = NoSuchElementException.class)
    public void testIteratorNextForNonElements() {
        RandomizedQueue randomizedQueue = new RandomizedQueue();
        randomizedQueue.iterator().next();
    }

    @Test
    public void testEnqueueWorks() {
        int elementsToAdd = 100;
        RandomizedQueue<Integer> randomizedQueue = new RandomizedQueue<Integer>();
        for (int i = 0; i <= elementsToAdd; i++) {
            randomizedQueue.enqueue(i);
        }

        assertThat(randomizedQueue.iterator().next(), is(notNullValue()));
    }

    @Test
    public void testDequeueWorks() {
        int elementsToAdd = 100;
        RandomizedQueue<Integer> randomizedQueue = new RandomizedQueue<Integer>();
        for (int i = 0; i <= elementsToAdd; i++) {
            randomizedQueue.enqueue(i);
        }
        assertThat(randomizedQueue.dequeue(), is(notNullValue()));
    }

    @Test
    public void testSampleWorks() {
        int elementsToAdd = 100;
        Integer[] arrayOfTestInts = new Integer[elementsToAdd + 1];
        RandomizedQueue<Integer> randomizedQueue = new RandomizedQueue<Integer>();
        for (int i = 0; i <= elementsToAdd; i++) {
            randomizedQueue.enqueue(i);
            arrayOfTestInts[i] = i;
        }

        for (int i = 0; i <= elementsToAdd; i++) {
            assertThat(arrayOfTestInts, hasItemInArray(randomizedQueue.sample()));
        }
    }

    @Test
    public void testIteratorWorks() {
        int elementsToAdd = 100;
        RandomizedQueue<Integer> randomizedQueue = new RandomizedQueue<Integer>();
        for (int i = 0; i <= elementsToAdd; i++) {
            randomizedQueue.enqueue(i);
        }
        int count = 0;

        for (Integer integer : randomizedQueue) {
            count++;
        }

        assertThat(count, is(elementsToAdd + 1));
    }
}