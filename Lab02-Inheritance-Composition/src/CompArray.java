/**
 * 
 */

/**
 * @author Evan Hruskar
 * @version 2018.03.22
 *
 */
public class CompArray {
    
    private SuperArray s;
    private int addCount;

    /**
     * 
     */
    public CompArray() {
        this.s = new SuperArray();    
        this.addCount = 0;
    }
    
    /**
     * @param s the wrapped superarray
     */
    public CompArray(SuperArray s)
    {
        this.s = s;
    }

    /**
     * @param o the object to add
     */
    public void add(Object o)
    {
        addCount++;
        s.add(o);
    }   

    /**
     * @param c the array to add
     */
    public void addAll(Object[] c)
    {
        addCount += c.length;
        s.addAll(c);
    }


    /**
     * @return count of additions
     */
    public int getAddCount()
    {
        return this.addCount;
    } 

}
