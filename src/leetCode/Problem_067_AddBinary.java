package leetCode;

public class Problem_067_AddBinary {
	public String addBinary1(String a, String b) {
		int A = Integer.parseInt(a, 2);
		int B = Integer.parseInt(b, 2);

		return Integer.toBinaryString(A + B);
	}

	public String addBinary(String a, String b) {
		StringBuilder sb = new StringBuilder();
		int i = a.length() - 1;
		int j = b.length() - 1;
		int carry = 0;
		while(i >= 0 || j >=0) {
			int sum = carry;
			if(j >= 0)
				sum += b.charAt(j--) - '0';
			if(i >= 0)
				sum += a.charAt(i--) - '0';
			sb.append(sum % 2);
			carry = sum / 2;
		}
		if(carry != 0)
			sb.append(carry);
		return sb.reverse().toString();
	}
}
