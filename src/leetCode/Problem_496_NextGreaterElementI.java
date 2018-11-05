package leetCode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
/**
 * 
 * @author louis
 * 2018��11��5��
 * <p>Description: You are given two arrays (without duplicates) nums1 and nums2 where nums1��s elements are subset of nums2. 
 * 
 * 	Find all the next greater numbers for nums1's elements in the corresponding places of nums2.

	The Next Greater Number of a number x in nums1 is the first greater number to its right in nums2. 

	If it does not exist, output -1 for this number.</p>
 */
public class Problem_496_NextGreaterElementI {
	
	public static void main(String[] args) {
		int[] arr1 = {4,1,2};
		int[] arr2 = {1,3,4,2,5};
		int[] res = nextGreaterElement(arr1, arr2);
		for(int i : res)
			System.out.print(i + " ");
	}
	public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
		Map<Integer, Integer> map = new HashMap<>();
		Stack<Integer> stack = new Stack<>();
		for(int num : nums2) {
			// ���ջ��Ϊ����ջ��Ԫ��С��nums2�ĵ�ǰֵ
			// �жϵ�ǰֵ�Ƿ����ջ��,�Ǿͳ�ջ�Ҽ���map,ֱ����ǰֵ������ջ����ջΪ��
			// ����value����key���ұߵ�һ���������ֵ
			while(!stack.isEmpty() && stack.peek() < num) {
				// (ջ��, num)����map
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
