
// -------------------------------------------------------------------------
/**
 * Write a one-sentence summary of your class here. Follow it with additional
 * details about its purpose, what abstraction it represents, and how to use it.
 *
 * @author Evan Hruskar
 * @version 2018.02.03
 */
public abstract class Newspaper implements BundledSubscription
{
    private int    idNumber;
    private String title;
    private int    numberCopies;
    private double price;

    /**
     * @param idNumber unique for every newspaper
     * @param title of the paper
     * @param numberCopies of the paper
     * @param price of one copy
     */
    public Newspaper(int idNumber, String title, 
            int numberCopies, double price) {
        this.idNumber = idNumber;
        this.title = title;
        this.numberCopies = numberCopies;
        this.price = price;
    }


    // ----------------------------------------------------------
    /**
     * @return the id_number of the Newspaper
     */
    public int getIdNumber()
    {
        return idNumber;
    }


    // ----------------------------------------------------------
    /**
     * @return the title of the Newspaper
     */
    public String getTitle()
    {
        return title;
    }


    // ----------------------------------------------------------
    /**
     * @return the number_copies of the Newspaper
     */
    public int getNumberCopies()
    {
        return numberCopies;
    }


    // ----------------------------------------------------------
    /**
     * @return the price
     */
    public double getPrice()
    {
        return price;
    }
    
    /**
     * @return the monthly cost of the newspaper
     */
    public abstract double monthlyCost();
    /**
     * @param otherPaper which is bundled with the 1st one
     * @return A and B subscriptions are bundled.
     */
    public String bundledWith(BundledSubscription otherPaper) {
        return this.getTitle() + " and " + otherPaper.getTitle() 
            + " subscriptions are bundled.";
    }
}
