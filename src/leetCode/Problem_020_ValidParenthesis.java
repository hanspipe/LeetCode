package leetCode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 
 * @author louis
 * 2018��10��26��
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
				
				//���ջ���������Ӧ��������
				if(topChar != map.get(c))
					return false;
			}else//�������ŵ�ʱ���ѹջ
				stack.push(c);
		}
		//���Ҫƥ���꣬ջҪ����
		return stack.isEmpty();
	}
}
