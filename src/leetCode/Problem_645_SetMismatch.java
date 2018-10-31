package leetCode;

public class Problem_645_SetMismatch {
	public int[] findErrorNums(int[] nums) {
		int[] res = new int[2];
		int[] arr = new int[nums.length + 1];
		for (int n : nums)
			arr[n]++;

		for (int i = 1; i < arr.length; i++) {
			if(arr[i] == 0)
				res[1] = i;
			if(arr[i] == 2)
				res[0] = i;
		}

		return res;
	}
}
