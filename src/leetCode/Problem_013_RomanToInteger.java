package leetCode;


/**
 * 
 * @author louis
 * 2018年10月26日
 * <p>Description: Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.</p>
 * 
 */
public class Problem_013_RomanToInteger {
	public int romanToInt(String s) {
		int[] arr = new int[s.length()];
		for (int i = 0; i < s.length(); i++) {
			switch (s.charAt(i)) {
			case 'I':
				arr[i] = 1;
				break;
			case 'V':
				arr[i] = 5;
				break;
			case 'X':
				arr[i] = 10;
				break;
			case 'L':
				arr[i] = 50;
				break;
			case 'C':
				arr[i] = 100;
				break;
			case 'D':
				arr[i] = 500;
				break;
			case 'M':
				arr[i] = 1000;
				break;

			}
		}
		int sum = 0;
		for (int i = 0; i < arr.length - 1; i++) {
			// 后一位比前一位大则减去前一位的值
			if (arr[i] < arr[i + 1])
				sum -= arr[i];
			// 后一位比前一位小则加上前一位的值
			else
				sum += arr[i];
		}
		// 最后再把最后一位加上
		return sum + arr[arr.length-1];
	}
}
