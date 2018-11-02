package leetCode;
/**
 * 
 * @author louis
 * 2018年11月2日
 * <p>Description: Given a positive integer, return its corresponding column title as appear in an Excel sheet.

	For example:

    1 -> A
    2 -> B
    3 -> C
    ...
    26 -> Z
    27 -> AA
    28 -> AB </p>
 */
public class Problem_168_ExcelColumnSheetTitle {
	public static void main(String[] args) {
		System.out.println(convertToTitle(701));
	}

	public static String convertToTitle(int n) {
		StringBuilder res = new StringBuilder();
		char[] letters = new char[26];
		// 数组中存储A,B,C,D...
		for (int i = 0; i < 26; i++) {
			letters[i] = (char) ('A' + i);
		}
		
		while(n != 0) {
			// n--,因为要从1开始
			n--;
			int tmp1 = n % 26;
			res.append(letters[tmp1]);
			n /= 26;
		}
		// 最后要反转
		return res.reverse().toString();

	}
}
