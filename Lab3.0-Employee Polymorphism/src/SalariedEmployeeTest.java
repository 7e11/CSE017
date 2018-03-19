import student.TestCase;

//-------------------------------------------------------------------------
/**
 *  Test cases for the SalariedEmployee class.
 *
 *  @author  Evan Hruskar
 *  @version 2018.02.02
 */
public class SalariedEmployeeTest extends TestCase
{
    //~ Instance/static fields ...............................................
    private SalariedEmployee emp1;
    private SalariedEmployee emp2;

    //~ Methods ...............................................................
    
    // ----------------------------------------------------------
    /**
     * Sets up the test fixture.
     * Called before every test case method.
     */
    public void setUp()
    {
        emp1 = new SalariedEmployee("A", 8.5);
        emp2 = new SalariedEmployee("B", 10.3);
    }

    /**
     * 
     */
    public void testWeeklyPay() {
        assertEquals(8.5, emp1.weeklyPay(), 0.01);
    }
    
    /**
     * 
     */
    public void testMeetWith() {
        assertEquals("B is joining A in a conference", 
                emp1.meetWith(emp2));
    }
}
