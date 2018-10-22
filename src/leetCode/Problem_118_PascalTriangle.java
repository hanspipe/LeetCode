package leetCode;

import java.util.ArrayList;
import java.util.List;

public class Problem_118_PascalTriangle {
	public List<List<Integer>> generate(int numRows) {
		List<List<Integer>> triangle = new ArrayList<>();
		// First base case; if user requests zero rows, they get zero rows.
		if (numRows == 0)
			return triangle;

		// Second base case; first row is always [1].
		triangle.add(new ArrayList<>());
		triangle.get(0).add(1);

		for (int rowNum = 1; rowNum < numRows; rowNum++) {
			List<Integer> row = new ArrayList<>();
			List<Integer> prevRow = triangle.get(rowNum - 1);

			// The first row element is always 1.
			row.add(1);

			for (int j = 1; j < rowNum; j++) {
				row.add(prevRow.get(j - 1) + prevRow.get(j));
			}
			
			row.add(1);
			
			triangle.add(row);
		}
		return triangle;
	}
}
