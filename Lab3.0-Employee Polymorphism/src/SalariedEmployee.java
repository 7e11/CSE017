// -------------------------------------------------------------------------
/**
 *  Represents an employee who is paid a yearly salary.
 *
 *  @author  Evan Hruskar
 *  @version 2018.02.02
 */
public class SalariedEmployee extends Employee
{

    
    /**
     * @param name
     * passed to super
     * @param payRate
     * passed to super
     */
    public SalariedEmployee(String name, double payRate) {
        super(name, payRate);
        
    }
    /**
     * no params
     * @return the pay rate multiplied by 1
     */
    public double weeklyPay() {
        return this.getPayRate();
    }
    
    /**
     * @param otherParticipant is the other meeting participant
     * @return "A" is joining "B" in a conference
     */
    public String meetWith(SalariedEmployee otherParticipant) {
        return otherParticipant.getName() + " is joining " 
                + this.getName() + " in a conference";
    }
}