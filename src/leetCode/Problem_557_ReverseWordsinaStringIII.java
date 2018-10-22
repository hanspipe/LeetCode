package leetCode;

public class Problem_557_ReverseWordsinaStringIII {

	public static void main(String[] args) {
		String s = "Let's take LeetCode contest";
		String res = reverseWords(s);
		System.out.println(res);
	}

	public static String reverseWords(String s) {
		String[] words = s.split(" ");
		String res = "";
		for (int i = 0; i < words.length; i++) {
			if (i != words.length - 1) {

				res += (reverseWord(words[i]) + " ");
			} else
				res += reverseWord(words[i]);
		}
		return res;
	}

	public static String reverseWord(String w) {
		int l = 0;
		int r = w.length() - 1;
		char[] arr = w.toCharArray();
		while (l < r) {
			char tmp = arr[l];
			arr[l] = arr[r];
			arr[r] = tmp;
			l++;
			r--;
		}
		return String.copyValueOf(arr);
	}
}
