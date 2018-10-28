package leetCode;

public class Problem_345_ReverseVowelsOfString {
	public static void main(String[] args) {
		System.out.println(reverseVowels("leetcode"));
	}

	public static String reverseVowels(String s) {
		if (s == null || s.length() == 0)
			return s;
		char[] arr = s.toCharArray();
		int lo = 0;
		int hi = s.length() - 1;
		while (lo < hi) {
			while (lo < hi && !isVowel(arr[lo]))
				lo++;
			while (lo < hi && !isVowel(arr[hi]))
				hi--;
			if (lo < hi) {
				swap(arr, lo, hi);
				lo++;
				hi--;
			}
		}
		return new String(arr);
	}

	public static boolean isVowel(char c) {
		if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O'
				|| c == 'U') {
			return true;
		} else
			return false;
	}

	public static void swap(char[] arr, int a, int b) {
		char tmp = arr[a];
		arr[a] = arr[b];
		arr[b] = tmp;
	}
}
