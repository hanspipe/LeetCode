package leetCode;

import java.util.HashSet;
import java.util.Set;

public class Problem_202_HappyNumber {
	public boolean isHappy(int n) {
		Set<Integer> set = new HashSet<>();
		int squareSum;
		while(set.add(n)) {
			squareSum = 0;
			while(n != 0) {
				int remain = n % 10;
				squareSum += remain * remain;
				n /= 10;
			}
			if(squareSum == 1)
				return true;
			else
				n = squareSum;
		}
		return false;
	}
}
