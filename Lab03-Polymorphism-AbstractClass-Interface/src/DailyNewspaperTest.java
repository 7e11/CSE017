import student.TestCase;

import org.junit.Before;
import org.junit.Test;

/**
 * 
 */

/**
 * @author Evan Hruskar
 * @version 2018.02.03
 */
public class DailyNewspaperTest extends TestCase {
    
    /**
     * 
     */
    private DailyNewspaper a;
    /**
     * 
     */
    private DailyNewspaper b;
    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
        a = new DailyNewspaper(1, "A", 1, 1.00);
        b = new DailyNewspaper(2, "B", 1, 1.00);
    }

    /**
     * Test method for {@link DailyNewspaper#monthlyCost()}.
     */
    @Test
    public void testMonthlyCost() {
        assertEquals(30.0, a.monthlyCost(), 0.01);
    }

    /**
     * Test method for {@link Newspaper#getIdNumber()}.
     */
    @Test
    public void testGetIdNumber() {
        assertEquals(1, a.getIdNumber());
    }

    /**
     * Test method for {@link Newspaper#getTitle()}.
     */
    @Test
    public void testGetTitle() {
        assertEquals("A", a.getTitle());
    }

    /**
     * Test method for {@link Newspaper#getNumberCopies()}.
     */
    @Test
    public void testGetNumberCopies() {
        assertEquals(1, a.getNumberCopies());
    }

    /**
     * Test method for {@link Newspaper#getPrice()}.
     */
    @Test
    public void testGetPrice() {
        assertEquals(1.00, a.getPrice(), 0.01);
    }

    /**
     * Test method for {@link Newspaper#bundledWith(BundledSubscription)}.
     */
    @Test
    public void testBundledWith() {
        assertEquals("A and B subscriptions are bundled.", 
                a.bundledWith(b));
    }

}
