package leetCode;

//�׳�ĩβ0�ĸ�����˼·��5�ı����ĸ���
public class Problem_172_FactorialTrailingZeroes {
	public static void main(String[] args) {
		System.out.println(trailingZeroes(100));
	}

	public static int trailingZeroes(int n) {
		int count = 0;
		while(n >= 5)
			count += (n /= 5);
		return count;
	}
}
