package leetCode;

/**
 * 
 * @author louis
 * 2018年11月5日
 * <p>Description: Given two strings representing two complex numbers.

	You need to return a string representing their multiplication. 

	Note i2 = -1 according to the definition.</p>
 */
/*
 * Input: "1+-1i", "1+-1i"
	Output: "0+-2i"
 */
public class Problem_537_ComplexNumberMultiplication {
	public String complexNumberMultiply(String a, String b) {
		String result = "";
		String[] A = a.split("\\+");
		String[] B = b.split("\\+");
		// 实数部分转化成数字
		int a1 = Integer.parseInt(A[0]);
		// 叙述部分,先去掉i,再转化成数字
		int b1 = Integer.parseInt(A[1].replace("i", ""));

		int a2 = Integer.parseInt(B[0]);
		int b2 = Integer.parseInt(B[1].replace("i", ""));

		int a1a2 = a1 * a2;
		int b1b2 = b1 * b2;
		
		int a1b2a2b1 = (a1 * b2) + (b1 * a2);
		
		result = "" + (a1a2-b1b2) + "+" + a1b2a2b1 + "i" ;
		return result;

	}
}
