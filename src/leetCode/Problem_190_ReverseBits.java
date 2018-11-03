package leetCode;
//Reverse bits of a given 32 bits unsigned integer.
public class Problem_190_ReverseBits {
	public static void main(String[] args) {
		System.out.println(reverseBits(1));
	}

	public static int reverseBits(int n) {
		int res = 0;
		int[] arr = new int[32];
		// 32λ
		for (int i = 31; i >= 0; i--) {
			arr[i] = n % 2;
			n /= 2;
			// ���϶�Ӧλ�õ�0��1������Ȩֵ
			res += Math.pow(2, i) * arr[i]; 
		}
		
		return res;
	}
}
