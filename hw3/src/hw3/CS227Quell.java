package hw3;
import static api.CellState.MOVABLE_NEG;
import static api.CellState.MOVABLE_POS;
import static api.CellState.PEARL;
import static api.CellState.PORTAL;

import java.util.ArrayList;

import api.Cell;
import api.CellState;
import api.Descriptor;
import api.Direction;
import api.StringUtil;

/**
 * Basic game state and operations for a simplified version of the video game 
 * "Quell".
 */
public class CS227Quell
{
  /**
   * Two-dimensional array of Cell objects representing the 
   * grid on which the game is played.
   */
  private Cell[][] grid;
  
  /**
   * Instance of GameSupport to be used in the move() algorithm.
   */
  private GameSupport support;

  
  /**
   * Constructs a game from the given string description.  The conventions
   * for representing cell states as characters can be found in 
   * <code>StringUtil</code>.  
   * @param init
   *   string array describing initial cell states
   * @param support
   *   GameSupport instance to use in the <code>move</code> method
   */
  public CS227Quell(String[] init, GameSupport support)
  {
    grid = StringUtil.createFromStringArray(init);
    this.support = support;

    // TODO - any other initialization you need
  }
  
  /**
   * Returns the number of columns in the grid.
   * @return
   *   width of the grid
   */
  public int getColumns()
  {
    return grid[0].length;
  }
  
  /**
   * Returns the number of rows in the grid.
   * @return
   *   height of the grid
   */
  public int getRows()
  {
    return grid.length;
  }
  
  /**
   * Returns the cell at the given row and column.
   * @param row
   *   row index for the cell
   * @param col
   *   column index for the cell
   * @return
   *   cell at given row and column
   */
  public Cell getCell(int row, int col)
  {
    return grid[row][col];
  }
  
  /**
   * Returns true if the game is over, false otherwise.  The game ends when all pearls
   * are removed from the grid or when the player lands on a cell with spikes.
   * @return
   *   true if the game is over, false otherwise
   */
  public boolean isOver()
  {
    // TODO
    return false;
  }
  
  /**
   * Performs a move along a cell sequence in the given direction, updating the score, 
   * the move count, and all affected cells in the grid.  The method returns an 
   * array of Descriptor objects representing the cells in original cell sequence before 
   * modification, with their <code>movedTo</code> and <code>disappeared</code>
   * status set to indicate the cells' new locations after modification.  
   * @param dir
   *   direction of the move
   * @return
   *   array of Descriptor objects describing modified cells
   */
  public Descriptor[] move(Direction dir)
  {
    // TODO
    return null;
  }
  
  // TODO - everything else
}
