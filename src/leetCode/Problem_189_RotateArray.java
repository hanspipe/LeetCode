package leetCode;

//Given an array, rotate the array to the right by k steps, where k is non-negative.
//Input: [1,2,3,4,5,6,7] and k = 3
//Output: [5,6,7,1,2,3,4]
public class Problem_189_RotateArray {
	public void rotate1(int[] nums, int k) {
		int n = nums.length;
		while (k-- > 0) {
			// �Ȱ����һ��ֵ��¼����
			int tmp = nums[n - 1];
			//ÿ��ֵ����
			for (int i = n - 1; i > 0; i--) {
				nums[i] = nums[i - 1];
			}
			// ����ԭ�������һ������0λ��
			nums[0] = tmp;
		}
	}

	// reverse
	public void rotate2(int[] nums, int k) {
		k %= nums.length;
		// �ȷ�ת��������
		reverse(nums, 0, nums.length - 1);
		// �ٷ�תǮk��
		reverse(nums, 0, k - 1);
		// �ڷ�ת��ʣ�µ�
		reverse(nums, k, nums.length - 1);
	}

	public static void reverse(int[] nums, int start, int end) {
		while (start < end) {
			int tmp = nums[start];
			nums[start] = nums[end];
			nums[end] = tmp;
			start++;
			end--;
		}
	}
}
