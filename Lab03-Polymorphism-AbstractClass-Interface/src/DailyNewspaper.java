
// -------------------------------------------------------------------------
/**
 * Write a one-sentence summary of your class here. Follow it with additional
 * details about its purpose, what abstraction it represents, and how to use it.
 *
 * @author Evan Hruskar
 * @version 2018.02.03
 */
public class DailyNewspaper extends Newspaper

{
    // ----------------------------------------------------------
    /**
     * Create a new DailyNewspaper object.
     *
     * @param idNumber unique for each paper
     * @param title of the paper
     * @param numberCopies sold of the paper
     * @param price of one copy
     */
    public DailyNewspaper(int idNumber, String title, 
            int numberCopies, double price) {
        super(idNumber, title, numberCopies, price);
    }

    /**
     * @return the monthly cost of the newspaper
     */
    public double monthlyCost() {
        return 30 * this.getPrice() * this.getNumberCopies();
    }
}
