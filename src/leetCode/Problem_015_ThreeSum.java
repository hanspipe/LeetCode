package leetCode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 
 * @author louis
 * 2018年10月26日
 * <p>Description:Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? 
 * Find all unique triplets in the array which gives the sum of zero. </p>
 * 找到数组中三个数相加为0的组合
 */
public class Problem_015_ThreeSum {
	public List<List<Integer>> threeSum(int[] nums) {
		// 先排序
		Arrays.sort(nums);
		List<List<Integer>> res = new LinkedList<>();
		for (int i = 0; i < nums.length - 2; i++) {
			//i > 0 && nums[i] != nums[i - 1] 有相同的值就跳过
			if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
				// sum = 0 - nums[i]转换成两数之和的问题
				int lo = i + 1, hi = nums.length - 1, sum = 0 - nums[i];
				while (lo < hi) {
					if (nums[lo] + nums[hi] == sum) {
						// 有符合条件的就加入集合
						res.add(Arrays.asList(nums[i], nums[lo], nums[hi]));
						// 与下一个数相同就跳过
						while (lo < hi && nums[lo] == nums[lo + 1])
							lo++;
						while (lo < hi && nums[hi] == nums[hi - 1])
							hi--;
						// 让lo和hi找到新的位置
						lo++;
						hi--;
					} else if (nums[lo] + nums[hi] < sum)
						lo++;
					else
						hi--;
				}
			}
		}
		return res;
	}
}
