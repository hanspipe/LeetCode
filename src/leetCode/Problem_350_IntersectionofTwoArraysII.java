package leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * @author louis 2018Äê11ÔÂ16ÈÕ
 *         <p>
 *         Description: Given two arrays, write a function to compute their
 *         intersection.
 *         </p>
 */
public class Problem_350_IntersectionofTwoArraysII {
	public int[] intersect(int[] nums1, int[] nums2) {
		Map<Integer, Integer> map = new HashMap<>();
		List<Integer> res = new ArrayList<>();

		for (int n : nums1) {
			if (map.containsKey(n)) {
				map.put(n, map.get(n) + 1);
			} else
				map.put(n, 1);
		}

		for (int n : nums2) {
			if (map.containsKey(n) && map.get(n) > 0) {
				res.add(n);
				map.put(n, map.get(n) - 1);
			}
		}
		int[] arr = new int[res.size()];
		for(int i = 0; i < res.size(); i++)
			arr[i] = res.get(i);
		return arr;
	}
}
