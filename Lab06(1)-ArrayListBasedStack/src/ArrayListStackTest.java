import student.TestCase;
import java.util.EmptyStackException;

//-------------------------------------------------------------------------
/**
 * Tests for the {@link ArrayListStack} class.
 *
 * @author Evan Hruskar
 * @version 2018.03.30
 */
public class ArrayListStackTest
    extends TestCase
{
    //~ Instance/static variables .............................................

    private ArrayListStack<String> stack;


    //~ Public methods ........................................................

    // ----------------------------------------------------------
    /**
     * Creates a brand new, empty stack for each test method.
     */
    public void setUp()
    {
        stack = new ArrayListStack<String>();
    }


    /**
     * 
     */
    public void testPush() {
        stack.push("abc");
        assertEquals("abc", stack.top());
    }
    
    /**
     * 
     */
    public void testPop( ) {
        try {
            stack.pop();
        }
        catch (Exception e) {
            assertTrue(e instanceof EmptyStackException);
        }
        
        stack.push("abc");
        stack.push("def");
        assertEquals("def", stack.top());
        stack.pop();
        assertEquals("abc", stack.top());
    }
    
    /**
     * 
     */
    public void testTop() {
        try {
            stack.top();
        }
        catch (Exception e) {
            assertTrue(e instanceof EmptyStackException);
        }
        
        stack.push("abc");
        assertEquals("abc", stack.top());
        stack.push("def");
        assertEquals("def", stack.top());
        stack.pop();
        assertEquals("abc", stack.top());
    }
    
    /**
     * 
     */
    public void testSize() {
        assertEquals(0, stack.size());
        stack.push("abc");
        assertEquals(1, stack.size());
        stack.push("abc");
        assertEquals(2, stack.size());
        stack.pop();
        assertEquals(1, stack.size());
    }
    
    /**
     * 
     */
    public void testIsEmpty() {
        assertTrue(stack.isEmpty());
        stack.push("abc");
        assertFalse(stack.isEmpty());
        stack.pop();
        assertTrue(stack.isEmpty());
    }
}
