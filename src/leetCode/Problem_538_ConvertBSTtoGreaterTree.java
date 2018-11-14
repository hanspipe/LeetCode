package leetCode;

import java.util.Stack;

public class Problem_538_ConvertBSTtoGreaterTree {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	// recursion
	public TreeNode convertBST(TreeNode root) {
		int sum = 0;
		if (root != null) {
			convertBST(root.right);
			sum += root.val;
			root.val = sum;
			convertBST(root.left);
		}
		return root;
	}

	// iteration
	public TreeNode convertBST1(TreeNode root) {
		int sum = 0;
		TreeNode node = root;
		Stack<TreeNode> stack = new Stack<>();
		
		while(!stack.isEmpty() || node != null)
		{
			while(node != null) {
				stack.push(node);
				node = node.right;
			}
			
			node = stack.pop();
			sum += node.val;
			node.val = sum;
			
			node = node.left;
		}
		
		return root;
	}
}
