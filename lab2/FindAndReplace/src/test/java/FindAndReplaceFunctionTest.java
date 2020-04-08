import org.junit.Test;

import static org.junit.Assert.*;

public class FindAndReplaceFunctionTest {

    @Test
    public void findAndReplace_GiveRepeatString_ShouldReturnRightString() {
        assertEquals("aaaa", FindAndReplace.findAndReplace("aa", "a", "aa"));
    }

    @Test
    public void findAndReplace_GiveSimpleString_ShouldReturnRightString() {
        assertEquals("ahellof", FindAndReplace.findAndReplace("ayf", "y", "hello"));
    }

    @Test
    public void findAndReplace_GiveStringWithoutSearchString_ShouldReturnStartedString() {
        assertEquals("ayf", FindAndReplace.findAndReplace("ayf", "d", "hello"));
    }
}