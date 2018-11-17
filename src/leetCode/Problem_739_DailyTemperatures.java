package leetCode;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 
 * @author louis 2018年11月17日
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
		// 从最后一天开始
		for (int i = T.length - 1; i >= 0; --i) {
			// 栈不为空 且 这一天的温度不小于栈顶温度
			// 比栈顶温度小的才不会出栈
			// 循环出栈是为了找到一个比当前warmer的天气
			while (!stack.isEmpty() && T[i] >= T[stack.peek()])
				stack.pop();
			// 如果栈空, 就是后面没有warmer的天气
			// 如果栈不空 栈顶天数-当前天数
			ans[i] = stack.isEmpty() ? 0 : stack.peek() - i;
			stack.push(i);
		}
		return ans;
	}
}
