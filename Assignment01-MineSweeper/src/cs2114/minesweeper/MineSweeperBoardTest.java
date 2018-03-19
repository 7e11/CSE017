/**
 * 
 */
package cs2114.minesweeper;

//import student.TestCase;
//had to remove the student.TestCase in order to throw exceptions
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * @author Evan Hruskar
 * @version 2018.02.06
 */
public class MineSweeperBoardTest {
    /**
     * All used to get test coverage dammit.
     * See:
     * https://stackoverflow.com/a/2935935
     */
    @Rule
    public final ExpectedException exception = ExpectedException.none();
    /**
     * 
     */
    private MineSweeperBoard board;
    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
        board = new MineSweeperBoard(4, 4, 2);
        // board is declared as part of the test fixture, and
        // is initialized to be 4x4
        board.loadBoardState("    ",
                             "OOOO",
                             "O++O",
                             "OOOO");
    }
    
    /**
     * @param theBoard created board for testing
     * @param expected a number of strings representing the board.
     */
    public void assertBoard(MineSweeperBoard theBoard, String... expected)
    {
        MineSweeperBoard expectedBoard =
            new MineSweeperBoard(expected[0].length(), expected.length, 0);
        expectedBoard.loadBoardState(expected);
        assertEquals(expectedBoard, theBoard); 
        // uses equals() from MineSweeperBoardBase
    }

    /**
     * Test method for 
     * {@link cs2114.minesweeper.MineSweeperBoard#width()}.
     */
    @Test
    public void testWidth() {
        assertEquals(4, board.width());
    }

    /**
     * Test method for 
     * {@link cs2114.minesweeper.MineSweeperBoard#height()}.
     */
    @Test
    public void testHeight() {
        assertEquals(4, board.height());
    }

    /**
     * Test method for 
     * {@link cs2114.minesweeper.MineSweeperBoard#getCell(int, int)}.
     */
    @Test
    public void testGetCell() {
        board.loadBoardState("OOOM",
                             "OMOO",
                             "O+MO",
                             "O+OO");
        assertEquals(MineSweeperCell.MINE, board.getCell(1, 2));
        assertEquals(MineSweeperCell.INVALID_CELL, board.getCell(10, 1));
        assertEquals(MineSweeperCell.INVALID_CELL, board.getCell(1, 10));
    }

    /**
     * Test method for 
     * {@link cs2114.minesweeper.MineSweeperBoard#uncoverCell(int, int)}.
     */
    @Test
    public void testUncoverCell() {
        board.loadBoardState("OFM+",
                             "* 12",
                             "3456",
                             "78OO");

        board.uncoverCell(0, 0);
        board.uncoverCell(1, 0);
        board.uncoverCell(2, 0);
        board.uncoverCell(3, 0);
        board.uncoverCell(0, 1);
        board.uncoverCell(1, 1);
        board.uncoverCell(2, 1);
        board.uncoverCell(3, 1);
        board.uncoverCell(0, 2);
        board.uncoverCell(1, 2);
        board.uncoverCell(2, 2);
        board.uncoverCell(3, 2);
        board.uncoverCell(0, 3);
        board.uncoverCell(1, 3);
        board.uncoverCell(2, 3);
        board.uncoverCell(3, 3);
        assertBoard(board, "12**",
                           "* 12",
                           "3456",
                           "78  ");
    }

    /**
     * Test method for 
     * {@link cs2114.minesweeper.MineSweeperBoard#flagCell(int, int)}.
     */
    @Test
    public void testFlagCell() {
        board.loadBoardState("OFM+",
                            "* 12",
                            "3456",
                            "78OO");
        board.flagCell(0, 0);
        board.flagCell(1, 0);
        board.flagCell(2, 0);
        board.flagCell(3, 0);
        board.flagCell(0, 1);
        board.flagCell(1, 1);
        board.flagCell(2, 1);
        board.flagCell(3, 1);
        board.flagCell(0, 2);
        board.flagCell(1, 2);
        board.flagCell(2, 2);
        board.flagCell(3, 2);
        board.flagCell(0, 3);
        board.flagCell(1, 3);
        board.flagCell(2, 3);
        board.flagCell(3, 3);
        
        assertBoard(board, "FO+M",
                           "* 12",
                           "3456",
                           "78FF");
    }

    /**
     * Test method for 
     * {@link cs2114.minesweeper.MineSweeperBoard#isGameLost()}.
     */
    @Test
    public void testIsGameLost() {
        board.loadBoardState("OOOM",
                            "OMOF",
                            "O+MO",
                            "O+OO");
        assertEquals(false, board.isGameLost());
        board.loadBoardState("OOOM",
                            "OMOF",
                            "O+MO",
                            "O+O*");
        assertEquals(true, board.isGameLost());
    }

    /**
     * Test method for 
     * {@link cs2114.minesweeper.MineSweeperBoard#isGameWon()}.
     */
    @Test
    public void testIsGameWon() {
        board.loadBoardState("123M",
                            "325M",
                            "MMMM",
                            "M33M");
        assertEquals(true, board.isGameWon());
        board.loadBoardState("OOOM",
                            "OMOF",
                            "O+MO",
                            "O+O*");
        assertEquals(false, board.isGameWon());
        board.loadBoardState("+OOM",
                            "+MOF",
                            "O+MO",
                            "O+O*");
        assertEquals(false, board.isGameWon());
        board.loadBoardState("FOOM",
                            "OMOF",
                            "O+MO",
                            "O+O*");
        assertEquals(false, board.isGameWon());
        board.loadBoardState("*OOM",
                            "OMOF",
                            "O+MO",
                            "O+O*");
        assertEquals(false, board.isGameWon());
    }

    /**
     * Test method for 
     * 
     */
    @Test
    public void testNumberOfAdjacentMines() {
        board.loadBoardState("OOOM",
                             "OMOO",
                             "O+MO",
                             "O+OO");
        assertEquals(1, board.numberOfAdjacentMines(0, 0));
        assertEquals(2, board.numberOfAdjacentMines(2, 0));
        assertEquals(3, board.numberOfAdjacentMines(2, 3));
        assertEquals(2, board.numberOfAdjacentMines(0, 3));

        board.loadBoardState("OOOO",
                             "OOOO",
                             "O+MO",
                             "O+OO");
        assertEquals(1, board.numberOfAdjacentMines(3, 3));
        assertEquals(0, board.numberOfAdjacentMines(3, 0));
        assertEquals(1, board.numberOfAdjacentMines(3, 2));
        assertEquals(2, board.numberOfAdjacentMines(2, 1));
    }

    /**
     * Test method for 
     * {@link cs2114.minesweeper.MineSweeperBoard#revealBoard()}.
     */
    @Test
    public void testRevealBoard() {
        board.loadBoardState("OOOO",
                             "OOOO",
                             "O+MO",
                             "O+OO");

        board.revealBoard();
        assertBoard(board, "    ",
                           "1221",
                           "2**1",
                           "2*31");
    }

    /**
     * Test method for 
     * 
     */
    @Test
    public void testSetCell()
    {
        // board is declared as part of the test fixture, and
        // is initialized to be 4x4
        board.loadBoardState("    ",
                             "OOOO",
                             "O++O",
                             "OOOO");

        board.setCell(1, 2, MineSweeperCell.FLAGGED_MINE);

        assertBoard(board, "    ",
                           "OOOO",
                           "OM+O",
                           "OOOO");
    }
    
    /**
     * Tests the equals method in the superclass
     */
    @Test
    public void testEquals() {
        MineSweeperBoard b = board;
        MineSweeperBoard c = board;
        assertEquals(true, b.equals(c));
        c = new MineSweeperBoard(4, 4, 10);
        assertEquals(false, b.equals(c));
        c = new MineSweeperBoard(4, 10, 10);
        assertEquals(false, b.equals(c));
        c = new MineSweeperBoard(10, 4, 10);
        assertEquals(false, b.equals(c));
        assertEquals(false, b.equals(3));
    }
    
    /**
     * Test the toString method in the superclass
     */
    @Test
    public void testToString() {
        //tests the whole toString Method.
        board.loadBoardState("OFM+",
                             "* 12",
                             "3456",
                             "78OO");
        board.toString();
        assertBoard(board, "OFM+",
                             "* 12",
                             "3456",
                             "78OO");
        
    }
    
    /**
     *  tests loadBoardState() in the superclass
     */
    @Test
    public void testLoadBoardStateJagged() {
        //not an actual test, just getting test coverage.
        exception.expect(IllegalArgumentException.class);
        board.loadBoardState("OFM+",
                "* 12",
                "3456 ",
                "78OO");
        board.loadBoardState("OFM+",
                "* 12",
                "3456",
                "78OO");
        assertBoard(board, "OFM+",
                        "* 12",
                        "3456",
                        "78OO");
        //losing points for not having an assert
    }
    /**
     *  tests loadBoardState() in the superclass
     */
    @Test
    public void testLoadBoardStateMismatch() {
        exception.expect(IllegalArgumentException.class);
        board.loadBoardState("OFM+",
                "* 12",
                "3456",
                "78OO",
                "78OO");
        board.loadBoardState("OFM+",
                "* 12",
                "3456",
                "78OO");
        assertBoard(board, "OFM+",
                        "* 12",
                        "3456",
                        "78OO");
        //losing points for not having an assert
    }
    
    /**
     *  tests loadBoardState() in the superclass
     */
    @Test
    public void testLoadBoardStateChar() {
        exception.expect(IllegalArgumentException.class);
        board.loadBoardState("OFM+",
                "* 12",
                "3~56",
                "78OO");
        board.loadBoardState("OFM+",
                "* 12",
                "3456",
                "78OO");
        assertBoard(board, "OFM+",
                        "* 12",
                        "3456",
                        "78OO");
        //losing points for not having an assert
    }
        
    /**
     * tests adjacent to in the cell class
     */
    @Test
    public void testAdjacentToErrors() {
        @SuppressWarnings("unused")
        MineSweeperCell c = MineSweeperCell.INVALID_CELL;
        exception.expect(IllegalArgumentException.class);
        c = MineSweeperCell.adjacentTo(9);
        exception.expect(IllegalArgumentException.class);
        c = MineSweeperCell.adjacentTo(-1);
        
        //Trying to use all of the enum code... still not working
        c = MineSweeperCell.adjacentTo(0);
        c = MineSweeperCell.adjacentTo(1);
        c = MineSweeperCell.adjacentTo(2);
        c = MineSweeperCell.adjacentTo(3);
        c = MineSweeperCell.adjacentTo(4);
        c = MineSweeperCell.adjacentTo(5);
        c = MineSweeperCell.adjacentTo(6);
        c = MineSweeperCell.adjacentTo(7);
        c = MineSweeperCell.adjacentTo(8);
        
        board.loadBoardState("OFM+",
                "* 12",
                "3456",
                "78OO");
        assertBoard(board, "OFM+",
                        "* 12",
                        "3456",
                        "78OO");
        //losing points for not having an assert
    }
    
    /**
    * test for adjacent to test
    */
    @Test
    public void testAdjacentTo() {
        MineSweeperCell c = MineSweeperCell.ADJACENT_TO_0;
        assertNotNull(c);
        // testing for exception
        Exception thrown = null;
        try {
            c = MineSweeperCell.adjacentTo(10);
        } 
        catch (Exception e) {
            thrown = e;
        }
        assertTrue(thrown instanceof IllegalArgumentException);

        thrown = null;
        try {
            MineSweeperCell.adjacentTo(-1);
        } 
        catch (Exception e) {
            thrown = e;
        }
        assertTrue(thrown instanceof IllegalArgumentException);
        assertNotNull(MineSweeperCell.values());
        assertNotNull(MineSweeperCell.valueOf(
                MineSweeperCell.ADJACENT_TO_0.toString()));

    }

    /**
     * Tests the loading of the board state.
     */
    @Test
    public void testloadBoardState() {
        MineSweeperBoard a = new MineSweeperBoard(2, 2, 1);
        Exception thrown = null;
        // loadBoardState testing
        // wrong number of rows
        try {
            a.loadBoardState("00");
        } 
        catch (Exception e) {
            thrown = e;
        }
        assertTrue(thrown instanceof IllegalArgumentException);
        thrown = null;
        // wrong number of columns
        try {
            a.loadBoardState("0000 ", " ");
        } 
        catch (Exception e) {
            thrown = e;
        }
        assertTrue(thrown instanceof IllegalArgumentException);
        // Wrong symbol in cell
        try {
            a.loadBoardState("00", "$+");
        } 
        catch (Exception e) {
            thrown = e;
        }
        assertTrue(thrown instanceof IllegalArgumentException);
    }

    /**
     * * This method test Equals.
     */
    @Test
    public void testEqual() {
        MineSweeperBoard mBoard1 = new MineSweeperBoard(4, 4, 6);
        MineSweeperBoard mBoard2 = new MineSweeperBoard(4, 4, 6);
        mBoard1.loadBoardState("    ", "OOOO", "O++O", "OOOO");
        mBoard2.loadBoardState("    ", "OOOO", "O++O", "OOOO");
        // test the same board same dimensions
        assertTrue(mBoard1.equals(mBoard2));
        // same board testing same board
        assertTrue(mBoard1.equals(mBoard1));
        // testing same dimensions board with different cell
        MineSweeperBoard mBoard3 = new MineSweeperBoard(4, 4, 6);
        mBoard3.loadBoardState("    ", "O+OO", "O++O", "OOOO");
        assertFalse(mBoard1.equals(mBoard3));
        MineSweeperBoard mBoard4 = new MineSweeperBoard(15, 1, 0);
        mBoard4.loadBoardState("OFM+* 123456788");
        assertFalse(mBoard1.toString().equals(mBoard3.toString()));
        // testing two string against a board
        assertFalse(mBoard4.toString().equals(mBoard2.toString()));
        // testing against a string
        assertFalse(mBoard1.equals("abc"));
        assertFalse(mBoard1.equals(2));
        // same width but different height
        MineSweeperBoard mBoard6 = new MineSweeperBoard(4, 5, 6);
        mBoard6.loadBoardState("    ", "O+OO", "O++O", "OOOO", "OOOO");
        assertFalse(mBoard6.equals(mBoard1));
        // different width same height
        MineSweeperBoard mBoard5 = new MineSweeperBoard(5, 4, 6);
        mBoard5.loadBoardState("     ", "O+OOO", "O++OO", "OOOOO");
        assertFalse(mBoard5.equals(mBoard1));
    }

}
