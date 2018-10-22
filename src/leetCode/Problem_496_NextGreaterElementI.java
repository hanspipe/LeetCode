package leetCode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Problem_496_NextGreaterElementI {
	
	public static void main(String[] args) {
		int[] arr1 = {4,1,2};
		int[] arr2 = {1,3,4,2};
		int[] res = nextGreaterElement(arr1, arr2);
		for(int i : res)
			System.out.print(i + " ");
	}
	public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
		Map<Integer, Integer> map = new HashMap<>();
		Stack<Integer> stack = new Stack<>();
		for(int num : nums2) {
			while(!stack.isEmpty() && stack.peek() < num) {
				map.put(stack.pop(), num);
			}
			stack.push(num);
		}
		
		for(int i = 0; i < nums1.length; i++) {
			nums1[i] = map.getOrDefault(nums1[i], -1);
		}
		return nums1;
	}
}
