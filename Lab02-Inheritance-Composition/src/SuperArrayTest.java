import org.junit.Before;
import org.junit.Test;
import student.TestCase;

/**
 * 
 */

/**
 * @author Evan Hruskar
 * @version 2018.03.22
 *
 */
public class SuperArrayTest extends TestCase {
    
    private SuperArray sua;

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
        String[] a = { "a", "b", "c", "d" };
        sua = new SuperArray(a);
    }

    /**
     * Test method for {@link SuperArray#add(java.lang.Object)}.
     */
    @Test
    public void testAdd() {
        sua.add("e");
        assertEquals(5, sua.getSize());
        //there isn't a way to access the array directly
        //so I'm using getSize as a proxy check.
    }

    /**
     * Test method for {@link SuperArray#addAll(java.lang.Object[])}.
     */
    @Test
    public void testAddAll() {
        //The original size of sua is 4
        assertEquals(4, sua.getSize());
        String test = "testString";
        sua.add(test);
        //After adding the string test, the size should be 5
        assertEquals(5, sua.getSize());
    }

    /**
     * Test method for {@link SuperArray#getSize()}.
     */
    @Test
    public void testGetSize() {
        assertEquals(4, sua.getSize());
    }

}
