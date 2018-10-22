package leetCode;

public class Problem_908_SmallestRangeI {
	public int smallestRangeI(int[] A, int K) {
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < A.length; i++) {
			min = Math.min(min, A[i]);
			max = Math.max(max, A[i]);
		}
		if (max - min <= 2 * K)
			return 0;
		else
			return (max - min - 2 * K);

	}
}
