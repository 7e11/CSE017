/**
 * 
 */
package cs2114.mazesolver;

/**
 * @author Evan Hruskar
 * @version 2018.04.05
 *
 */
public class Location implements ILocation {
    private int x;
    private int y;
    
    /**
     * @param x the x value
     * @param y the y value
     * 
     */
    public Location(int x, int y) {
        this.x = x;
        this.y = y;
    }

    //~ Public methods ........................................................

    // ----------------------------------------------------------
    /**
     * Gets the x-coordinate of the location.
     *
     * @return the x-coordinate of the location
     */
    public int x() {
        return x;
    }


    // ----------------------------------------------------------
    /**
     * Gets the y-coordinate of the location.
     *
     * @return the y-coordinate of the location
     */
    public int y() {
        return y;
    }


    // ----------------------------------------------------------
    /**
     * <p>
     * Gets a new location that represents the (x, y) coordinates one cell
     * north of this location.
     * </p><p>
     * This method should not perform any bounds checking, because locations
     * are simply (x, y) pairs. If {@code north()} is called on a location
     * representing (0, 0), then the result should be (0, -1).
     * </p>
     *
     * @return a new location representing the (x, y) coordinates one cell
     *     north of this location
     */
    public ILocation north() {
        return new Location(x, y - 1);
    }


    // ----------------------------------------------------------
    /**
     * <p>
     * Gets a new location that represents the (x, y) coordinates one cell
     * south of this location.
     * </p><p>
     * This method should not perform any bounds checking, because locations
     * are simply (x, y) pairs.
     * </p>
     *
     * @return a new location representing the (x, y) coordinates one cell
     *     south of this location
     */
    public ILocation south() {
        return new Location(x, y + 1);
    }


    // ----------------------------------------------------------
    /**
     * <p>
     * Gets a new location that represents the (x, y) coordinates one cell
     * west of this location.
     * </p><p>
     * This method should not perform any bounds checking, because locations
     * are simply (x, y) pairs. If {@code west()} is called on a location
     * representing (0, 0), then the result should be (-1, 0).
     * </p>
     *
     * @return a new location representing the (x, y) coordinates one cell
     *     west of this location
     */
    public ILocation west() {
        return new Location(x - 1, y);
    }


    // ----------------------------------------------------------
    /**
     * <p>
     * Gets a new location that represents the (x, y) coordinates one cell
     * east of this location.
     * </p><p>
     * This method should not perform any bounds checking, because locations
     * are simply (x, y) pairs.
     * </p>
     *
     * @return a new location representing the (x, y) coordinates one cell
     *     east of this location
     */
    public ILocation east() {
        return new Location(x + 1, y);
    }
    
    /**
     * @param o the object to check equality with
     * @return boolean if it is equal or not.
     */
    public boolean equals(Object o) {
        //true if the object is another location with same x,y
        //false otherwise (handle null, different object, etc..)
        if (o != null) {
            if (o instanceof Location) {
                Location loc = (Location) o;
                if (x == loc.x && y == loc.y) {
                    //they're the same class. This works
                    return true;
                }
            }
        }
        return false;
    }
    
    /**
     * @return the string formatted as such (x,y)
     */
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
    
}
