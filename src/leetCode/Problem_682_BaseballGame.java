package leetCode;

import java.util.Stack;

/**
 * 
 * @author louis 2018年11月17日
 *         <p>
 * 		Description: You're now a baseball game point recorder.
 * 
 *         Given a list of strings, each string can be one of the 4 following
 *         types:
 * 
 *         Integer (one round's score): Directly represents the number of points
 *         you get in this round. 
 *         
 *         "+" (one round's score): Represents that the
 *         points you get in this round are the sum of the last two valid
 *         round's points. 
 *         
 *         "D" (one round's score): Represents that the points
 *         you get in this round are the doubled data of the last valid round's
 *         points. 
 *         
 *         "C" (an operation, which isn't a round's score): Represents
 *         the last valid round's points you get were invalid and should be
 *         removed. Each round's operation is permanent and could have an impact
 *         on the round before and the round after.
 * 
 *         You need to return the sum of the points you could get in all the
 *         rounds.
 *         </p>
 */
public class Problem_682_BaseballGame {
	public int calPoints(String[] ops) {
		Stack<Integer> stack = new Stack<>();
		int sum = 0;
		for(String op : ops) {
			// 如果遇到+
			if(op.equals("+")) {
				// 栈顶弹出
				int top = stack.pop();
				// 新的栈顶
				int newTop = top + stack.peek();
				// 因为要保存两轮valid分数, 所以top还要入栈 
				stack.push(top);
				stack.push(newTop);
			}else if(op.equals("C"))
				stack.pop();
			else if(op.equals("D")){
				// 这里是不能把上一轮的分数pop出来的
				stack.push(2 * stack.peek());
			}else {
				stack.push(Integer.valueOf(op));
			}
		}
		for(int s : stack)
			sum += s;
		return sum;
	}
}
