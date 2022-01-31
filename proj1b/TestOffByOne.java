import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TestOffByOne {
    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
    static CharacterComparator offByOne = new OffByOne();

    @Test
    public void equalCharsTest() {
        assertTrue(offByOne.equalChars('a', 'b'));
        assertFalse(offByOne.equalChars('r', 'Q'));
        assertFalse(offByOne.equalChars('D', 'B'));
        assertTrue(offByOne.equalChars('&', '%'));
    }

    public void main(String[] args) {
        equalCharsTest();
    }
}
