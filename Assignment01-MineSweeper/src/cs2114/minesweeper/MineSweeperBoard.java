/**
 * 
 */
package cs2114.minesweeper;
import java.util.Random;

/**
 * The MineSweeperBoard class is responsible 
 * for keeping track of the contents of the Mine Sweeper 
 * board as the game is being played.
 * 
 * @author Evan Hruskar
 * @version 2018.02.06
 */
public class MineSweeperBoard extends MineSweeperBoardBase {
    /**
     * A 2d array containing the minesweeper board
     * arrays are row by col
     */
    private MineSweeperCell[][] board;
    private int width;
    private int height;
    /**
     * When a new MineSweeperBoard is created it will contain only 
     * COVERED_CELLs and MINEs. 
     * The MINEs will be placed randomly in the array.
     * 
     * @param width the width of the board
     * @param height the height of the board
     * @param numMines the number of mines on the board
     */
    public MineSweeperBoard(int width, int height, int numMines) {
        //initializing board
        board = new MineSweeperCell[height][width]; //row x col
        this.width = width;
        this.height = height;
        
        //covering board
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                setCell(x, y, MineSweeperCell.COVERED_CELL);
            }
        }
        
        //placing mines
        int numPlacedMines = 0;
        Random r = new Random();
        while (numPlacedMines < numMines) {
            //If width is 10, this generates random from 0 to 9
            int mineX = r.nextInt(width); 
            int mineY = r.nextInt(height);
            //If there isn't a mine there, add one.
            if (getCell(mineX, mineY) != MineSweeperCell.MINE) {
                setCell(mineX, mineY, MineSweeperCell.MINE);
                numPlacedMines++;
            }
        }
    }
    @Override
    public int width() {
        return width;
    }

    @Override
    public int height() {
        return height;
    }

    @Override
    public MineSweeperCell getCell(int x, int y) {
        if (x > width - 1 || y > height - 1) {
            return MineSweeperCell.INVALID_CELL;
        } 
        return board[y][x];
    }

    @Override
    public void uncoverCell(int x, int y) {
        if (getCell(x, y) == MineSweeperCell.COVERED_CELL || 
                getCell(x, y) == MineSweeperCell.FLAG) {
            int adjacentMines = numberOfAdjacentMines(x, y);
            setCell(x, y, MineSweeperCell.adjacentTo(adjacentMines));
        } 
        else if (getCell(x, y) == MineSweeperCell.MINE || 
                getCell(x, y) == MineSweeperCell.FLAGGED_MINE) {
            setCell(x, y, MineSweeperCell.UNCOVERED_MINE);
        }
    }

    @Override
    public void flagCell(int x, int y) {
        switch(getCell(x, y)) {
            case COVERED_CELL:
                setCell(x, y, MineSweeperCell.FLAG);
                break;
            case FLAG:
                setCell(x, y, MineSweeperCell.COVERED_CELL);
                break;
            case FLAGGED_MINE:
                setCell(x, y, MineSweeperCell.MINE);
                break;
            case MINE:
                setCell(x, y, MineSweeperCell.FLAGGED_MINE);
                break;
            default:
                break;
        }
    }

    @Override
    public boolean isGameLost() {
        //iterate through board and check if any mines are uncovered.
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                if (getCell(x, y) == MineSweeperCell.UNCOVERED_MINE) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean isGameWon() {
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                if (getCell(x, y) == MineSweeperCell.COVERED_CELL || 
                        getCell(x, y) == MineSweeperCell.MINE || 
                        getCell(x, y) == MineSweeperCell.FLAG ||
                        getCell(x, y) == MineSweeperCell.UNCOVERED_MINE) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public int numberOfAdjacentMines(int x, int y) {
        //Double loop algorithm with boundary checks from:
        //https://stackoverflow.com/a/2035539
        int runningTotal = 0;
        for (int deltaX = (x > 0 ? -1 : 0); 
                deltaX <= (x < (width - 1) ? 1 : 0); 
                ++deltaX) {
            for (int deltaY = (y > 0 ? -1 : 0); 
                    deltaY <= (y < (height - 1) ? 1 : 0); 
                    ++deltaY) {
                if (deltaX != 0 || deltaY != 0) {
                    if (getCell(x + deltaX, y + deltaY) == 
                            MineSweeperCell.MINE ||
                            getCell(x + deltaX, y + deltaY) == 
                            MineSweeperCell.FLAGGED_MINE ||
                            getCell(x + deltaX, y + deltaY) == 
                            MineSweeperCell.UNCOVERED_MINE) {
                        runningTotal++;
                    }
                }
            }
        }
        return runningTotal;
    }

    @Override
    public void revealBoard() {
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                uncoverCell(x, y);
            }
        }
        
    }

    @Override
    protected void setCell(int x, int y, MineSweeperCell value) {
        board[y][x] = value;
    }
    
}
