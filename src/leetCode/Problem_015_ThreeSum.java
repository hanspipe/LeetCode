package leetCode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 
 * @author louis
 * 2018��10��26��
 * <p>Description:Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? 
 * Find all unique triplets in the array which gives the sum of zero. </p>
 * �ҵ����������������Ϊ0�����
 */
public class Problem_015_ThreeSum {
	public List<List<Integer>> threeSum(int[] nums) {
		// ������
		Arrays.sort(nums);
		List<List<Integer>> res = new LinkedList<>();
		for (int i = 0; i < nums.length - 2; i++) {
			//i > 0 && nums[i] != nums[i - 1] ����ͬ��ֵ������
			if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
				// sum = 0 - nums[i]ת��������֮�͵�����
				int lo = i + 1, hi = nums.length - 1, sum = 0 - nums[i];
				while (lo < hi) {
					if (nums[lo] + nums[hi] == sum) {
						// �з��������ľͼ��뼯��
						res.add(Arrays.asList(nums[i], nums[lo], nums[hi]));
						// ����һ������ͬ������
						while (lo < hi && nums[lo] == nums[lo + 1])
							lo++;
						while (lo < hi && nums[hi] == nums[hi - 1])
							hi--;
						// ��lo��hi�ҵ��µ�λ��
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
