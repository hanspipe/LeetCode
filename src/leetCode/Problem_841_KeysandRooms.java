package leetCode;

import java.util.List;
import java.util.Stack;

/**
 * 
 * @author louis 2018��11��17��
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
		// �Ƚ�0�ŷ�����Ϊ��
		opened[0] = true;
		Stack<Integer> stack = new Stack<>();
		// 0�ŷ�����ջ
		stack.push(0);

		//ջ��Ϊ�յ�ʱ��
		while (!stack.isEmpty()) {
			// ջ������
			int key = stack.pop();
			// ջ���������Կ��
			for (int i : rooms.get(key)) {
				// �����ЩԿ��û�򿪹�, �ͱ��Ϊ�򿪲�����ջ
				if (!opened[i]) {
					opened[i] = true;
					stack.push(i);
				}
			}
		}
		
		// �ж��Ƿ����з��䶼��
		for (boolean f : opened) {
			if (!f)
				return false;
		}
		return true;

	}
}
