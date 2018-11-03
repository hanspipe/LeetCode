package leetCode;
//Reverse bits of a given 32 bits unsigned integer.
public class Problem_190_ReverseBits {
	public static void main(String[] args) {
		System.out.println(reverseBits(1));
	}

	public static int reverseBits(int n) {
		int res = 0;
		int[] arr = new int[32];
		// 32位
		for (int i = 31; i >= 0; i--) {
			arr[i] = n % 2;
			n /= 2;
			// 加上对应位置的0或1乘以其权值
			res += Math.pow(2, i) * arr[i]; 
		}
		
		return res;
	}
}
