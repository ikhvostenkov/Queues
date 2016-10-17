import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

/**
 * Created by ikhvostenkov on 17.10.16.
 */
class DequeLinkedListImplementationTest {
    @Test
    public void testIsEmpty() {
        DequeLinkedListImplementation dequeLinkedListImplementation = new DequeLinkedListImplementation();
        assertThat(dequeLinkedListImplementation.isEmpty(), is(true));
    }

    @Test
    public void testEmptySize() {
        DequeLinkedListImplementation dequeLinkedListImplementation = new DequeLinkedListImplementation();
        assertThat(dequeLinkedListImplementation.size(), is(0));
    }

    @Test(expected = NullPointerException.class)
    public void testAddFirstNullElement() {
        DequeLinkedListImplementation dequeLinkedListImplementation = new DequeLinkedListImplementation();
        dequeLinkedListImplementation.addFirst(null);
    }

    @Test(expected = NullPointerException.class)
    public void testAddLastNullElement() {
        DequeLinkedListImplementation dequeLinkedListImplementation = new DequeLinkedListImplementation();
        dequeLinkedListImplementation.addLast(null);
    }

    @Test(expected = NoSuchElementException.class)
    public void testRemoveFirstFromEmptyDeque() {
        DequeLinkedListImplementation dequeLinkedListImplementation = new DequeLinkedListImplementation();
        dequeLinkedListImplementation.removeFirst();
    }

    @Test(expected = NoSuchElementException.class)
    public void testRemoveLastFromEmptyDeque() {
        DequeLinkedListImplementation dequeLinkedListImplementation = new DequeLinkedListImplementation();
        dequeLinkedListImplementation.removeLast();
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testIteratorRemove() {
        DequeLinkedListImplementation dequeLinkedListImplementation = new DequeLinkedListImplementation();
        dequeLinkedListImplementation.iterator().remove();
    }

    @Test(expected = NoSuchElementException.class)
    public void testIteratorNextForNonElements() {
        DequeLinkedListImplementation dequeLinkedListImplementation = new DequeLinkedListImplementation();
        dequeLinkedListImplementation.addFirst(1);
        Iterator<Integer> iter = dequeLinkedListImplementation.iterator();
        iter.next();
        iter.next();
    }

    @Test
    public void testAddFirstWorks() {
        int elementsToAdd = 100;
        DequeLinkedListImplementation<Integer> dequeLinkedListImplementation = new DequeLinkedListImplementation<Integer>();
        for (int i = 0; i <= elementsToAdd; i++) {
            dequeLinkedListImplementation.addFirst(i);
        }

        assertThat(dequeLinkedListImplementation.iterator().next(), is(elementsToAdd));
    }

    @Test
    public void testAddLastWorks() {
        int elementsToAdd = 100;
        DequeLinkedListImplementation<Integer> dequeLinkedListImplementation = new DequeLinkedListImplementation<Integer>();
        for (int i = 0; i <= elementsToAdd; i++) {
            dequeLinkedListImplementation.addLast(i);
        }

        assertThat(dequeLinkedListImplementation.iterator().next(), is(0));
    }

    @Test
    public void testRemoveFirstWorks() {
        int elementsToAdd = 100;
        DequeLinkedListImplementation<Integer> dequeLinkedListImplementation = new DequeLinkedListImplementation<Integer>();
        for (int i = 0; i <= elementsToAdd; i++) {
            dequeLinkedListImplementation.addLast(i);
        }

        for (int i = 0; i <= elementsToAdd; i++) {
            dequeLinkedListImplementation.removeFirst();
        }

        assertThat(dequeLinkedListImplementation.size(), is(0));
    }

    @Test
    public void testRemoveLastWorks() {
        int elementsToAdd = 100;
        DequeLinkedListImplementation<Integer> dequeLinkedListImplementation = new DequeLinkedListImplementation<Integer>();
        for (int i = 0; i <= elementsToAdd; i++) {
            dequeLinkedListImplementation.addFirst(i);
        }

        for (int i = 0; i <= elementsToAdd; i++) {
            dequeLinkedListImplementation.removeLast();
        }

        assertThat(dequeLinkedListImplementation.size(), is(0));
    }

    @Test
    public void testAddFirstRemoveFirst() {
        DequeLinkedListImplementation<Integer> dequeLinkedListImplementation = new DequeLinkedListImplementation<Integer>();
        dequeLinkedListImplementation.addFirst(0);
        dequeLinkedListImplementation.removeFirst();

        assertThat(dequeLinkedListImplementation.isEmpty(), is(true));
    }

    @Test
    public void testAddFirstAddLast() {
        DequeLinkedListImplementation<Integer> dequeLinkedListImplementation = new DequeLinkedListImplementation<Integer>();
        dequeLinkedListImplementation.addFirst(0);
        dequeLinkedListImplementation.addLast(0);

        assertThat(dequeLinkedListImplementation.size(), is(2));
    }

    @Test
    public void testAddFirstIteratorWorks() {
        int elementsToAdd = 100;
        DequeLinkedListImplementation<Integer> dequeLinkedListImplementation = new DequeLinkedListImplementation<Integer>();
        for (int i = 0; i <= elementsToAdd; i++) {
            dequeLinkedListImplementation.addFirst(i);
        }
        int count = 0;

        for (Integer integer : dequeLinkedListImplementation) {
            count++;
        }

        assertThat(count, is(elementsToAdd + 1));
    }
}