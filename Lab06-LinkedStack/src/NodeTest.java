import student.TestCase;

//-------------------------------------------------------------------------
/**
 * Tests for the {@link Node} class.
 *
 * @author Evan Hruskar
 * @version 2018.04.04
 */
public class NodeTest
    extends TestCase
{
    //~ Fields ................................................................

    // TODO: Depending on how you test, you might need more, or fewer, of
    // these.
    private Node<String> node1;
    private Node<String> node2;
    private Node<String> node3;

    //~ Public methods ........................................................

    // ----------------------------------------------------------
    /**
     * Create some new nodes for each test method.
     */
    public void setUp()
    {
        node1 = new Node<String>("node1");
        node2 = new Node<String>("node2");
        node3 = new Node<String>("node3");
    }

    /**
     * 
     */
    public void testJoin() {
        //checking the null exception code
        node1.join(null);
        assertEquals(null, node1.next());
        
        //now for the normal stuff
        node1.join(node2);
        assertEquals(node2, node1.next());
        assertEquals(node1, node2.previous());
        
        //next is not null
        try {
            node1.join(node3);
        }
        catch (Exception e) {
            assertTrue(e instanceof IllegalStateException);
        }
        
        //previous is not null
        try {
            node3.join(node2);
        }
        catch (Exception e) {
            assertTrue(e instanceof IllegalStateException);
        }
    }
    
    /**
     * 
     */
    public void testSplit() {
        node1.join(node2);
        node1.split();
        assertEquals(null, node1.next());
        assertEquals(null, node2.previous());
        
        //now try with a null node
        node3.split();
        assertEquals(null, node3.next());
    }
    
    /**
     * 
     */
    public void testData() {
        assertEquals("node1", node1.data());
    }
    
    /**
     * 
     */
    public void testSetData() {
        node1.setData("baron");
        assertEquals("baron", node1.data());
    }
}
