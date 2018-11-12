package leetCode;
/**
 * 
 * @author louis
 * 2018Äê11ÔÂ12ÈÕ
 * <p>Description: The set S originally contains numbers from 1 to n. 
 * 
 * But unfortunately, due to the data error, one of the numbers in the set got duplicated to another number in the set,
 * 
 *  which results in repetition of one number and loss of another number.

	Given an array nums representing the data status of this set after the error. 

	Your task is to firstly find the number occurs twice and then find the number that is missing. Return them in the form of an array.</p>
 */
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
