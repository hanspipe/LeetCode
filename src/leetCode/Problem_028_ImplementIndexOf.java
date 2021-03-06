package leetCode;

/**
 * 
 * @author louis
 * 2018��10��26��
 * <p>Description: Return the index of the first occurrence of needle in haystack,
 * 		 or -1 if needle is not part of haystack.</p>
 */
public class Problem_028_ImplementIndexOf {
	public static void main(String[] args) {
		System.out.println(strStr("aa", ""));
	}

	public static int strStr(String haystack, String needle) {

		int m = haystack.length();
		int n = needle.length();
		if (n == 0) {
			return 0;
		}
		if (n > m) {
			return -1;
		}
		
		// m-n+1 
		for (int i = 0; i < m - n + 1; i++) {
			if (haystack.substring(i, i + n).equals(needle)) {
				return i;
			}
		}
		return -1;
	}
}
