import static org.junit.Assert.*;

import org.junit.Test;

public class FlikTest {
    public static void main(String[] args) {
        int i = 128;
        int j = 128;
        assertTrue("Filk is wrong at " + i, Flik.isSameNumber(i, 127));
        assertTrue("Filk is wrong at " + i, Flik.isSameNumber(i, null));
    }
}
