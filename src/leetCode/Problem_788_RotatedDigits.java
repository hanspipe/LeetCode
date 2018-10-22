package leetCode;

import java.util.HashSet;
import java.util.Set;

public class Problem_788_RotatedDigits {
	public static void main(String[] args) {
		System.out.println(rotatedDigits(100));
	}

	public static int rotatedDigits(int N) {
		int res = 0;
		for (int i = 1; i <= N; i++) {
			Set<Integer> set = eachDigit(i);
			if ((set.contains(2) || set.contains(5) || set.contains(6) || set.contains(9))
					&& (!set.contains(3) && !set.contains(4) && !set.contains(7)))
				res++;
		}
		return res;
	}

	public static Set<Integer> eachDigit(int num) {
		Set<Integer> set = new HashSet<>();
		while (num != 0) {
			int cur = num % 10;
			num /= 10;
			set.add(cur);
		}
		return set;
	}
}
