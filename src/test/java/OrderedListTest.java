import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderedListTest {
    OrderedList<Integer> orderedList = new OrderedList<>(true);

    // addAscending
    @Test
    public void add_whenAscendingAndEmpty() {
        orderedList.add(1);

        assertEquals(1, orderedList.head.value);
        assertEquals(1, orderedList.tail.value);
    }

    @Test
    public void add_whenAscendingAndAddInHead() {
        orderedList.add(5);
        orderedList.add(3);

        assertEquals(3, orderedList.head.value);
        assertEquals(5, orderedList.tail.value);

        orderedList.add(1);

        assertEquals(1, orderedList.head.value);
        assertEquals(5, orderedList.tail.value);
    }

    @Test
    public void add_whenAscendingAndAddInTail() {
        orderedList.add(3);
        orderedList.add(5);

        assertEquals(3, orderedList.head.value);
        assertEquals(5, orderedList.tail.value);

        orderedList.add(7);

        assertEquals(3, orderedList.head.value);
        assertEquals(7, orderedList.tail.value);
    }

    @Test
    public void add_whenAscendingAndAddInMiddle() {
        orderedList.add(1);
        orderedList.add(5);
        orderedList.add(4);

        assertEquals(1, orderedList.head.value);
        assertEquals(4, orderedList.head.next.value);
        assertEquals(5, orderedList.tail.value);
    }

    @Test
    public void add_whenAscendingAndAddSameValueInHead() {
        orderedList.add(1);
        orderedList.add(5);
        orderedList.add(4);
        orderedList.add(1);
        orderedList.add(1);

        assertEquals(1, orderedList.head.value);
        assertEquals(1, orderedList.head.next.value);
        assertEquals(1, orderedList.head.next.next.value);
        assertEquals(4, orderedList.head.next.next.next.value);
        assertEquals(5, orderedList.tail.value);
    }

    @Test
    public void add_whenAscendingAndAddSameValueInTail() {
        orderedList.add(1);
        orderedList.add(5);
        orderedList.add(4);
        orderedList.add(5);
        orderedList.add(5);

        assertEquals(1, orderedList.head.value);
        assertEquals(4, orderedList.head.next.value);
        assertEquals(5, orderedList.head.next.next.value);
        assertEquals(5, orderedList.head.next.next.next.value);
        assertEquals(5, orderedList.tail.value);
    }

    @Test
    public void add_whenAscendingAndAddSameValueInMiddle() {
        orderedList.add(1);
        orderedList.add(5);
        orderedList.add(4);
        orderedList.add(4);
        orderedList.add(4);

        assertEquals(1, orderedList.head.value);
        assertEquals(4, orderedList.head.next.value);
        assertEquals(4, orderedList.head.next.next.value);
        assertEquals(4, orderedList.head.next.next.next.value);
        assertEquals(5, orderedList.tail.value);
    }

    // addNotAscending
    @Test
    public void add_whenNotAscendingAndEmpty() {
        orderedList.add(1);

        assertEquals(1, orderedList.head.value);
        assertEquals(1, orderedList.tail.value);
    }

    @Test
    public void add_whenNotAscendingAndAddInHead() {
        orderedList.clear(false);
        orderedList.add(3);
        orderedList.add(5);

        assertEquals(5, orderedList.head.value);
        assertEquals(3, orderedList.tail.value);

        orderedList.add(7);

        assertEquals(7, orderedList.head.value);
        assertEquals(3, orderedList.tail.value);
    }

    @Test
    public void add_whenNotAscendingAndAddInTail() {
        orderedList.clear(false);
        orderedList.add(3);
        orderedList.add(5);

        assertEquals(5, orderedList.head.value);
        assertEquals(3, orderedList.tail.value);

        orderedList.add(7);

        assertEquals(7, orderedList.head.value);
        assertEquals(3, orderedList.tail.value);
    }

    @Test
    public void add_whenNotAscendingAndAddInMiddle() {
        orderedList.clear(false);
        orderedList.add(1);
        orderedList.add(5);
        orderedList.add(4);

        assertEquals(5, orderedList.head.value);
        assertEquals(4, orderedList.head.next.value);
        assertEquals(1, orderedList.tail.value);
    }

    @Test
    public void add_whenNotAscendingAndAddSameValueInHead() {
        orderedList.clear(false);
        orderedList.add(1);
        orderedList.add(5);
        orderedList.add(4);
        orderedList.add(5);
        orderedList.add(5);

        assertEquals(5, orderedList.head.value);
        assertEquals(5, orderedList.head.next.value);
        assertEquals(5, orderedList.head.next.next.value);
        assertEquals(4, orderedList.head.next.next.next.value);
        assertEquals(1, orderedList.tail.value);
    }

    @Test
    public void add_whenNotAscendingAndAddSameValueInTail() {
        orderedList.clear(false);
        orderedList.add(1);
        orderedList.add(5);
        orderedList.add(4);
        orderedList.add(1);
        orderedList.add(1);

        assertEquals(5, orderedList.head.value);
        assertEquals(4, orderedList.head.next.value);
        assertEquals(1, orderedList.head.next.next.value);
        assertEquals(1, orderedList.head.next.next.next.value);
        assertEquals(1, orderedList.tail.value);
    }

    @Test
    public void add_whenNotAscendingAndAddSameValueInMiddle() {
        orderedList.clear(false);
        orderedList.add(1);
        orderedList.add(5);
        orderedList.add(4);
        orderedList.add(4);
        orderedList.add(4);

        assertEquals(5, orderedList.head.value);
        assertEquals(4, orderedList.head.next.value);
        assertEquals(4, orderedList.head.next.next.value);
        assertEquals(4, orderedList.head.next.next.next.value);
        assertEquals(1, orderedList.tail.value);
    }

    // findAscending
    @Test
    public void find_whenAscendingAndEmpty() {
        assertNull(orderedList.find(1));
    }

    @Test
    public void find_whenAscendingAndOneValue() {
        orderedList.add(1);

        assertEquals(1, orderedList.find(1).value);
        assertNull(orderedList.find(2));
    }

    @Test
    public void find_whenAscendingAndSomeValue() {
        orderedList.add(1);
        orderedList.add(2);
        orderedList.add(3);

        assertEquals(3, orderedList.find(3).value);
        assertNull(orderedList.find(4));
        assertNull(orderedList.find(5));
    }

    // findNotAscending
    @Test
    public void find_whenNotAscendingAndEmpty() {
        orderedList.clear(false);
        assertNull(orderedList.find(1));
    }

    @Test
    public void find_whenNotAscendingAndOneValue() {
        orderedList.clear(false);
        orderedList.add(1);

        assertEquals(1, orderedList.find(1).value);
        assertNull(orderedList.find(2));
    }

    @Test
    public void find_whenNotAscendingAndSomeValue() {
        orderedList.clear(false);
        orderedList.add(5);
        orderedList.add(2);
        orderedList.add(1);

        assertEquals(1, orderedList.find(1).value);
        assertEquals(2, orderedList.find(2).value);
        assertNull(orderedList.find(3));
        assertNull(orderedList.find(7));
    }

    // deleteAscending
    @Test
    public void delete_whenAscendingAndEmpty() {
        orderedList.delete(1);
    }

    @Test
    public void delete_whenAscendingAndOneValue() {
        orderedList.add(1);
        orderedList.delete(1);

        assertNull(orderedList.head);
        assertNull(orderedList.tail);
    }

    @Test
    public void delete_whenAscendingAndSomeValueAndDeleteHead() {
        orderedList.add(1);
        orderedList.add(2);
        orderedList.add(3);
        orderedList.delete(1);

        assertEquals(2, orderedList.head.value);
        assertEquals(3, orderedList.tail.value);
    }

    @Test
    public void delete_whenAscendingAndSomeValueAndDeleteTail() {
        orderedList.add(1);
        orderedList.add(2);
        orderedList.add(3);
        orderedList.delete(3);

        assertEquals(1, orderedList.head.value);
        assertEquals(2, orderedList.tail.value);
    }

    @Test
    public void delete_whenAscendingAndSomeValueAndDeleteMiddle() {
        orderedList.add(1);
        orderedList.add(2);
        orderedList.add(3);
        orderedList.delete(2);

        assertEquals(1, orderedList.head.value);
        assertEquals(3, orderedList.tail.value);
        assertEquals(3, orderedList.head.next.value);
        assertEquals(1, orderedList.tail.prev.value);
    }

    @Test
    public void delete_whenAscendingAndSameValueAndDeleteHead() {
        orderedList.add(1);
        orderedList.add(1);
        orderedList.add(2);
        orderedList.add(3);
        orderedList.delete(1);

        assertEquals(1, orderedList.head.value);
        assertEquals(3, orderedList.tail.value);
        assertEquals(2, orderedList.head.next.value);
        assertEquals(2, orderedList.tail.prev.value);
    }

    @Test
    public void delete_whenAscendingAndSameValueAndDeleteTail() {
        orderedList.add(1);
        orderedList.add(2);
        orderedList.add(3);
        orderedList.add(3);
        orderedList.delete(3);

        assertEquals(1, orderedList.head.value);
        assertEquals(3, orderedList.tail.value);
        assertEquals(2, orderedList.head.next.value);
        assertEquals(2, orderedList.tail.prev.value);
    }

    // deleteNotAscending
    @Test
    public void delete_whenNotAscendingAndEmpty() {
        orderedList.clear(false);
        orderedList.delete(1);
    }

    @Test
    public void delete_whenNotAscendingAndOneValue() {
        orderedList.clear(false);
        orderedList.add(1);
        orderedList.delete(1);

        assertNull(orderedList.head);
        assertNull(orderedList.tail);
    }

    @Test
    public void delete_whenNotAscendingAndSomeValueAndDeleteHead() {
        orderedList.clear(false);
        orderedList.add(1);
        orderedList.add(2);
        orderedList.add(3);
        orderedList.delete(3);

        assertEquals(2, orderedList.head.value);
        assertEquals(1, orderedList.tail.value);
    }

    @Test
    public void delete_whenNotAscendingAndSomeValueAndDeleteTail() {
        orderedList.clear(false);
        orderedList.add(1);
        orderedList.add(2);
        orderedList.add(3);
        orderedList.delete(1);

        assertEquals(3, orderedList.head.value);
        assertEquals(23, orderedList.tail.value);
    }

    @Test
    public void delete_whenNotAscendingAndSomeValueAndDeleteMiddle() {
        orderedList.clear(false);
        orderedList.add(1);
        orderedList.add(2);
        orderedList.add(3);
        orderedList.delete(2);

        assertEquals(3, orderedList.head.value);
        assertEquals(1, orderedList.tail.value);
        assertEquals(1, orderedList.head.next.value);
        assertEquals(3, orderedList.tail.prev.value);
    }

    @Test
    public void delete_whenNotAscendingAndSameValueAndDeleteHead() {
        orderedList.clear(false);
        orderedList.add(1);
        orderedList.add(2);
        orderedList.add(3);
        orderedList.add(3);
        orderedList.delete(3);

        assertEquals(3, orderedList.head.value);
        assertEquals(1, orderedList.tail.value);
        assertEquals(2, orderedList.head.next.value);
        assertEquals(2, orderedList.tail.prev.value);
    }

    @Test
    public void delete_whenNotAscendingAndSameValueAndDeleteTail() {
        orderedList.clear(false);
        orderedList.add(1);
        orderedList.add(1);
        orderedList.add(2);
        orderedList.add(3);
        orderedList.delete(1);

        assertEquals(3, orderedList.head.value);
        assertEquals(1, orderedList.tail.value);
        assertEquals(2, orderedList.head.next.value);
        assertEquals(2, orderedList.tail.prev.value);
    }
}