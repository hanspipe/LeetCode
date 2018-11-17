package leetCode;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 
 * @author louis 2018��11��17��
 *         <p>
 * 		Description: Given a list of daily temperatures T, return a list such
 *         that, for each day in the input, tells you how many days you would
 *         have to wait until a warmer temperature. If there is no future day
 *         for which this is possible, put 0 instead.
 * 
 *         For example, given the list of temperatures T = [73, 74, 75, 71, 69,
 *         72, 76, 73], your output should be [1, 1, 4, 2, 1, 1, 0, 0].
 *         </p>
 */
public class Problem_739_DailyTemperatures {
	public int[] dailyTemperatures(int[] T) {
		int[] ans = new int[T.length];
		Stack<Integer> stack = new Stack();
		// �����һ�쿪ʼ
		for (int i = T.length - 1; i >= 0; --i) {
			// ջ��Ϊ�� �� ��һ����¶Ȳ�С��ջ���¶�
			// ��ջ���¶�С�ĲŲ����ջ
			// ѭ����ջ��Ϊ���ҵ�һ���ȵ�ǰwarmer������
			while (!stack.isEmpty() && T[i] >= T[stack.peek()])
				stack.pop();
			// ���ջ��, ���Ǻ���û��warmer������
			// ���ջ���� ջ������-��ǰ����
			ans[i] = stack.isEmpty() ? 0 : stack.peek() - i;
			stack.push(i);
		}
		return ans;
	}
}
