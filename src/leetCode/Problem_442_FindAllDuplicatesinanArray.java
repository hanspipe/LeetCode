package leetCode;

import java.util.ArrayList;
import java.util.List;
/**
 * 
 * @author louis
 * 2018Äê11ÔÂ4ÈÕ
 * <p>Description:Given an array of integers, 
 * 
 * 1 ¡Ü a[i] ¡Ü n (n = size of array), 
 * 
 * some elements appear twice and others appear once.

	Find all the elements that appear twice in this array. </p>
 */
public class Problem_442_FindAllDuplicatesinanArray {
	public List<Integer> findDuplicates(int[] nums) {
		List<Integer> res = new ArrayList<>();
        for(int i = 0; i < nums.length;i++){
        	int index = Math.abs(nums[i] - 1);
        	if(nums[index] < 0)
        		res.add(Math.abs(index+1));
        	nums[index] = -nums[index];
        }
		return res;
    }
}
