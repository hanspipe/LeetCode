package leetCode;

public class Problem_053_MaximumSubarray {
	public static void main(String[] args) {
		int[] arr = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
		System.out.println(maxSubArrayDP(arr));
	}

	public static int maxSubArray(int[] nums) {
		int maxSoFar = nums[0];
		int maxEndHere = nums[0];
		for (int i = 1; i < nums.length; i++) {
			maxEndHere = Math.max(nums[i], nums[i] + maxEndHere);
			maxSoFar = Math.max(maxEndHere, maxSoFar);
		}
		return maxSoFar;
	}
	
	public static int maxSubArrayDP(int[] nums) {
		int n = nums.length;
		int[] dp = new int[n];
		dp[0] = nums[0];
		int max = nums[0];
		for(int i = 1; i < n; i++) {
			dp[i] = Math.max(nums[i], nums[i]+dp[i-1]);
			max = Math.max(max, dp[i]);
		}
		return max;
	}
}
