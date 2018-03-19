import java.util.HashMap;

//-------------------------------------------------------------------------
/**
 * An implementation of the Levenshtein distance algorithm.
 *
 * @author  Evan Hruskar
 * @version 2018.02.28
 */
public class Levenshtein
{
    //~ Fields ..........................................................
    private String s1;
    private String s2;
    
    /**
     * a map to contain previous tests.
     */
    private HashMap<String, Integer> map;
    
    /**
     * @param s1 the first string
     * @param s2 the second string
     */
    //~ Constructors ....................................................
    public Levenshtein(String s1, String s2) {
        this.s1 = s1;
        this.s2 = s2;
        map = new HashMap<String, Integer>();
    }


    /**
     * @return the levenshtein distance between 2 strings
     */
    //~ Methods .........................................................
    public int distance() {
        //String key = "0," + s1.length() + ",0," + s2.length();
        return compute(0, s1.length(), 0, s2.length());
    }
    /**
     * @return the levenshtein distance between 2 strings
     */
    private int compute(int s1Start, int s1subLength, 
                        int s2Start, int s2subLength) {
        //hash check first.
        //use "" to start appending to string.
        String key = "" + s1Start + "," 
                        + s1subLength + "," 
                        + s2Start + "," 
                        + s2subLength;
        if (map.containsKey(key)) {
            return map.get(key);
        }
        
        //both empty
        if (s1subLength == 0 && s2subLength == 0) {
            return 0;
        }
        //first string empty, second one not
        if (s1subLength == 0) {
            return s2subLength;
        }
        //first one not, second one empty
        if (s2subLength == 0) {
            return s1subLength;
        }
        
        
        //super gross...
        int result = Math.min(1 + compute(s1Start + 1, s1subLength - 1, 
                s2Start, s2subLength),
                Math.min(1 + compute(s1Start, s1subLength, 
                        s2Start + 1, s2subLength - 1), 
                        (s1.charAt(s1Start) == (s2.charAt(s2Start)) ? 0 : 1) + 
                        compute(s1Start + 1, s1subLength - 1, 
                                s2Start + 1, s2subLength - 1)));
        //now put into the map
        map.put(key, result);
        return result;
    }
}
