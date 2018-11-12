package leetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
/**
 * 
 * @author louis
 * 2018��11��5��
 * <p>Description: We define a harmonious array is an array where the difference between 
 * 
 * its maximum value and its minimum value is exactly 1.

	Now, given an integer array, you need to find the length of its 

	longest harmonious subsequence among all its possible subsequences.</p>
 */
public class Problem_594_LongestHarmoniousSubsequence {

	// ����
	public int findLHS1(int[] nums) {
		int res = 0;
		for (int i = 0; i < nums.length; i++) {
			int count = 0;
			boolean flag = false;
			for (int j = 0; j < nums.length; j++) {
				if (nums[j] == nums[i])
					count++;
				else if (nums[j] + 1 == nums[i]) {
					flag = true;
					count++;
				}
			}
			if (flag)
				res = Math.max(res, count);
		}
		return res;
	}

	// ������
	public int findLHS2(int[] nums) {
		Arrays.sort(nums);
		int res = 0;
		// prev_count: �����Ǹ����ĸ���
		int prev_count = 1;
		for (int i = 0; i < nums.length; i++) {
			// ǰ���Ǹ����ĸ���
			int count = 1;
			if (i > 0 && nums[i] - nums[i - 1] == 1) {
				while (i < nums.length - 1 && nums[i] == nums[i + 1]) {
					count++;
					i++;
				}
				// count + prev_count���ǵ�ǰ���harmonious subsequence�ĳ���
				res = Math.max(res, count + prev_count);
				// ����prev_count
				prev_count = count;
			} else {// 
				while (i < nums.length - 1 && nums[i] == nums[i + 1]) {
					count++;
					i++;
				}
				prev_count = count;
			}
		}
		return res;

	}

	// HashMap
	public int findLHS3(int[] nums) {
		int res = 0;
		Map<Integer, Integer> map = new HashMap<>();
		// ÿ����������ֵĴ�������map
		for (int n : nums)
			map.put(n, map.getOrDefault(n, 0) + 1);

		// ����key
		for (Integer key : map.keySet()) {
			// 
			if (map.containsKey(key + 1))
				res = Math.max(res, map.get(key) + map.get(key + 1));
		}
		return res;
	}
}
