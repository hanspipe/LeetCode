package leetCode;
/**
 * 
 * @author louis
 * 2018年11月4日
 * <p>Description: Given an 2D board, 
 * 
 * count how many battleships are in it. 
 * 
 * The battleships are represented with 'X's,
 * 
 *  empty slots are represented with '.'s. You may assume the 
 *  
 *  following rules:
You receive a valid board, made of only battleships or empty slots.
Battleships can only be placed horizontally or vertically. In other words, 
they can only be made of the shape 1xN (1 row, N columns) or Nx1 (N rows, 1 column), where N can be of any size.
At least one horizontal or vertical cell separates between two battleships - there are no adjacent battleships.</p>
 */
public class Problem_419_BattleshipsinaBoard {
	public int countBattleships(char[][] board) {
		int rows = board.length;
		if(rows == 0)
			return 0;
		int cols = board[0].length;
		int cnt = 0;
		
		// 遍历每个位置
		// 只有当前不为. 且左和上都不为X cnt才++ 
		for(int i = 0; i < rows; i++)
			for(int j = 0; j < cols; j++) {
				if(board[i][j] == '.') continue;
				if(i > 0 && board[i-1][j] == 'X') continue;
				if(j > 0 && board[i][j-1] == 'X') continue;
				cnt++;
			}
		return cnt;
	}
}
