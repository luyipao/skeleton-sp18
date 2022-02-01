import static org.junit.Assert.*;
import org.junit.Test;

public class TestArrayDequeGold {
    @Test
    public void empty_sizeSADTest() {
        StudentArrayDeque<Integer> sad1 = new StudentArrayDeque<>();
        assertTrue(sad1.isEmpty());
        assertEquals(true, sad1.size() == 0);
        sad1.addFirst(StdRandom.uniform(10));
        assertFalse(sad1.isEmpty());
        assertEquals(true, sad1.size() == 1);
        sad1.removeFirst();//something is wrong
        assertTrue(sad1.isEmpty());
        assertEquals(true, sad1.size() == 0);
        sad1.addLast(StdRandom.uniform(10));//something is wrong
        assertFalse(sad1.isEmpty());
        assertEquals(true, sad1.size() == 1);
        sad1.removeLast();
        assertTrue(sad1.isEmpty());
        assertEquals(true, sad1.size() == 0);
    }

    @Test
    public void add_removeSADTest() {
        StudentArrayDeque<Integer> sad2 = new StudentArrayDeque<>();
        Integer x;
        for (int i = 0; i < 10; i += 1) {
            double numberBetweenZeroAndOne = StdRandom.uniform(10);

            if (numberBetweenZeroAndOne < 5) {
                sad2.addFirst(i);
            } else {
                sad2.addLast(i);
            }
        }
        do {
            x = sad2.removeLast();
        } while (x >= 5);
        for(int i = 0; i < sad2.size(); i ++) {
            assertTrue("removeLast()",(sad2.get(i) == null || sad2.get(i) < 5));
        }
    }
/**
    @Test
    public void add_removeADSTest() {
        ArrayDequeSolution<Integer> ads1 = /*ArrayDequeSolution();
        for (int i = 0; i < 10; i += 1) {
            double numberBetweenZeroAndOne = StdRandom.uniform(100);

            if (numberBetweenZeroAndOne < 50) {
                sad2.addFirst(i);
            } else {
                sad2.addLast(i);
            }
        }
        for (int i = 0; i < 5; i++) {
            assertTrue(sad2.get(i) < 50);
            sad3.removeLast();
        }
        assertTrue(sad3.size() == 5);
    }
    */
    public void main(String[] args) {
        empty_sizeSADTest();
        add_removeSADTest();
    }
}
