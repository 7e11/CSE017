/**
 * 
 */
package cs2114.mazesolver;
import java.util.Stack;

/**
 * @author Evan Hruskar
 * @version 2018.04.05
 *
 */
public class Maze implements IMaze {
    //I was going to use an arraylist but an array should be fine.
    private MazeCell[][] board;
    private int size;
    private Location startLocation;
    private Location goalLocation;
    
    /**
     * @param size one dimension size of the array
     * 
     */
    public Maze(int size) {
        this.size = size;
        startLocation = new Location(0, 0);
        goalLocation = new Location(size - 1, size - 1);
        board = new MazeCell[size][size];
        
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                board[i][j] = MazeCell.UNEXPLORED;
            }
        }
    }

    /**
     * Gets the size of the board. Since boards are square
     * is the number of cells in either dimension (width or height).
     *
     * @return the size of the board
     */
    public int size() {
        return size;
    }


    // ----------------------------------------------------------
    /**
     * Gets the starting location of the board.
     *
     * @return the starting location in the board
     */
    public ILocation getStartLocation() {
        return startLocation;
    }


    // ----------------------------------------------------------
    /**
     * <p>
     * Sets the starting location in the board.
     * </p><p>
     * This method must check to see if there is a wall at the desired new
     * location for the starting point. If there is, you must destroy the wall.
     * </p>
     *
     * @param location the new starting location in the board
     */
    public void setStartLocation(ILocation location) {
        if (getCell(location) == MazeCell.INVALID_CELL) {
            return;
        }
        if (getCell(location) == MazeCell.WALL) {
            setCell(location, MazeCell.UNEXPLORED);
            //destroying the wall
        }
        startLocation = (Location) location;
    }


    // ----------------------------------------------------------
    /**
     * Gets the location of the goal in the board.
     *
     * @return the location of the goal in the board
     */
    public ILocation getGoalLocation() {
        return goalLocation;
    }


    // ----------------------------------------------------------
    /**
     * <p>
     * Sets the location of the goal in the board.
     * </p><p>
     * This method must check to see if there is a wall at the desired new
     * location for the goal. If there is, you must destroy the wall.
     * </p>
     *
     * @param location the new location of the goal in the board
     */
    public void setGoalLocation(ILocation location) {
        if (getCell(location) == MazeCell.INVALID_CELL) {
            return;
        }
        if (getCell(location) == MazeCell.WALL) {
            setCell(location, MazeCell.UNEXPLORED);
            //destroying the wall
            //again, cannot use locCell, it's a copy not a ref.
        }
        goalLocation = (Location) location;
    }


    // ----------------------------------------------------------
    /**
     * Gets the type of cell at the specified location in the board. If the
     * location is outside the bounds of the board, then you must return
     * {@link MazeCell#INVALID_CELL}. Under no circumstances should this method
     * ever throw an exception.
     *
     * @param location the location to check
     * @return a value from the {@link MazeCell} enumerated type that indicates
     *     the type of cell at that location
     */
    public MazeCell getCell(ILocation location) {
        if (location.x() < 0 || location.x() >= size || 
                location.y() < 0 || location.y() >= size) {
            return MazeCell.INVALID_CELL;
        }
        //think column then row, so x then y
        return board[location.x()][location.y()];
    }


    // ----------------------------------------------------------
    /**
     * <p>
     * Sets a location in the board to be the specified cell type.
     * </p><p>
     * There is one special condition that this method must check for: if the
     * cell type is {@link MazeCell#WALL} and the location is either the
     * starting location or the goal location, then this method must
     * <strong>ignore the request and change nothing.</strong>
     * </p><p>
     * Under no circumstances should this method throw an exception,
     * {@code IndexOutOfBounds} or otherwise. If the location given is outside
     * the bounds of the board, then do nothing.
     * </p>
     *
     * @param location the location where the wall should be placed
     * @param cell the cell in question
     */
    public void setCell(ILocation location, MazeCell cell) {
        MazeCell locCell = getCell(location);
        if (locCell == MazeCell.INVALID_CELL) {
            return;
        }
        if (cell == MazeCell.WALL && 
                (startLocation.equals(location) || 
                goalLocation.equals(location))) {
            //fixed an operator precedence issue
            return;
        }
        board[location.x()][location.y()] = cell;
        //fixed. remeber, locCell is a copy of the value
    }


    // ----------------------------------------------------------
    /**
     * <p>
     * Tries to find a solution to the board. If a solution is found, it should
     * be returned as a string that contains the coordinates of each cell in a
     * path that starts at the board's starting point and leads to the goal,
     * formatted like this (spacing doesn't matter):
     * </p>
     * <pre>(0, 0) (0, 1) (1, 1) (2, 1) (2, 2)</pre>
     * <p>
     * If the board has no solution, this method should return null.
     * </p><p>
     * (If the board has more than one possible solution, you may return any of
     * them.)
     * </p>
     *
     * @return a string representing a solution path if one exists, or null if
     *     there is no solution
     */
    public String solve() {
        //A* is too hard. I don't understand the theory yet...
        //We'll just do the recommended algorithm
        Stack<Location> stack = new Stack<Location>();
        stack.push(startLocation);
        
        while (!stack.isEmpty()) {
            //System.out.println(stack.toString());
            Location loc = stack.peek();
            setCell(loc, MazeCell.CURRENT_PATH);
            if (loc.equals(goalLocation)) {
                String solution = "";
                //stack.size is a dynamic field...
                //set to a constant
                int finalSize = stack.size();
                for (int i = 0; i < finalSize; i++) {
                    //System.out.println(solution);
                    //System.out.println(stack.toString());
                    solution = stack.pop().toString() + solution;
                    //seems obvious but this took me 10 minutes to think of
                }
                return solution;
            }
            else if (getCell(loc.south()) == MazeCell.UNEXPLORED) {
                stack.push((Location)loc.south());
            }
            else if (getCell(loc.east()) == MazeCell.UNEXPLORED) {
                stack.push((Location)loc.east());
            }
            else if (getCell(loc.north()) == MazeCell.UNEXPLORED) {
                stack.push((Location)loc.north());
            }
            else if (getCell(loc.west()) == MazeCell.UNEXPLORED) {
                stack.push((Location)loc.west());
            }
            else {
                setCell(loc, MazeCell.FAILED_PATH);
                stack.pop();
            }
        }
        return null;
    }
}
