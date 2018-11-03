package leetCode;

/**
 * 
 * @author louis
 * 2018��11��4��
 * <p>Description: Write a program to check whether a given number is an ugly number.

	Ugly numbers are positive numbers whose prime factors only include 2, 3, 5.</p>
 */
public class Problem_263_UglyNumber {
	public static void main(String[] args) {
		System.out.println(isUgly(8));
	}

	// ������2,3,5���ӳ���, �ж����ʣ�µ��ǲ���1
	public static boolean isUgly(int num) {
		if (num == 0)
			return false;
		while (num % 2 == 0)
			num = num >> 1;
		while (num % 3 == 0)
			num = num / 3;
		while (num % 5 == 0)
			num = num / 5;
		return num == 1;
	}
}
