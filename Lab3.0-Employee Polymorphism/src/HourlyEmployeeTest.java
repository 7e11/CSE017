import student.TestCase;

//-------------------------------------------------------------------------
/**
 *  Test cases for the HourlyEmployee class.
 *
 *  @author  Evan Hruskar
 *  @version 2018.02.02
 */
public class HourlyEmployeeTest extends TestCase
{
    //~ Instance/static fields ...............................................

    private HourlyEmployee emp1;
    private HourlyEmployee emp2;

    //~ Methods ...............................................................

    // ----------------------------------------------------------
    /**
     * Sets up the test fixture.
     * Called before every test case method.
     */
    public void setUp()
    {
        emp1 = new HourlyEmployee("B", 12.5);
        emp2 = new HourlyEmployee("C", 10.5);
    }

    /**
     * 
     */
    public void testWeeklyPay() {
        assertEquals(500.0, emp1.weeklyPay(), 0.01);
    }
    
    /**
     * 
     */
    public void testGetName() {
        assertEquals("B", emp1.getName());
    }
    
    /**
     * 
     */
    public void testGetPayRate() {
        assertEquals(12.5, emp1.getPayRate(), 0.01);
    }
    /**
     * 
     */
    public void testMeetWith() {
        assertEquals("B is meeting with C", emp1.meetWith(emp2));
    }
}
