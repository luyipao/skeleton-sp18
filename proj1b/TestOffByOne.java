import org.junit.Test;
import static org.junit.Assert.*;


public class TestOffByOne {
    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
    static CharacterComparator offByOne = new OffByOne();
    static Palindrome palindrome = new Palindrome();

    @Test
    public void equalCharsTest() {
        assertTrue(palindrome.isPalindrome("", offByOne));
        assertTrue(palindrome.isPalindrome("1", offByOne));
        assertTrue(palindrome.isPalindrome("a", offByOne));
        assertTrue(palindrome.isPalindrome("&", offByOne));
        assertTrue(palindrome.isPalindrome("flake", offByOne));
        assertTrue(palindrome.isPalindrome("%&", offByOne));
        assertFalse(palindrome.isPalindrome("noon", offByOne));

    }

    @Test
    public void equalCharsTest1() {
        OffByN obn1 = new OffByN(1);
        assertTrue(palindrome.isPalindrome("acdb", obn1));
        assertTrue(palindrome.isPalindrome("", offByOne));
        assertTrue(palindrome.isPalindrome("1", offByOne));
        assertTrue(palindrome.isPalindrome("a", offByOne));
    }
    @Test
    public void equalCharsTest2() {
        OffByN obn2 = new OffByN(2);
        assertTrue(palindrome.isPalindrome("acfd", obn2));
        assertTrue(palindrome.isPalindrome("", offByOne));
        assertTrue(palindrome.isPalindrome("1", offByOne));
        assertTrue(palindrome.isPalindrome("a", offByOne));

    }
    public void main(String[] args) {
        equalCharsTest();
        equalCharsTest1();
        equalCharsTest2();

    }
}
