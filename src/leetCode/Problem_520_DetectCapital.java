package leetCode;

import java.util.Scanner;

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

		if (Character.isUpperCase(arr[0])) {
			if (Character.isUpperCase(arr[1])) {
				for (int i = 1; i < n; i++) {
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
