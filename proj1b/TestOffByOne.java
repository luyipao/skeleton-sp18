import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TestOffByOne {
    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
    static CharacterComparator offByOne = new OffByOne();
    static Palindrome palindrome = new Palindrome();

    @Test
    public void equalCharsTest() {
        assertFalse(palindrome.isPalindrome("1  3", offByOne));
        assertTrue(palindrome.isPalindrome("1111222", offByOne));
        assertTrue(palindrome.isPalindrome("a", offByOne));
        assertFalse(palindrome.isPalindrome("Aa", offByOne));
        assertTrue(palindrome.isPalindrome("&", offByOne));
        assertTrue(palindrome.isPalindrome("flake", offByOne));
        assertTrue(palindrome.isPalindrome("%&", offByOne));
        assertFalse(palindrome.isPalindrome("noon", offByOne));
    }

    @Test
    public void equalCharsTest1() {
        OffByN obn1 = new OffByN(1);
        assertTrue(palindrome.isPalindrome("acdb", obn1));
    }

    @Test
    public void equalCharsTest2() {
        OffByN obn2 = new OffByN(2);
        assertTrue(palindrome.isPalindrome("abdc", obn2));
    }

    public void main(String[] args) {
        equalCharsTest();
    }
}
