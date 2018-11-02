package leetCode;

import java.util.Stack;

/**
 * 
 * @author louis 2018年11月2日
 *         <p>
 *         Description:Given a binary tree and a sum, determine if the tree has
 *         a root-to-leaf path such that adding up all the values along the path
 *         equals the given sum.
 *         </p>
 */
public class Problem_112_PathSum {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	// 递归
	public boolean hasPathSumRecursion(TreeNode root, int sum) {
		if (root == null)
			return false;
		// 已经到了叶子节点，且sum再减去该节点值为0，说明从根到叶有这么一条路径
		if (root.left == null && root.right == null && sum - root.val == 0)
			return true;
		// 分别对左右子树递归调用，注意减去根节点的值
		return hasPathSumRecursion(root.left, sum - root.val) || hasPathSumRecursion(root.right, sum - root.val);
	}

	// 迭代,从根道叶依次更新
	public boolean hasPathSum(TreeNode root, int sum) {
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);
		while (!stack.isEmpty() && root != null) {
			TreeNode cur = stack.pop();
			// 如果cur是叶子节点
			if (cur.left == null && cur.right == null)
				// 
				if (cur.val == sum)
					return true;
			if (cur.right != null) {// 如果右子树不为空,更新右子节点的值,同时右子节点入栈
				cur.right.val = cur.val + cur.right.val;
				stack.push(cur.right);
			}
			if (cur.left != null) {
				cur.left.val = cur.val + cur.left.val;
				stack.push(cur.left);
			}

		}
		return false;
	}
}
