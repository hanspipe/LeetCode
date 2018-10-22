package leetCode;

import java.util.Stack;

public class Problem_112_PathSum {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	//µÝ¹é
	public boolean hasPathSumRecursion(TreeNode root, int sum) {
		if (root == null)
			return false;
		if (root.left == null && root.right == null && sum - root.val == 0)
			return true;
		return hasPathSumRecursion(root.left, sum - root.val) || hasPathSumRecursion(root.right, sum - root.val);
	}
	
	//µü´ú
	public boolean hasPathSum(TreeNode root, int sum) {
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);
		while(!stack.isEmpty() && root != null) {
			TreeNode cur = stack.pop();
			if(cur.left == null && cur.right == null)
				if(cur.val == sum)
					return true;
			if(cur.right != null) {
				cur.right.val = cur.val + cur.right.val;
				stack.push(cur.right);
			}
			if(cur.left != null) {
				cur.left.val = cur.val + cur.left.val;
				stack.push(cur.left);
			}
			
		}
		return false;
	}
}
