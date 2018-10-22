package leetCode;

import java.util.List;
import java.util.Stack;

public class Problem_841_KeysandRooms {
	public boolean canVisitAllRooms(List<List<Integer>> rooms) {
		boolean[] seen = new boolean[rooms.size()];
		seen[0] = true;
		Stack<Integer> stack = new Stack<>();
		stack.push(0);

		while (!stack.isEmpty()) {
			int key = stack.pop();
			for (int i : rooms.get(key)) {
				if (!seen[i]) {
					seen[i] = true;
					stack.push(i);
				}
			}
		}

		for (boolean f : seen) {
			if (!f)
				return false;
		}
		return true;

	}
}
