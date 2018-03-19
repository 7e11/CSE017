/**
 * 
 */

/**
 * @author Evan Hruskar
 * @version 2018.02.20
 *
 */
public class EventFinder {
    /**
     * @param target what we're searching for
     * @param list what we're searching in
     * @return the position, or where it should be.
     * This is the wrapper method.
     */
    public int find(HistoricEvent target, HistoricEvent[] list) {
        return find(target, list, 0, list.length);
    }
    
    /**
     * @param target what we're searching for
     * @param list what we're searching in
     * @param start the start index
     * @param end the end index (exclusive)
     * @return the position of the found target OR:
     * Where the target should be inserted to be ordered.
     */
    public int find(HistoricEvent target, HistoricEvent[] list, 
            int start, int end) {
        //exclusive of ending index. (just abuse int casting)
        int index = (start + end) / 2;
        if (start == end) {
            return start;
        }
        int comparison = target.compareTo(list[index]);
        if (comparison == 0) {
            return index;
        }
        
        if (comparison > 0) {
            return find(target, list, index + 1, end);
        }
        //comparison < 0
        return find(target, list, start, index);
        
    }
}
