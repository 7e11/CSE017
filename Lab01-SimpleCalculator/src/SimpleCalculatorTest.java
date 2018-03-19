import org.junit.Before;
import org.junit.Test;
import student.*;
/**
 * 
 */

/**
 * @author Evan
 * @version 2018.01.26
 */
public class SimpleCalculatorTest extends student.TestCase {

    /**
     * 
     */
    private SimpleCalculator calc;
    
    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
        calc = new SimpleCalculator(2.0, 4.0, '*');
    }


    /**
     * Test method for {@link SimpleCalculator#computeOperation()}.
     */
    @Test
    public void testComputeOperation() {
        calc.setOperator('+');
        assertEquals(6.0, calc.computeOperation(), 0.01);
        calc.setOperator('-');
        assertEquals(-2.0, calc.computeOperation(), 0.01);
        calc.setOperator('*');
        assertEquals(8.0, calc.computeOperation(), 0.01);
        calc.setOperator('/');
        assertEquals(0.5, calc.computeOperation(), 0.01);
        calc.setOperator('f');
        assertEquals(0, calc.computeOperation(), 0.01);
    }

    /**
     * Test method for {@link SimpleCalculator#getOperand1()}.
     */
    @Test
    public void testGetOperand1() {
        assertEquals(2.0, calc.getOperand1(), 0.01);
    }

    /**
     * Test method for {@link SimpleCalculator#setOperand1(double)}.
     */
    @Test
    public void testSetOperand1() {
        calc.setOperand1(3.0);
        assertEquals(3.0, calc.getOperand1(), 0.01);
    }

    /**
     * Test method for {@link SimpleCalculator#getOperand2()}.
     */
    @Test
    public void testGetOperand2() {
        assertEquals(4.0, calc.getOperand2(), 0.01);
    }

    /**
     * Test method for {@link SimpleCalculator#setOperand2(double)}.
     */
    @Test
    public void testSetOperand2() {
        calc.setOperand2(5.0);
        assertEquals(5.0, calc.getOperand2(), 0.01);
    }

    /**
     * Test method for {@link SimpleCalculator#getOperator()}.
     */
    @Test
    public void testGetOperator() {
        assertEquals('*', calc.getOperator());    }

    /**
     * Test method for {@link SimpleCalculator#setOperator(char)}.
     */
    @Test
    public void testSetOperator() {
        calc.setOperator('-');
        assertEquals('-', calc.getOperator());
    }

}
