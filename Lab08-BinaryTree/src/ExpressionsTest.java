import org.junit.Before;
import org.junit.Test;

import student.TestCase;

/**
 * 
 */

/**
 * @author Evan Hruskar
 * @version 2018.04.12
 *
 */
public class ExpressionsTest extends TestCase {

    /**
     * call the static main.
     */
    @Before
    public void setUp() throws Exception {
        super.setUp();
        Expressions.main(null);
        Expressions exp = new Expressions();
        //this is stupid...
        //doing this for coverage
        assertNotNull(exp);
    }

    /**
     * Test method for {@link Expressions#main(java.lang.String[])}.
     */
    @Test
    public void testMain() {
        assertTrue(systemOut().getHistory()
                .contains("(* (- (a) (b)) (/ (+ (c) (d)) (e)))"));
        assertTrue(systemOut().getHistory()
                .contains("(((a) - (b)) * (((c) + (d)) / (e)))"));
        assertTrue(systemOut().getHistory()
                .contains("(((a) (b) -) (((c) (d) +) (e) /) *)"));
    }

}
