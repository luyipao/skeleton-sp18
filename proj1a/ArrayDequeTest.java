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
        System.out.println("running addLast/removeLast test.");
        ArrayDeque<Integer> lld2 = new ArrayDeque<>();
        boolean pased = checkEmpty(true, lld2.isEmpty());

        lld2.addFirst(0);
        lld2.addFirst(1);
        System.out.println(lld2.removeLast());
        System.out.println(lld2.removeLast());
        if(lld2.isEmpty())
            System.out.println("empty");
        lld2.addFirst(5);
        System.out.println(lld2.removeLast());
    }
    public static void main(String[] args) {
        System.out.println("Running tests.\n");
        addIsEmptySizeTest();
        addRemoveTest();
        addRemoveLastTest();
    }
}
