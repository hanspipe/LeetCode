package leetCode;

import java.util.Deque;
import java.util.LinkedList;

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
			TreeNode cur = new TreeNode(nums[i]);
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
