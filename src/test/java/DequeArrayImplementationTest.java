import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by ikhvostenkov on 16.10.16.
 */
public class DequeArrayImplementationTest {
    @Test
    public void testIsEmpty() {
        DequeArrayImplementation dequeArrayImplementation = new DequeArrayImplementation();
        assertThat(dequeArrayImplementation.isEmpty(), is(true));
    }

    @Test
    public void testEmptySize() {
        DequeArrayImplementation dequeArrayImplementation = new DequeArrayImplementation();
        assertThat(dequeArrayImplementation.size(), is(0));
    }

    @Test(expected = NullPointerException.class)
    public void testAddFirstNullElement() {
        DequeArrayImplementation dequeArrayImplementation = new DequeArrayImplementation();
        dequeArrayImplementation.addFirst(null);
    }

    @Test(expected = NullPointerException.class)
    public void testAddLastNullElement() {
        DequeArrayImplementation dequeArrayImplementation = new DequeArrayImplementation();
        dequeArrayImplementation.addLast(null);
    }

    @Test(expected = NoSuchElementException.class)
    public void testRemoveFirstFromEmptyDeque() {
        DequeArrayImplementation dequeArrayImplementation = new DequeArrayImplementation();
        dequeArrayImplementation.removeFirst();
    }

    @Test(expected = NoSuchElementException.class)
    public void testRemoveLastFromEmptyDeque() {
        DequeArrayImplementation dequeArrayImplementation = new DequeArrayImplementation();
        dequeArrayImplementation.removeLast();
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testIteratorRemove() {
        DequeArrayImplementation dequeArrayImplementation = new DequeArrayImplementation();
        dequeArrayImplementation.iterator().remove();
    }

    @Test(expected = NoSuchElementException.class)
    public void testIteratorNextForNonElements() {
        DequeArrayImplementation dequeArrayImplementation = new DequeArrayImplementation();
        dequeArrayImplementation.addFirst(1);
        Iterator<Integer> iter = dequeArrayImplementation.iterator();
        iter.next();
        iter.next();
    }

    @Test
    public void testAddFirstWorks() {
        int elementsToAdd = 100;
        DequeArrayImplementation<Integer> dequeArrayImplementation = new DequeArrayImplementation<Integer>();
        for (int i = 0; i <= elementsToAdd; i++) {
            dequeArrayImplementation.addFirst(i);
        }

        assertThat(dequeArrayImplementation.iterator().next(), is(elementsToAdd));
    }

    @Test
    public void testAddLastWorks() {
        int elementsToAdd = 100;
        DequeArrayImplementation<Integer> dequeArrayImplementation = new DequeArrayImplementation<Integer>();
        for (int i = 0; i <= elementsToAdd; i++) {
            dequeArrayImplementation.addLast(i);
        }

        assertThat(dequeArrayImplementation.iterator().next(), is(0));
    }

    @Test
    public void testRemoveFirstWorks() {
        int elementsToAdd = 100;
        DequeArrayImplementation<Integer> dequeArrayImplementation = new DequeArrayImplementation<Integer>();
        for (int i = 0; i <= elementsToAdd; i++) {
            dequeArrayImplementation.addLast(i);
        }

        for (int i = 0; i <= elementsToAdd; i++) {
            dequeArrayImplementation.removeFirst();
        }

        assertThat(dequeArrayImplementation.size(), is(0));
    }

    @Test
    public void testRemoveLastWorks() {
        int elementsToAdd = 100;
        DequeArrayImplementation<Integer> dequeArrayImplementation = new DequeArrayImplementation<Integer>();
        for (int i = 0; i <= elementsToAdd; i++) {
            dequeArrayImplementation.addFirst(i);
        }

        for (int i = 0; i <= elementsToAdd; i++) {
            dequeArrayImplementation.removeLast();
        }

        assertThat(dequeArrayImplementation.size(), is(0));
    }

    @Test
    public void testAddFirstRemoveFirst() {
        DequeArrayImplementation<Integer> dequeArrayImplementation = new DequeArrayImplementation<Integer>();
        dequeArrayImplementation.addFirst(0);
        dequeArrayImplementation.removeFirst();

        assertThat(dequeArrayImplementation.isEmpty(), is(true));
    }

    @Test
    public void testAddFirstAddLast() {
        DequeArrayImplementation<Integer> dequeArrayImplementation = new DequeArrayImplementation<Integer>();
        dequeArrayImplementation.addFirst(0);
        dequeArrayImplementation.addLast(0);

        assertThat(dequeArrayImplementation.size(), is(2));
    }

    @Test
    public void testAddFirstIteratorWorks() {
        int elementsToAdd = 100;
        DequeArrayImplementation<Integer> dequeArrayImplementation = new DequeArrayImplementation<Integer>();
        for (int i = 0; i <= elementsToAdd; i++) {
            dequeArrayImplementation.addFirst(i);
        }
        int count = 0;

        for (Integer integer : dequeArrayImplementation) {
            count++;
        }

        assertThat(count, is(elementsToAdd + 1));
    }
}