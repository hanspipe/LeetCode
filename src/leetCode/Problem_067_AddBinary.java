package leetCode;

//Given two binary strings, 
//return their sum (also a binary string).

public class Problem_067_AddBinary {
	//可能溢出
	public String addBinary1(String a, String b) {
		int A = Integer.parseInt(a, 2);
		int B = Integer.parseInt(b, 2);

		return Integer.toBinaryString(A + B);
	}

	public String addBinary(String a, String b) {
		StringBuilder sb = new StringBuilder();
		int i = a.length() - 1;
		int j = b.length() - 1;
		//carry:进位
		int carry = 0;
		while(i >= 0 || j >=0) {
			//把上一次的进位赋给sum，参与下一次运算
			int sum = carry;
			if(j >= 0)
				sum += b.charAt(j--) - '0';
			if(i >= 0)
				sum += a.charAt(i--) - '0';
			sb.append(sum % 2);
			carry = sum / 2;
		}
		//最后一次，如果进位还存在就加上
		if(carry != 0)
			sb.append(carry);
		return sb.reverse().toString();
	}
}
