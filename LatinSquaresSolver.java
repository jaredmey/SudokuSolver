/**
 * @author Jared Meyer
 * This class implements the logic to Latin Squares.
 *
 */
public class LatinSquaresSolver {
	
	private final int UNDO = 0;

	/**
	 * Iterates through the puzzle array recursively and backtracks when
	 * necessary if it reaches an invalid cell. Returns true if the puzzle has
	 * as solution, and false if it does not.
	 * 
	 * @param puzzle 2D array containing the sudoku puzzle to be solved
	 * @return True if the puzzle has reached a solution, false if it has not
	 * 
	 */
	boolean solve(int[][] puzzle) {
		final int SIZE = puzzle.length;
		
		for (int row = 0; row < SIZE; row++) {
			for (int col = 0; col < SIZE; col++) {
				if (puzzle[row][col] != 0)	{	//base case
					continue;
				}
				for (int val = 1; val < 7; val++) {
					if (isSafe(puzzle, row, col, val)) {
						puzzle[row][col] = val;
						if (solve(puzzle)) {	//recursive case
							return true;
						} else {
							puzzle[row][col] = UNDO; // backtrack
						}
					} 
				}
				return false;
			}
		}
		return true;
	}
	
	//BASE CASE: uses the checkRowAndCol method to return false if it is not a safe number, and true if it is.
	boolean isSafe(int[][] puzzle, int row, int col, int val)	{
		if (checkRowAndCol(puzzle,row,col,val)){
			return false;
		}
		else 
		{
		return true;
		}
	}
	
	//Returns true if the val is already found in the row or col, and returns false if it is not.
	boolean checkRowAndCol(int[][] puzzle, int row, int col, int val){
		final int SIZE = puzzle.length;
		
		for (int r = 0; r < SIZE; r++){
			if(puzzle[r][col] == val){
				return true;
			} 
		}
		for (int c = 0; c < SIZE; c++)	{
			if (puzzle[row][c] == val){
				return true;
			} 
		}
		return false;
	}
}
