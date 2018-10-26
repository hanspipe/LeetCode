package leetCode;

import java.util.ArrayList;
import java.util.List;

public class Problem_054_SpiralMatrix {
	public List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> ans = new ArrayList<>();
		if (matrix.length == 0)
			return ans;
		// 初始化左上、右下角的坐标
		int r1 = 0, r2 = matrix.length - 1;
		int c1 = 0, c2 = matrix[0].length - 1;
		while (r1 <= r2 && c1 <= c2) {
			//向右
			for (int c = c1; c <= c2; c++)
				ans.add(matrix[r1][c]);
			//向下
			for (int r = r1 + 1; r <= r2; r++)
				ans.add(matrix[r][c2]);
			
			if (r1 < r2 && c1 < c2) {
				//向左
				for (int c = c2 - 1; c > c1; c--)
					ans.add(matrix[r2][c]);
				//向上
				for (int r = r2; r > r1; r--)
					ans.add(matrix[r][c1]);
			}
			//向内一层
			r1++;
			r2--;
			c1++;
			c2--;
		}
		return ans;

	}
}
