import student.TestCase;

// -------------------------------------------------------------------------
/**
 * Test cases for the Levenshtein distance algorithm.
 *
 * @author Evan Hruskar
 * @version 2018.02.28
 */
public class LevenshteinTests
    extends TestCase
{
    /**
     * Levenshtein object for testing.
     */
    private Levenshtein lev;
    /**
     * Just used for simple cases.
     */
    public void testSimple() {
        lev = new Levenshtein("clap", "cram");
        assertEquals(2, lev.distance());
        lev = new Levenshtein("mitt", "smitten");
        assertEquals(3, lev.distance());
        lev = new Levenshtein("start", "cart");
        assertEquals(2, lev.distance());
    }
    
    /**
     * The one complicated case.
     */
    public void testComplex() {
        lev = new Levenshtein("this is a long sentence", 
                "this sentence is long");
        assertEquals(15, lev.distance());
        
    }
}
