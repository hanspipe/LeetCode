package leetCode;

public class Problem_168_ExcelColumnSheetTitle {
	public static void main(String[] args) {
		System.out.println(convertToTitle(701));
	}

	public static String convertToTitle(int n) {
		StringBuilder res = new StringBuilder();
		char[] letters = new char[26];
		for (int i = 0; i < 26; i++) {
			letters[i] = (char) ('A' + i);
		}
		
		while(n != 0) {
			n--;
			int tmp1 = n % 26;
			res.append(letters[tmp1]);
			n /= 26;
		}

		return res.reverse().toString();

	}
}
