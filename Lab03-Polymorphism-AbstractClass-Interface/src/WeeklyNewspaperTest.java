import student.TestCase;

import org.junit.Before;
import org.junit.Test;

/**
 * 
 */

/**
 * @author Evan Hruskar
 * @version 2018.02.03
 *
 */
public class WeeklyNewspaperTest extends TestCase {

    /**
     * 
     */
    private WeeklyNewspaper a;
    /**
     * 
     */
    private WeeklyNewspaper b;
    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
        a = new WeeklyNewspaper(1, "A", 1, 1.00);
        b = new WeeklyNewspaper(1, "B", 1, 1.00);
    }

    /**
     * Test method for {@link WeeklyNewspaper#monthlyCost()}.
     */
    @Test
    public void testMonthlyCost() {
        assertEquals(4.00, a.monthlyCost(), 1.00);
    }

    /**
     * Test method for {@link WeeklyNewspaper#bundledWith(WeeklyNewspaper)}.
     */
    @Test
    public void testBundledWithWeeklyNewspaper() {
        assertEquals("B subscription is bundled with A.", 
                a.bundledWith(b));
    }

}
