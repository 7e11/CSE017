import java.util.EmptyStackException;

import student.TestCase;

//-------------------------------------------------------------------------
/**
 * Tests for the {@link LinkedStack} class.
 *
 * @author  Evan Hruskar
 * @version 2018.04.04
 */
public class LinkedStackTest
    extends TestCase
{
    //~ Fields ................................................................

    private LinkedStack<String> stack;

    //~ Public methods ........................................................

    // ----------------------------------------------------------
    /**
     * Creates a brand new, empty stack for each test method.
     */
    public void setUp()
    {
        stack = new LinkedStack<String>();
    }

    /**
     * 
     */
    public void testPush() {
        stack.push("baron");
        assertEquals("baron", stack.peek());
        stack.push("dragon");
        assertEquals("dragon", stack.peek());
    }
    
    /**
     * 
     */
    public void testPop() {
        //pop empty stack
        try {
            stack.pop();
        }
        catch (Exception e) {
            assertTrue(e instanceof EmptyStackException);
        }
        
        stack.push("baron");
        stack.push("rift herald");
        stack.push("dragon");
        
        stack.pop();
        assertEquals("rift herald", stack.peek());
        stack.pop();
        assertEquals("baron", stack.peek());
        
    }
    
    /**
     * 
     */
    public void testPeek() {
        //peek on empty stack
        try {
            stack.peek();
        }
        catch (Exception e) {
            assertTrue(e instanceof EmptyStackException);
        }
        
        stack.push("a");
        assertEquals("a", stack.peek());
    }
    
    /**
     * 
     */
    public void testIsEmpty() {
        assertTrue(stack.isEmpty());
        stack.push("ahri");
        assertFalse(stack.isEmpty());
    }
}
