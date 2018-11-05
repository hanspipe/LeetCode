package leetCode;

import java.util.Scanner;
/**
 * 
 * @author louis
 * 2018年11月5日
 * <p>Description: Given a word, you need to judge whether the usage of capitals in it is right or not.

	We define the usage of capitals in a word to be right when one of the following cases holds:

	All letters in this word are capitals, like "USA".
	All letters in this word are not capitals, like "leetcode".
	Only the first letter in this word is capital if it has more than one letter, like "Google".
	Otherwise, we define that this word doesn't use capitals in a right way.</p>
 */
public class Problem_520_DetectCapital {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		System.out.println(detectCapitalUse(str));
	}
	public static boolean detectCapitalUse(String word) {
		char[] arr = word.toCharArray();
		int n = arr.length;
		if (n == 1)
			return true;

		if (Character.isUpperCase(arr[0])) {// 如果首字母是大写
			if (Character.isUpperCase(arr[1])) {// 如果第二个也是大写
				for (int i = 1; i < n; i++) {// i=1开始是为了防止越界
					if (!Character.isUpperCase(arr[i]))
						return false;
				}
				return true;
			} else {
				for (int i = 1; i < n; i++) {
					if (!Character.isLowerCase(arr[i]))
						return false;
				}
				return true;
			}
		} else {
			for (int i = 1; i < n; i++) {
				if (!Character.isLowerCase(arr[i]))
					return false;
			}
			return true;
		}
	}
}
