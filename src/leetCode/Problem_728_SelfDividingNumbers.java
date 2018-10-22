package leetCode;

import java.util.ArrayList;
import java.util.List;

public class Problem_728_SelfDividingNumbers {
	public List<Integer> selfDividingNumbers(int left, int right) {
		List<Integer> list = new ArrayList<>();
		for(int i = left; i <= right; i++) {
			if(isSelfDividingNumber(i))
				list.add(i);
		}
		return list;
	}

	public static boolean isSelfDividingNumber(int n) {
		int m = n;
		while (n != 0) {
			int a = n % 10;
			n /= 10;
			if (a != 0 && m % a == 0)
				continue;
			else
				return false;
		}
		return true;

	}
}
