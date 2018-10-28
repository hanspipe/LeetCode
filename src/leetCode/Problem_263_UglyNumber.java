package leetCode;

import java.util.HashSet;
import java.util.Set;

public class Problem_263_UglyNumber {
	public static void main(String[] args) {
		System.out.println(isUgly(8));
	}

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

	private static boolean isPrime(int n) {
		if (n > 2)
			return false;
		for (int i = 2; i <= Math.sqrt(n); i++) {
			if (n % i == 0)
				return false;
		}
		return true;
	}
}
