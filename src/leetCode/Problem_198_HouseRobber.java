package leetCode;
/**
 * 
 * @author louis
 * 2018��11��4��
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
		//�����һ��ǿ,�����ľ���nums[0]
		dp[0][1] = nums[0];
		for (int i = 1; i < nums.length; i++) {
			//dp[i][0]����i�β�������ô��������Ǯ������i-1���������нϴ���Ǹ�
			dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1]);
			//dp[i][1]����i��������ô��������Ǯ������i-1�β���+�������
			dp[i][1] = nums[i-1] + dp[i-1][0];
		}
		return Math.max(dp[nums.length][0], dp[nums.length][1]);
	}
	
	//������ķ���
	public int rob2(int[] nums) {
		// ����
		int prevNo = 0;
		// ��
		int prevYes = 0;
		for(int n : nums) {
			// �ϴ�û��������µ�Ǯ����Ҫ��¼����
			int tmp = prevNo;
			// ����������,�ܵ�Ǯ�������ϴ��������нϴ�ֵ
			prevNo = Math.max(prevNo, prevYes);
			// �����, Ǯ��������䷿�ӵ�Ǯ��+�ϴ�û����Ǯ��
			prevYes = n + tmp;
		}
		
		return Math.max(prevNo, prevYes);
	}
}
