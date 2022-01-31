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
        assertTrue(palindrome.isPalindrome("A", offByOne));
        assertFalse(palindrome.isPalindrome("Aa", offByOne));
        assertTrue(palindrome.isPalindrome("&", offByOne));
        assertTrue(palindrome.isPalindrome("flake", offByOne));
        /** assertTrue(palindrome.isPalindrome("%&", offByOne)); */
        assertFalse(palindrome.isPalindrome("noon", offByOne));
        assertTrue(offByOne.equalChars('a', 'b'));
        assertFalse(offByOne.equalChars('r', 'Q'));
        assertFalse(offByOne.equalChars('D', 'B'));
        assertTrue(offByOne.equalChars('&', '%'));
    }

    public void main(String[] args) {
        equalCharsTest();
    }
}
