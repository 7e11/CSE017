// -------------------------------------------------------------------------
/**
 *  Represents an employee in a company or business.
 *
 *  @author  Evan Hruskar
 *  @version 2018.02.02
 */
public abstract class Employee implements MeetingParticipant
{
    //~ Instance/static fields ................................................

    private String name;        // The employee's name.
    private double payRate;     // The employee's pay rate.


    //~ Constructor ...........................................................
    /**
     * Creates an employee object
     * @param name immutable field
     * @param payRate immutable field
     */
    public Employee(String name, double payRate) {
        this.name = name;
        this.payRate = payRate;
    }

    //~ Methods ...............................................................

    // ----------------------------------------------------------
    /**
     * Gets the employee's name.
     * @return the employee's name
     */
    public String getName()
    {
        return name;
    }


    // ----------------------------------------------------------
    /**
     * Gets the pay rate.
     * @return the pay rate
     */
    public double getPayRate()
    {
        return payRate;
    }
    
    /**
     * @return the weekly pay for an employee
     */
    public abstract double weeklyPay();
    /**
     * Returns a message to announce that this participant is joining the
     * given participant in a meeting.
     * @param otherParticipant the other meeting participant
     * @return a message describing the nature of the meeting
     */
    public String meetWith(MeetingParticipant otherParticipant) {
        return this.getName() + " is meeting with " 
                + otherParticipant.getName();
    }
}
