import student.*;

// -------------------------------------------------------------------------
/**
 *  Unit tests for the {@link Computer} class.
 * 
 *  @author  Author 1's name (pid)
 *  @author  Author 2's name (pid)
 *  @version 2018.01.26
 */
public class ComputerTest
    extends student.TestCase
{
    //~ Instance/static fields ...............................................
    /**
     * Computer object which will be used for testing
     */
    private Computer comp1;

    //~ Constructor ..........................................................

    // ----------------------------------------------------------
    /**
     * Creates a new ComputerTest object.
     */
    public ComputerTest()
    {
       //this is empty because this code came with the 
       //assignemnt and I don't want to delete it.
    }

    //~ Methods ...............................................................
    // ----------------------------------------------------------
    
    /**
     * Sets up the test fixture.
     * Called before every test case method.
     */
    public void setUp()
    {
        /* Insert your own setup code here */
        comp1 = new Computer("AMD", 64, 5.0);
    }
    
    // ----------------------------------------------------------
    /* Insert your own test methods here */
    
    /**
     * 
     */
    public void testGetProcessor() {
        assertEquals("AMD", comp1.getProcessor());
    }
    
    /**
     * 
     */
    public void testSetProcessor() {
        comp1.setProcessor("Intel");
        assertEquals("Intel", comp1.getProcessor());
    }
    
    /**
     * 
     */
    public void testGetNumCores() {
        assertEquals(64, comp1.getNumCores());
    }
    /**
     * 
     */
    public void testSetNumCores() {
        comp1.setNumCores(6);
        assertEquals(6, comp1.getNumCores());
    }
    
    /**
     * 
     */
    public void testGetProcessorSpeed() {
        assertEquals(5.0, comp1.getProcessorSpeed(), 0.01);
        //the 0.01 is precision b/c double
    }
    
    /**
     * 
     */
    public void testSetProcessorSpeed() {
        comp1.setProcessorSpeed(0.5);
        assertEquals(0.5, comp1.getProcessorSpeed(), 0.01); 
    }
    
    /**
     * 
     */
    public void testComputePower() {
        assertEquals(320, comp1.computePower(), 0.01); 
    }
    
    /**
     * 
     */
    public void testToString() {
        assertEquals("AMD, 64 cores at 5.0GHz", comp1.toString());
    }


}