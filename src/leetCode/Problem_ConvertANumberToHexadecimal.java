package leetCode;

public class Problem_ConvertANumberToHexadecimal {
	public static void main(String[] args) {
		System.out.println(toHex(-2));
	}
	public static String toHex(int num) {
		char[] arr = {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f' };
		StringBuilder answer = new StringBuilder();
		if (num == 0) {
			return "0";
		}
		while (num != 0) {
			answer.insert(0, arr[(16 + num % 16) % 16]);
			num = num >>> 4;
		}

		return answer.toString();

	}
}
