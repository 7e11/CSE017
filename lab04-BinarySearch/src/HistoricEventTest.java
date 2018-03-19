import student.TestCase;

//-------------------------------------------------------------------------
/**
 * Tests for the {@link HistoricEvent} class.
 *
 * @author Evan Hruskar
 * @version 2018.02.20
 */
public class HistoricEventTest
    extends TestCase
{
    //~ Instance/static variables .............................................

    private HistoricEvent event;
    private EventFinder finder = new EventFinder();

    private static final String TITLE = "CS 2114 Lab";
    private static final String MESSAGE =
        "I went to lab today, and I didn't even get a T-shirt.";


    //~ Constructor ...........................................................

    // ----------------------------------------------------------
    /**
     * Create a new test class
     */
    public HistoricEventTest()
    {
        // The constructor is usually empty in unit tests, since it runs
        // once for the whole class, not once for each test method.
        // Per-test initialization should be placed in setUp() instead.
    }


    //~ Public methods ........................................................

    // ----------------------------------------------------------
    /**
     * Starting conditions for all tests in this class.
     */
    public void setUp()
    {
        event = new HistoricEvent(2010, TITLE, MESSAGE);
    }


    // ----------------------------------------------------------
    /**
     * Test the constructor and accessors.
     */
    public void testAccessors()
    {
        assertEquals(2010, event.getYear());
        assertEquals(TITLE, event.getTitle());
        assertEquals(MESSAGE, event.getDescription());
    }


    // ----------------------------------------------------------
    /**
     * Test toString() on the event created in setUp().
     */
    public void testToString()
    {
        assertEquals("[2010] " + TITLE + ": " + MESSAGE, event.toString());
    }


    // ----------------------------------------------------------
    /**
     * Test toString() on an event with a null title.
     */
    public void testToString2()
    {
        event = new HistoricEvent(2010, MESSAGE);
        assertEquals("[2010] " + MESSAGE, event.toString());
    }


    // ----------------------------------------------------------
    /**
     * Test toString() on an event with a null description.
     */
    public void testToString3()
    {
        event = new HistoricEvent(2010, TITLE, null);
        assertEquals("[2010] " + TITLE, event.toString());
    }
    
    /**
     * 
     */
    public void testCompareTo() {
        event = new HistoricEvent(2000, TITLE, MESSAGE);
        HistoricEvent a = new HistoricEvent(2018, TITLE, MESSAGE);
        assertEquals(-18, event.compareTo(a));
        event = new HistoricEvent(2018, "abc", MESSAGE);
        assertEquals(true, event.compareTo(a) > 0);
        event = new HistoricEvent(2018, TITLE, MESSAGE);
        assertEquals(0, event.compareTo(a));
    }
    
    /**
     * `
     */
    public void testFind() {
        //in the eventFinder class
        //test discovery
        event = new HistoricEvent(1622, "William Oughtred",
                "William Oughtred develops slide rules");
        assertEquals(4, finder.find(event, HistoricEvents.TIMELINE));
        
        //test insertion
        event = new HistoricEvent(1620, "William Oughtred",
                "William Oughtred develops slide rules");
        assertEquals(4, finder.find(event, HistoricEvents.TIMELINE));
        
        //test out of bounds, lower
        event = new HistoricEvent(-999, "William Oughtred",
                "William Oughtred develops slide rules");
        assertEquals(0, finder.find(event, HistoricEvents.TIMELINE));
        
        //test out of bounds, upper
        event = new HistoricEvent(9999, "William Oughtred",
                "William Oughtred develops slide rules");
        assertEquals(HistoricEvents.TIMELINE.length, 
                finder.find(event, HistoricEvents.TIMELINE));
        
        //testing an array of size one
        HistoricEvent[] events = {new HistoricEvent(724, 
                "Liang Ling-Can",
                "Liang Ling-Can invents the first fully mechanical clock")};
        //discovery
        event = new HistoricEvent(724, "Liang Ling-Can",
                "Liang Ling-Can invents the first fully mechanical clock");
        assertEquals(0, finder.find(event, events));
        
        //below
        event = new HistoricEvent(33, "Liang Ling-Can",
                "Liang Ling-Can invents the first fully mechanical clock");
        assertEquals(0, finder.find(event, events));
        
        //above
        event = new HistoricEvent(999, "Liang Ling-Can",
                "Liang Ling-Can invents the first fully mechanical clock");
        assertEquals(1, finder.find(event, events));
    }
    
    /**
     * Used for any oddball untested code
     */
    public void testHistoricEvent() {
        //creating a null title.
        //exception code taken from minesweeper
        Exception thrown = null;
        try
        {
            event = new HistoricEvent(33, null,
                    "Liang Ling-Can invents the first fully mechanical clock");
        }
        catch (Exception e)
        {
            thrown = e;
        }
        assertTrue(thrown instanceof IllegalArgumentException);
        
        //creating an instance of HistoricEvents
        HistoricEvents abc = new HistoricEvents();
        assertNotNull(abc);
    }
}
