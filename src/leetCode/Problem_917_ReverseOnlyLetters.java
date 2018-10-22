package leetCode;

import java.util.Stack;

public class Problem_917_ReverseOnlyLetters {
	public String reverseOnlyLetters(String S) {
		Stack<Character> stack = new Stack<>();
		for(char c : S.toCharArray()) {
			if(Character.isLetter(c))
				stack.push(c);
		}
		
		StringBuilder sb = new StringBuilder();
		for(char c : S.toCharArray()) {
			if(!Character.isLetter(c))
				sb.append(c);
			else
				sb.append(stack.pop());
		}
		return sb.toString();
	}
}
