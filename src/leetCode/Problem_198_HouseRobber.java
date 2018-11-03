package leetCode;
/**
 * 
 * @author louis
 * 2018年11月4日
 * <p>Description: You are a professional robber planning to rob houses along a street. 
 * Each house has a certain amount of money stashed, 
 * the only constraint stopping you from robbing each of them is that adjacent houses have security system connected 
 * and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given a list of non-negative integers representing the amount of money of each house, 
determine the maximum amount of money you can rob tonight without alerting the police.</p>
 */
public class Problem_198_HouseRobber {
	public int rob1(int[] nums) {
		int[][] dp = new int[nums.length + 1][2];
		//如果第一次强,抢到的就是nums[0]
		dp[0][1] = nums[0];
		for (int i = 1; i < nums.length; i++) {
			//dp[i][0]：第i次不抢，那么这里的最大钱数就是i-1次抢或不抢中较大的那个
			dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]);
			//dp[i][1]：第i次抢，那么这里的最大钱数就是i-1次不抢+这次抢的
			dp[i][1] = nums[i-1] + dp[i-1][0];
		}
		return Math.max(dp[nums.length][0], dp[nums.length][1]);
	}
	
	//更清楚的方法
	public int rob2(int[] nums) {
		// 不抢
		int prevNo = 0;
		// 抢
		int prevYes = 0;
		for(int n : nums) {
			// 上次没抢的情况下的钱数需要记录下来
			int tmp = prevNo;
			// 这次如果不抢,总的钱数就是上次抢或不抢中较大值
			prevNo = Math.max(prevNo, prevYes);
			// 这次抢, 钱数就是这间房子的钱数+上次没抢的钱数
			prevYes = n + tmp;
		}
		
		return Math.max(prevNo, prevYes);
	}
}
