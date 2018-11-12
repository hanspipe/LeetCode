package leetCode;

import java.util.Deque;
import java.util.LinkedList;
/**
 * 
 * @author louis
 * 2018年11月12日
 * <p>Description: Given an integer array with no duplicates. A maximum tree building on this array is defined as follow:

	The root is the maximum number in the array.

	1.The left subtree is the maximum tree constructed from left part subarray divided by the maximum number.
	
	2.The right subtree is the maximum tree constructed from right part subarray divided by the maximum number.
	
	3.Construct the maximum tree by the given array and output the root node of this tree.</p>
 */
public class Problem_654_MaximumBinaryTree {

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	//[3,2,1,6,0,5]
	
	public TreeNode constructMaximumBinaryTree(int[] nums) {
		Deque<TreeNode> stack = new LinkedList<>();
		for (int i = 0; i < nums.length; i++) {
			// 数组当前值初始化一个节点
			TreeNode cur = new TreeNode(nums[i]);
			// 
			while(!stack.isEmpty() && stack.peek().val < nums[i]) {
				cur.left = stack.pop();
			}
			if(!stack.isEmpty())
				stack.peek().right = cur;
			stack.push(cur);
		}
		return stack.isEmpty() ? null : stack.removeLast();
	}
}
