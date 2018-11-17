package leetCode;

import java.util.List;
import java.util.Stack;

/**
 * 
 * @author louis 2018年11月17日
 *         <p>
 * 		Description: There are N rooms and you start in room 0. Each room has
 *         a distinct number in 0, 1, 2, ..., N-1, and each room may have some
 *         keys to access the next room.
 * 
 *         Formally, each room i has a list of keys rooms[i], and each key
 *         rooms[i][j] is an integer in [0, 1, ..., N-1] where N = rooms.length.
 *         A key rooms[i][j] = v opens the room with number v.
 * 
 *         Initially, all the rooms start locked (except for room 0).
 * 
 *         You can walk back and forth between rooms freely.
 * 
 *         Return true if and only if you can enter every room.
 *         </p>
 */
public class Problem_841_KeysandRooms {
	public boolean canVisitAllRooms(List<List<Integer>> rooms) {
		boolean[] opened = new boolean[rooms.size()];
		// 先将0号房间标记为打开
		opened[0] = true;
		Stack<Integer> stack = new Stack<>();
		// 0号房间入栈
		stack.push(0);

		//栈不为空的时候
		while (!stack.isEmpty()) {
			// 栈顶房间
			int key = stack.pop();
			// 栈顶房间里的钥匙
			for (int i : rooms.get(key)) {
				// 如果这些钥匙没打开过, 就标记为打开并且入栈
				if (!opened[i]) {
					opened[i] = true;
					stack.push(i);
				}
			}
		}
		
		// 判断是否所有房间都打开
		for (boolean f : opened) {
			if (!f)
				return false;
		}
		return true;

	}
}
