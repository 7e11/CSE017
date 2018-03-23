import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

import student.TestCase;

/**
 * 
 */

/**
 * @author Evan Hruskar
 * @version 2018.03.22
 *
 */
public class StudentTest extends TestCase {

    private Student d;
    private Student b;
    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
        d = new Student("dragon", 1000, 1.00);
        b = new Student("baron", 3000, 20.00);
    }

    /**
     * Test method for {@link Student#compareTo(Student)}.
     * A lexicographic implemenation didn't change the error.
     * I'll try using the pure java comparison operators.
     */
    @Test
    public void testCompareTo() {
        assertTrue(b.compareTo(d) > 0);
        //recall, double field is casted to int
        b = new Student("baron", 50, 1.00);
        assertTrue(b.compareTo(d) < 0);
        b = new Student("baron", 1000, 1.00);
        assertEquals(-2, b.compareTo(d));
        //assertEquals(-1, b.compareTo(d));
        assertEquals(0, b.compareTo(b));
    }

    /**
     * Test method for {@link Student#studentOrder()}.
     */
    @Test
    public void testStudentOrder() {
        Student r = new Student("rift herald", 2000, 9.30);
        Student[] obj = {d, b, r};
        Arrays.sort(obj, Student.studentOrder());
        assertEquals(d, obj[0]);
        assertEquals(b, obj[2]);
    }

    /**
     * Test method for {@link Student#isInDeansList()}.
     */
    @Test
    public void testIsInDeansList() {
        assertEquals(true, b.isInDeansList());
        try {
            d.isInDeansList();
        } 
        catch (Exception e) {
            assertTrue(e instanceof NotInDeansListException);
        }
        
        try {
            d = new Student("dragon", 30, -5.0);
            d.isInDeansList();
        } 
        catch (Exception e) {
            assertTrue(e instanceof NotInDeansListException);
        }
    }

    /**
     * Test method for {@link Student#isInAcademicProbation()}.
     */
    @Test
    public void testIsInAcademicProbation() {
        assertEquals(true, d.isInAcademicProbation());
        try {
            b.isInAcademicProbation();
        } 
        catch (Exception e) {
            assertTrue(e instanceof NotInAcademicProbationException);
        }
        //now without a message
        try {
            b = new Student("baron", 10, 5.00);
            b.isInAcademicProbation();
        } 
        catch (Exception e) {
            assertTrue(e instanceof NotInAcademicProbationException);
        }
    }

    /**
     * Test method for {@link Student#getName()}.
     */
    @Test
    public void testGetName() {
        assertEquals("dragon", d.getName());
    }

    /**
     * Test method for {@link Student#setName(java.lang.String)}.
     */
    @Test
    public void testSetName() {
        d.setName("infernal");
        assertEquals("infernal", d.getName());
    }

    /**
     * Test method for {@link Student#getId()}.
     */
    @Test
    public void testGetId() {
        assertEquals(1000, d.getId());
    }

    /**
     * Test method for {@link Student#setId(int)}.
     */
    @Test
    public void testSetId() {
        d.setId(5);
        assertEquals(5, d.getId());
    }

    /**
     * Test method for {@link Student#getGpa()}.
     */
    @Test
    public void testGetGpa() {
        assertEquals(20.00, b.getGpa(), 0.01);
    }

    /**
     * Test method for {@link Student#setGpa(double)}.
     */
    @Test
    public void testSetGpa() {
        d.setGpa(2.0);
        assertEquals(2.0, d.getGpa(), 0.01);
    }

}
