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
public class CompArrayTest extends TestCase {

    private CompArray ca;
    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
        ca = new CompArray();
    }

    /**
     * Test method for {@link CompArray#add(java.lang.Object)}.
     */
    @Test
    public void testAdd() {
        ca.add(3);
        assertEquals(1, ca.getAddCount());
    }

    /**
     * Test method for {@link CompArray#addAll(java.lang.Object[])}.
     */
    @Test
    public void testAddAll() {
        String [] a = {"a", "b", "c", "d"};
        ca.addAll(a);
        assertEquals(4, ca.getAddCount());
    }

    /**
     * Test method for {@link CompArray#getAddCount()}.
     */
    @Test
    public void testGetAddCount() {
        assertEquals(0, ca.getAddCount());
    }
    
    /**
     * for testing the other constructor
     */
    public void testCompArraySuperArray() {
        SuperArray s = new SuperArray();
        CompArray a = new CompArray(s);
        assertNotNull(a);
    }

}
