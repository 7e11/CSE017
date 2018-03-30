import student.TestCase;

//-------------------------------------------------------------------------
/**
 * Tests for the {@link ListBasedBag} class.
 *
 * @author Evan Hruskar
 * @version 2018.03.30
 */
public class ListBasedBagTest
    extends TestCase
{
    //~ Instance/static variables .............................................

    private ListBasedBag<Book> bag1;
    private Book book1;
    private ListBasedBag<String> bag2;


    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Create a new test class
     */
    public ListBasedBagTest()
    {
        // The constructor is usually empty in unit tests, since it runs
        // once for the whole class, not once for each test method.
        // Per-test initialization should be placed in setUp() instead.
    }


    //~ Public methods ........................................................

    // ----------------------------------------------------------
    /**
     * Creates a brand new, empty bag and a new 6-sided die as the test
     * fixture for each test method.
     */
    public void setUp()
    {
        bag1 = new ListBasedBag<Book>();
        book1 = new Book(
            "Data Structures: Abstraction and Design Using Java",
            "Elliot B. Koffman and Paul A. T. Wolfgang",
            "978-0-470-12870-1");
        bag2 = new ListBasedBag<String>();
    }


    // ----------------------------------------------------------
    /**
     * Test method for {@link ListBasedBag#ListBasedBag()}.
     */
    public void testArrayBag()
    {
        // Check that a new bag is empty

        // Initially, its size should be zero
        assertEquals(0, bag1.size());

        // It shouldn't contain our test die
        assertFalse(bag1.contains(book1));

        // If we try to pull out an element, nothing should come out
        assertNull(bag1.removeRandom());
    }


    // ----------------------------------------------------------
    /**
     * Test method for {@link ListBasedBag#add(java.lang.Object)}.
     */
    public void testAdd()
    {
        //null test
        bag2.add(null);
        assertEquals(0, bag2.size());
        
        bag2.add("Get Out");
        assertEquals(1, bag2.size());
        bag2.add("Moonlight");
        assertEquals(2, bag2.size());
        bag2.add("Panther");
        assertEquals(3, bag2.size());
    }


    // ----------------------------------------------------------
    /**
     * Test method for {@link ListBasedBag#remove(java.lang.Object)}.
     */
    public void testRemove()
    {
        bag2.remove("Not in array");
        assertEquals(0, bag2.size());
        
        bag2.remove(null);
        assertEquals(0, bag2.size());
        
        bag2.add("Get Out");
        assertEquals(1, bag2.size());
        bag2.add("Moonlight");
        assertEquals(2, bag2.size());
        bag2.add("Panther");
        assertEquals(3, bag2.size());
        
        //now test removal
        bag2.remove("Moonlight");
        assertEquals(2, bag2.size());
        assertFalse(bag2.contains("Moonlight"));
        bag2.remove("Panther");
        assertEquals(1, bag2.size());
        assertFalse(bag2.contains("Panther"));
        bag2.remove("Get Out");
        assertEquals(0, bag2.size());
        assertFalse(bag2.contains("Get Out"));
    }


    // ----------------------------------------------------------
    /**
     * Test method for {@link ListBasedBag#removeRandom()}.
     */
    public void testRemoveRandom()
    {
        assertNull(bag2.remove("Not in bag"));
        
        bag2.add("Get Out");
        assertEquals(1, bag2.size());
        bag2.add("Moonlight");
        assertEquals(2, bag2.size());
        bag2.add("Panther");
        assertEquals(3, bag2.size());
        
        //now test removal
        bag2.removeRandom();
        assertEquals(2, bag2.size());
        bag2.removeRandom();
        assertEquals(1, bag2.size());
        bag2.removeRandom();
        assertEquals(0, bag2.size());
        assertFalse(bag2.contains("Get Out"));
    }


    // ----------------------------------------------------------
    /**
     * Test method for {@link ListBasedBag#contains(java.lang.Object)}.
     */
    public void testContains()
    {
        assertFalse(bag2.contains(null));
        assertFalse(bag2.contains("Baron"));
        bag2.add("Baron");
        assertTrue(bag2.contains("Baron"));
    }


    // ----------------------------------------------------------
    /**
     * Test method for {@link ListBasedBag#isEmpty()}.
     */
    public void testIsEmpty()
    {
        assertTrue(bag2.isEmpty());
        bag2.add("Baron");
        assertFalse(bag2.isEmpty());
    }


    // ----------------------------------------------------------
    /**
     * Test method for {@link ListBasedBag#size()}.
     */
    public void testSize()
    {
        assertEquals(0, bag2.size());
        assertEquals(0, bag1.size());
        //the bags have no elements when created
    }


    // ----------------------------------------------------------
    /**
     * Test method for {@link ListBasedBag#toString()}.
     */
    public void testToString()
    {
        assertEquals("{}", bag2.toString());
        
        bag2.add("Get Out");
        bag2.add("Moonlight");
        bag2.add("Panther");
        
        assertEquals("{ Get Out, Moonlight, Panther }", bag2.toString());
    }

}
