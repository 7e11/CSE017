/**
 * 
 */

/**
 * @author Evan Hruskar
 * @version 2018.02.03
 *
 */
public interface BundledSubscription {
    /**
     * @return The title of the paper
     */
    public String getTitle();
    /**
     * @param otherPaper which is bundled with the 1st one
     * @return the identity of the other paper
     */
    public String bundledWith(BundledSubscription otherPaper);
}
