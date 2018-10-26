package leetCode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 
 * @author louis
 * 2018年10月26日
 * <p>Description: Given a string containing just the characters '(', ')', '{', '}', '[' and ']', 
 * 		determine if the input string is valid.</p>
 * An input string is valid if:

		Open brackets must be closed by the same type of brackets.
		Open brackets must be closed in the correct order.
 */
public class Problem_020_ValidParenthesis {
	public static void main(String[] args) {
		System.out.println(isValid("{[]}"));
	}
	public static boolean isValid(String s) {
		
		// 
		Map<Character, Character> map = new HashMap<>();
		map.put(')', '(');
		map.put('}', '{');
		map.put(']', '[');
		
		Stack<Character> stack = new Stack<>();
		for(int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			
			// If the current character is a closing bracket.
			if(map.containsKey(c)) {
				
				// Get the top element of the stack. If the stack is empty, set a dummy value of '#'
				char topChar = stack.isEmpty()? '#' : stack.pop();
				
				//如果栈顶不是相对应的左括号
				if(topChar != map.get(c))
					return false;
			}else//是左括号的时候才压栈
				stack.push(c);
		}
		//最后要匹配完，栈要弹空
		return stack.isEmpty();
	}
}
