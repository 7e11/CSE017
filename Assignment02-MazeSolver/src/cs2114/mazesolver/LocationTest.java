/**
 * 
 */
package cs2114.mazesolver;

import org.junit.Before;
import org.junit.Test;

import student.TestCase;

/**
 * @author Evan Hruskar
 * @version 2018.04.05
 *
 */
public class LocationTest extends TestCase {

    private Location loc1;
    private Location loc2;
    /**
     * @see student.TestCase#setUp()
     */
    @Before
    public void setUp() throws Exception {
        loc1 = new Location(0, 0);
        loc2 = new Location(1, 1);
    }

    /**
     * Test method for {@link cs2114.mazesolver.Location#Location(int, int)}.
     */
    @Test
    public void testLocation() {
        loc1 = new Location(0, 0);
        assertNotNull(loc1);
        //kind of redundant
    }

    /**
     * Test method for {@link cs2114.mazesolver.Location#x()}.
     */
    @Test
    public void testX() {
        assertEquals(0, loc1.x());
        assertEquals(1, loc2.x());
    }

    /**
     * Test method for {@link cs2114.mazesolver.Location#y()}.
     */
    @Test
    public void testY() {
        assertEquals(0, loc1.y());
        assertEquals(1, loc2.y());
    }

    /**
     * Test method for {@link cs2114.mazesolver.Location#north()}.
     */
    @Test
    public void testNorth() {
        Location loc3 = (Location) loc1.north();
        //its originally an ILocation
        assertEquals(0, loc3.x());
        assertEquals(-1, loc3.y());
    }

    /**
     * Test method for {@link cs2114.mazesolver.Location#south()}.
     */
    @Test
    public void testSouth() {
        Location loc3 = (Location) loc1.south();
        //its originally an ILocation
        assertEquals(0, loc3.x());
        assertEquals(1, loc3.y());
    }

    /**
     * Test method for {@link cs2114.mazesolver.Location#west()}.
     */
    @Test
    public void testWest() {
        Location loc3 = (Location) loc1.west();
        //its originally an ILocation
        assertEquals(-1, loc3.x());
        assertEquals(0, loc3.y());
    }

    /**
     * Test method for {@link cs2114.mazesolver.Location#east()}.
     */
    @Test
    public void testEast() {
        Location loc3 = (Location) loc1.east();
        //its originally an ILocation
        assertEquals(1, loc3.x());
        assertEquals(0, loc3.y());
    }

    /**
     * Test method for 
     * {@link cs2114.mazesolver.Location#equals(java.lang.Object)}.
     */
    @Test
    public void testEqualsObject() {
        Location locNull = null;
        assertFalse(loc1.equals(locNull));
        assertFalse(loc1.equals(123));
        assertFalse(loc1.equals(loc2));
        Location loc3 = new Location(0, 0);
        assertTrue(loc1.equals(loc3));
        
    }

    /**
     * Test method for {@link cs2114.mazesolver.Location#toString()}.
     */
    @Test
    public void testToString() {
        assertEquals("(0, 0)", loc1.toString());
        assertEquals("(1, 1)", loc2.toString());
    }

}
