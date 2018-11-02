package leetCode;

import java.util.ArrayList;
import java.util.List;
//Given a non-negative index k where k �� 33, return the kth index row of the Pascal's triangle.
public class Problem_119_PascalTriangleII {
	public List<Integer> getRow(int rowIndex) {
		List<Integer> res = new ArrayList<>();
		if (rowIndex < 0)
			return res;

		for (int i = 0; i < rowIndex + 1; i++) {
			res.add(0, 1);
			for (int j = 1; j < res.size() - 1; j++) {
				res.set(j, res.get(j) + res.get(j + 1));
			}
		}
		return res;
	}
}
