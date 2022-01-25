public class ArrayDequeTest {
    public static boolean checkEmpty(boolean expect, boolean actual) {
        if (expect != actual) {
            System.out.println("expect : " + expect + ", but get " + actual);
            return false;
        }
        return true;
    }
    public static boolean checkSize(int expected, int actual) {
        if (expected != actual) {
            System.out.println("size() returned " + actual + ", but expected: " + expected);
            return false;
        }
        return true;
    }
    public static void printTestStatus(boolean passed) {
        if (passed) {
            System.out.println("Test passed!\n");
        } else {
            System.out.println("Test failed!\n");
        }
    }
    public static void addIsEmptySizeTest() {
        System.out.println("Running add/isEmpty/Size test.");

        ArrayDeque<String> lld1 = new ArrayDeque<>();

        boolean passed = checkEmpty(true, lld1.isEmpty());

        lld1.addFirst("front");

        // The && operator is the same as "and" in Python.
        // It's a binary operator that returns true if both arguments true, and false otherwise.
        passed = checkSize(1, lld1.size()) && passed;
        passed = checkEmpty(false, lld1.isEmpty()) && passed;

        lld1.addLast("middle");
        passed = checkSize(2, lld1.size()) && passed;

        lld1.addLast("back");
        passed = checkSize(3, lld1.size()) && passed;

        System.out.println("Printing out deque: ");
        lld1.printDeque();

        printTestStatus(passed);
    }
    public static void addRemoveTest() {

        System.out.println("Running add/remove test.");

        ArrayDeque<Integer> lld1 = new ArrayDeque<>();
        // should be empty
        boolean passed = checkEmpty(true, lld1.isEmpty());

        lld1.addFirst(10);
        // should not be empty
        passed = checkEmpty(false, lld1.isEmpty()) && passed;

        lld1.removeFirst();
        // should be empty
        passed = checkEmpty(true, lld1.isEmpty()) && passed;

        printTestStatus(passed);

    }
    public static void addRemoveLastTest()
    {
        int a;
        System.out.println("running addLast/removeLast test.");
        ArrayDeque<Integer> ArrayDeque = new ArrayDeque<>();
        ArrayDeque.addFirst(0);
        ArrayDeque.addLast(1);
        ArrayDeque.addFirst(2);
        ArrayDeque.addFirst(3);
        ArrayDeque.addFirst(4);
        ArrayDeque.get(4)      ;
        ArrayDeque.get(0)      ;
        ArrayDeque.addLast(7) ;
    ArrayDeque.get(3)      ;
        a=ArrayDeque.get(1)     ;
        ArrayDeque.addFirst(10);
        a=ArrayDeque.removeFirst()    ;
        ArrayDeque.addLast(12);
        ArrayDeque.addLast(13);
        a=ArrayDeque.removeLast()  ;
        a = ArrayDeque.removeFirst();
        a= ArrayDeque.get(2);
        a = ArrayDeque.removeFirst();
        ArrayDeque.addLast(18);
        a = ArrayDeque.removeFirst();
        a = ArrayDeque.removeFirst() ;
        a = ArrayDeque.removeFirst();
        a = ArrayDeque.removeLast();
    }
    public static void addremovetest()
    {
        int a;
        ArrayDeque<Integer> l = new ArrayDeque<>();
        for(int i = 0; i < 16; i++) {
            l.addLast(i);
            a = l.get(0);
        }

        System.out.println(l.get(15));

     }

    public static void main(String[] args) {
        System.out.println("Running tests.\n");
        addIsEmptySizeTest();
        addRemoveTest();
        addRemoveLastTest();
        addremovetest();
    }
}
