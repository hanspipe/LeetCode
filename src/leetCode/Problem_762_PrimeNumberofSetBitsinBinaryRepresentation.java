package leetCode;

public class Problem_762_PrimeNumberofSetBitsinBinaryRepresentation {
	public int countPrimeSetBits(int L, int R) {
		int res = 0;
		for(int i = L; i <= R; i++) {
			if(isPrime(setNums(i)))
				res++;
		}
		return res;
			
	}

	public static boolean isPrime(int n) {
		if (n < 2)
			return false;
		for (int i = 2; i < n/2; i++) {
			if (n % i == 0)
				return false;
		}
		return true;
	}
	
	public static int setNums(int n) {
		int res = 0;
		while(n != 0) {
			n  = n & (n -1);
			res++;
		}
		return res;
	}
}
