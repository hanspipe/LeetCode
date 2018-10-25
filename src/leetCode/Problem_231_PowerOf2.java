package leetCode;

public class Problem_231_PowerOf2 {
	public boolean isPowerOfTwo(int n) {
		
		return n > 0 && Integer.bitCount(n) == 1;
	}
	
	//iterative
	public boolean isPowerOfTwo1(int n) {
		if(n == 0)
			return false;
		while(n % 2 == 0)
			n /= 2;
		return n == 1;
	}
}
