package leetCode;

public class Problem_189_RotateArray {
	public void rotate1(int[] nums, int k) {
		int n = nums.length;
		while(k-- >0) {
			int tmp = nums[n-1];
			for(int i = n - 1; i > 0; i--) {
				nums[i] = nums[i-1];
			}
			nums[0] = tmp;
		}
	}
	
	//reverse
	public void rotate2(int[] nums, int k) {
		k %= nums.length;
		reverse(nums, 0, nums.length-1);
		reverse(nums, 0, k-1);
		reverse(nums, k, nums.length-1);
	}
	
	public static void reverse(int[] nums, int start, int end) {
		while(start < end) {
			int tmp = nums[start];
			nums[start] = nums[end];
			nums[end] = tmp;
			start++;
			end--;
		}
	}
}
