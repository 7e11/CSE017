
/**
 * @author Evan
 * @version 2018.01.26
 */

public class SimpleCalculator {
    private double operand1;
    private double operand2;
    private char operator;
    
    /**
     * @param operand1
     * The first number in the operation
     * @param operand2
     * The second number in the operation
     * @param operator
     * The operation to be applied on the two numbers
     */
    public SimpleCalculator(double operand1, double operand2, char operator) {
        setOperand1(operand1);
        setOperand2(operand2);
        setOperator(operator);
    }
    
    /**
     * @return calculated result
     * This depends on the inputted character.
     */
    public double computeOperation() {
        switch(operator) {
            case '+':   
                return operand1 + operand2;
            case '-':   
                return operand1 - operand2;
            case '*':   
                return operand1 * operand2;
            case '/':   
                return operand1 / operand2;
            default:
                return 0;
        }
    }

    /**
     * @return the operand1
     */
    public double getOperand1() {
        return operand1;
    }

    /**
     * @param operand1 the operand1 to set
     */
    public void setOperand1(double operand1) {
        this.operand1 = operand1;
    }

    /**
     * @return the operand2
     */
    public double getOperand2() {
        return operand2;
    }

    /**
     * @param operand2 the operand2 to set
     */
    public void setOperand2(double operand2) {
        this.operand2 = operand2;
    }

    /**
     * @return the operator
     */
    public char getOperator() {
        return operator;
    }

    /**
     * @param operator the operator to set
     */
    public void setOperator(char operator) {
//        if (operator == '+' || operator == '-' 
//                || operator == '*' || operator == '/') {
//            this.operator = operator;
//        }
        this.operator = operator;
    }
    
    
}
