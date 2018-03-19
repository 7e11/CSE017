// -------------------------------------------------------------------------
/**
 *  Represents an employee who is paid an hourly wage.
 *
 *  @author  Evan Hruskar
 *  @version 2018.02.02
 */
public class HourlyEmployee extends Employee
{

    /**
     * @param name
     * given name is immutable and passed to super
     * @param payRate
     * given payRate is immutable and passed to super
     */
    public HourlyEmployee(String name, double payRate) {
        super(name, payRate);
    }

    /**
     * no params
     * @return the pay rate multiplied by 40 hours in a week.
     */
    public double weeklyPay() {
        return 40 * this.getPayRate();
    }
}