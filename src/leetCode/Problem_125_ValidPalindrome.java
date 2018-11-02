package leetCode;

import java.util.ArrayList;
import java.util.List;
//Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
public class Problem_125_ValidPalindrome {
	public static void main(String[] args) {
		System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
	}

	public static boolean isPalindrome(String s) {
		List<Character> list = new ArrayList<>();
		for (char c : s.toCharArray()) {
			// 只讲字母和数字加入list
			if (Character.isLetter(c) || Character.isDigit(c))
				list.add(Character.toLowerCase(c));
		}

		int l = 0;
		int r = list.size() - 1;
		while (l <= r) {
			if (!list.get(l).equals(list.get(r)))
				return false;
			r--;
			l++;
		}
		return true;
	}
}
