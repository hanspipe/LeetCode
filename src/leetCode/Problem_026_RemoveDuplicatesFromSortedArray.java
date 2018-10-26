package leetCode;

public class Problem_026_RemoveDuplicatesFromSortedArray {
	public int removeDuplicates(int[] nums) {
		int i = 0;
		for (int j = 1; j < nums.length; j++) {
			if (nums[i] != nums[j]) {
				nums[i + 1] = nums[j];
				i++;
			}
			// 如果条件不满足，则j往后走，i不动，直到nums[i] != nums[j]
			// 然后i后面接一个nums[j]
		}
		return i + 1;
	}
}
