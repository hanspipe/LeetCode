package leetCode;

/**
 * 
 * @author louis
 * 2018年11月4日
 * <p>Description: Given two non-negative integers num1 and num2 represented as string, return the sum of num1 and num2.</p>
 */
public class Problem_415_AddStrings {
	public static void main(String[] args) {
		String str1 = "9";
		String str2 = "99";
		System.out.println(addStrings(str1, str2));
	}

	public static String addStrings(String num1, String num2) {
		String str1 = "";
		String str2 = "";
		String res = "";
		// carry:进位
		int carry = 0;
		// 要先判断哪个String对应数字的位数较高
		if (num1.length() > num2.length()) {
			str1 = num1;
			// 给较短的数字头部填0补齐
			for (int i = 0; i < num1.length() - num2.length(); i++)
				str2 += "0";
			str2 += num2;
		} else if (num1.length() < num2.length()) {
			str2 = num2;
			for (int i = 0; i < num2.length() - num1.length(); i++)
				str1 += "0";
			str1 += num1;
		} else {
			str1 = num1;
			str2 = num2;
		}
		
		//补齐之后再开始相加
		for (int i = str1.length() - 1; i >= 0; i--) {
			int tmp = (str1.charAt(i) - '0') + (str2.charAt(i) - '0') + carry;
			res += tmp % 10;
			carry = tmp / 10;
		}
		// 最后如果carry还有,加上carry
		if(carry != 0)
            res += "" + carry;
		
		return new StringBuilder(res).reverse().toString();
	}

	// String转数字,用long
	public static long stringToNumber(String str) {
		long res = 0;
		char[] arr = str.toCharArray();
		int n = arr.length;
		for (int i = n - 1; i >= 0; i--) {
			// 当前字符的数值 * 10^(n-i-1)
			res += (arr[i] - '0') * Math.pow(10, n - i - 1);
		}
		return res;
		// "9333852702227987"
		// "85731737104263"
	}
}
