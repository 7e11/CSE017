/**
 * 
 */

/**
 * @author Evan Hruskar
 * @version 2018.03.22
 *
 */
public class SubArray extends SuperArray {
    
    /**
     * 
     */
    private int addCount;

    /**
     * @param arr the object to base on
     */
    public SubArray(Object[] arr) {
        super(arr);
        setAddCount(0);
    }
    
    /**
     * No parameter creation
     */
    public SubArray() {
        super();
        setAddCount(0);
    }

    /**
     * @return the addCount
     */
    public int getAddCount() {
        return addCount;
    }

    /**
     * @param addCount the addCount to set
     */
    public void setAddCount(int addCount) {
        this.addCount = addCount;
    }
    
    /**
     * Insert an object into a SuperArray object.
     * @param anEntry the object to be added
     */
    public void add(Object anEntry) {
        addCount++;
        super.add(anEntry);
    }
    
    /**
     * Insert all the elements of an array into a SuperArray object.
     * @param c the array
     */
    public void addAll(Object[] c) {
        addCount += c.length;
        super.addAll(c);
    }

}
