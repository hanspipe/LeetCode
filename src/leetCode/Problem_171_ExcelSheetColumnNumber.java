package leetCode;

public class Problem_171_ExcelSheetColumnNumber {
	public static void main(String[] args) {
		String str = "ZY";
		System.out.println(titleToNumber(str));
	}
	public static  int titleToNumber(String s) {
		char[] arr = s.toCharArray();
		int res = 0;
		for (int i = arr.length - 1; i >= 0; i--) {
			res += letterToNumber(arr[i]) * Math.pow(26, arr.length - 1 - i);
		}
		return res;
	}

	private static int letterToNumber(char ch) {
		return ch - 'A' + 1;
	}
}
