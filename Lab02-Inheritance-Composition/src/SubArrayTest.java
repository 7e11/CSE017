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
public class SubArrayTest extends TestCase {
    
    private SubArray sa;

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
        sa = new SubArray();
    }

    /**
     * Test method for {@link SubArray#add(java.lang.Object)}.
     */
    @Test
    public void testAdd() {
        sa.add(3);
        assertEquals(1, sa.getAddCount());
    }

    /**
     * Test method for {@link SubArray#addAll(java.lang.Object[])}.
     */
    @Test
    public void testAddAll() {
        String [] a = {"a", "b", "c", "d"};
        sa.addAll(a);
        assertEquals(8, sa.getAddCount());
    }

    /**
     * Test method for {@link SubArray#getAddCount()}.
     */
    @Test
    public void testGetAddCount() {
        assertEquals(0, sa.getAddCount());
    }

    /**
     * Test method for {@link SubArray#setAddCount(int)}.
     */
    @Test
    public void testSetAddCount() {
        sa.setAddCount(5);
        assertEquals(5, sa.getAddCount());
    }
    
    /**
     * for the other constructor
     */
    public void testSubArrayObjectArray() {
        String [] a = {"a", "b", "c", "d"};
        SubArray s = new SubArray(a);
        assertNotNull(s);
    }

}
