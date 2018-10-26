package leetCode;

/**
 * 
 * @author louis
 * 2018年10月26日
 * <p>Description: Given an integer array nums, find the contiguous subarray (containing at least one number) 
 * 		which has the largest sum and return its sum.</p>
 */
public class Problem_053_MaximumSubarray {
	public static void main(String[] args) {
		int[] arr = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
		System.out.println(maxSubArrayDP(arr));
	}

	public static int maxSubArray(int[] nums) {
		// 目前为止的最大值
		int maxSoFar = nums[0];
		// 
		int maxEndHere = nums[0];
		for (int i = 1; i < nums.length; i++) {
			// 如果加上这个值会变小(nums[i] < 0) maxEndHere就会更新成当前元素
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
