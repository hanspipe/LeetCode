package leetCode;

/**
 * 
 * @author louis 2018年11月2日
 *         <p>
 * 		Description: Given a column title as appear in an Excel sheet, return
 *         its corresponding column number.
 * 
 *         For example:
 * 
 *         A -> 1 B -> 2 C -> 3 ... Z -> 26 AA -> 27 AB -> 28
 *         </p>
 */
public class Problem_171_ExcelSheetColumnNumber {
	public static void main(String[] args) {
		String str = "ZY";
		System.out.println(titleToNumber(str));
	}

	public static int titleToNumber(String s) {
		char[] arr = s.toCharArray();
		int res = 0;
		// 从后往前
		for (int i = arr.length - 1; i >= 0; i--) {
			res += letterToNumber(arr[i]) * Math.pow(26, arr.length - 1 - i);
		}
		return res;
	}
	
	// 字母变数字
	private static int letterToNumber(char ch) {
		return ch - 'A' + 1;
	}
}
