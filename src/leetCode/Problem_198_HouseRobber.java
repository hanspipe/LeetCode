package leetCode;

public class Problem_198_HouseRobber {
	public int rob1(int[] nums) {
		int[][] dp = new int[nums.length + 1][2];
		dp[0][1] = nums[0];
		for (int i = 1; i < nums.length; i++) {
			//dp[i][0]����һ�β�������ô��������Ǯ��������һ���������нϴ���Ǹ�
			//dp[i][1]����һ��������ô��������Ǯ��������һ�β���+�������
			dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]);
			dp[i][1] = nums[i-1] + dp[i-1][0];
		}
		return Math.max(dp[nums.length][0], dp[nums.length][1]);
	}
	
	public int rob2(int[] nums) {
		int prevNo = 0;
		int prevYes = 0;
		for(int n : nums) {
			int tmp = prevNo;
			prevNo = Math.max(prevNo, prevYes);
			prevYes = n + tmp;
		}
		
		return Math.max(prevNo, prevYes);
	}
}
