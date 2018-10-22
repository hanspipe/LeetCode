package leetCode;

import java.util.Scanner;

public class Problem_647_PalindromicSubstrings {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		System.out.println(countSubstrings(input));
	}
	public static int countSubstrings(String s) {
		int cnt =0;
		for(int i = 0; i < s.length(); i++) {
			for(int j = i; j < s.length(); j++) {
				if(isPalindromic(s.substring(i, j+1)))
					cnt++;
			}
		}
		return cnt;
	}

	public static boolean isPalindromic(String sub) {
		if (sub.length() == 0)
			return false;
		int l = 0;
		int r = sub.length() - 1;
		while (l <= r) {
			if (sub.charAt(l) != sub.charAt(r))
				return false;
			l++;
			r--;
		}
		return true;
	}
}
