import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.*;
/**
 * 
 */

/**
 * @author Evan Hruskar
 * @version 2018.04.03
 *
 */
class LinkedListTest {

    private LinkedList<String> list;
    
    /**
     * @throws java.lang.Exception
     */
    @BeforeEach
    void setUp() throws Exception {
        list = new LinkedList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        //<> is same as <String>
    }

    /**
     * Test method for {@link LinkedList#add(java.lang.Object)}.
     */
    @Test
    void testAdd() {
        list.add("d");
        assertTrue(list.contains("d"));
    }

    /**
     * Test method for {@link LinkedList#contains(java.lang.Object)}.
     */
    @Test
    void testContains() {
        assertTrue(list.contains("a"));
        assertTrue(!list.contains("z"));
    }

    /**
     * Test method for {@link LinkedList#clean()}.
     */
    @Test
    void testClean() {
        list.clean();
        assertTrue(!list.contains("a"));
    }
    @Test
    void testToString() {
        assertEquals("abc", list.toString());
    }

}
