/**
 * 
 */
package cs2114.mazesolver;

import org.junit.Before;
import org.junit.Test;

import student.TestCase;

/**
 * @author Evan Hruskar
 * @version 2018.04.05
 *
 */
public class MazeTest extends TestCase {

    /**
     * 
     */
    private Maze maze;
    /**
     * 
     */
    private Location loc;
    /**
     * 
     */
    @Before
    public void setUp() throws Exception {
        maze = new Maze(5);
        loc = new Location(2, 2);
    }

    /**
     * Test method for {@link cs2114.mazesolver.Maze#Maze(int)}.
     */
    @Test
    public void testMaze() {
        maze = new Maze(10);
        //again, redundant
        assertNotNull(maze);
        
        //enum has some hidden bytecode. testing it
        //done for webcat code coverage
        //https://stackoverflow.com/a/4548912
        assertEquals(MazeCell.WALL, MazeCell.valueOf("WALL"));
    }

    /**
     * Test method for {@link cs2114.mazesolver.Maze#size()}.
     */
    @Test
    public void testSize() {
        assertEquals(5, maze.size());
    }

    /**
     * Test method for {@link cs2114.mazesolver.Maze#getStartLocation()}.
     */
    @Test
    public void testGetStartLocation() {
        loc = new Location(0, 0);
        assertEquals(loc, maze.getStartLocation());
        //uses Location.equals()
    }

    /**
     * Test method for 
     */
    @Test
    public void testSetStartLocation() {
        maze.setStartLocation(loc);
        assertEquals(loc, maze.getStartLocation());
        //test an invalid cell
        loc = new Location(-1, -1);
        maze.setStartLocation(loc);
        assertFalse(loc.equals(maze.getStartLocation()));
        //test a wall & its destruction
        loc = new Location(3, 3);
        maze.setCell(loc, MazeCell.WALL);
        maze.setStartLocation(loc);
        assertEquals(loc, maze.getStartLocation());
        assertEquals(MazeCell.UNEXPLORED, maze.getCell(loc));
    }

    /**
     * Test method for {@link cs2114.mazesolver.Maze#getGoalLocation()}.
     */
    @Test
    public void testGetGoalLocation() {
        loc = new Location(maze.size() - 1, maze.size() - 1);
        assertEquals(loc, maze.getGoalLocation());
        //uses Location.equals()
    }

    /**
     * Test method for 
     */
    @Test
    public void testSetGoalLocation() {
        maze.setGoalLocation(loc);
        assertEquals(loc, maze.getGoalLocation());
        //test an invalid cell
        loc = new Location(-1, -1);
        maze.setGoalLocation(loc);
        assertFalse(loc.equals(maze.getGoalLocation()));
        //test a wall & its destruction
        loc = new Location(3, 3);
        maze.setCell(loc, MazeCell.WALL);
        maze.setGoalLocation(loc);
        assertEquals(loc, maze.getGoalLocation());
        assertEquals(MazeCell.UNEXPLORED, maze.getCell(loc));
    }

    /**
     * Test method for 
     */
    @Test
    public void testGetCell() {
        assertEquals(MazeCell.UNEXPLORED, maze.getCell(loc));
        //test x low
        loc = new Location(-1, 0);
        assertEquals(MazeCell.INVALID_CELL, maze.getCell(loc));
        //test x high
        loc = new Location(maze.size(), 0);
        assertEquals(MazeCell.INVALID_CELL, maze.getCell(loc));
        //test y low
        loc = new Location(0, -1);
        assertEquals(MazeCell.INVALID_CELL, maze.getCell(loc));
        //test y high
        loc = new Location(0, maze.size());
        assertEquals(MazeCell.INVALID_CELL, maze.getCell(loc));
        //need to test all parts of the if statement
    }

    /**
     * Test method for 
     */
    @Test
    public void testSetCell() {
        maze.setCell(loc, MazeCell.CURRENT_PATH);
        assertEquals(MazeCell.CURRENT_PATH, maze.getCell(loc));
        //test a wall on a non-important position
        maze.setCell(loc, MazeCell.WALL);
        assertEquals(MazeCell.WALL, maze.getCell(loc));
        //test a wall on an important position (starting)
        loc = new Location(0, 0);
        maze.setCell(loc, MazeCell.WALL);
        assertEquals(MazeCell.UNEXPLORED, maze.getCell(loc));
        //test an invalid cell (it doesn't do anything)
        loc = new Location(-1, -1);
        maze.setCell(loc, MazeCell.FAILED_PATH);
        assertEquals(MazeCell.INVALID_CELL, maze.getCell(loc));
        //test on goalCell
        loc = new Location(maze.size() - 1, maze.size() - 1);
        maze.setCell(loc, MazeCell.CURRENT_PATH);
        assertEquals(MazeCell.CURRENT_PATH, maze.getCell(loc));
    }

    /**
     * Test method for {@link cs2114.mazesolver.Maze#solve()}.
     */
    @Test
    public void testSolve() {
        //first maze, top left to bottom right, no walls, size 3
        maze = new Maze(3);
        assertEquals("(0, 0)(0, 1)(0, 2)(1, 2)(2, 2)", maze.solve());
        //second maze, bottom right to top left, no walls, size 3
        maze = new Maze(3);
        maze.setGoalLocation(new Location(0, 0));
        maze.setStartLocation(new Location(maze.size() - 1, maze.size() - 1));
        assertEquals("(2, 2)(2, 1)(2, 0)(1, 0)(1, 1)(1, 2)(0, 2)(0, 1)(0, 0)", 
                maze.solve());
        //  S U U
        //  U U W   unsolvable.
        //  U W G
        maze = new Maze(3);
        maze.setCell(new Location(2, 1), MazeCell.WALL);
        maze.setCell(new Location(1, 2), MazeCell.WALL);
        assertEquals(null, maze.solve());
    }
}
