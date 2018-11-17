package leetCode;

import leetCode.Problem_437_PathSumIII.TreeNode;

/**
 * 
 * @author louis 2018年11月17日
 *         <p>
 *         Description: Given a binary tree containing digits from 0-9 only,
 *         each root-to-leaf path could represent a number.
 * 
 *         An example is the root-to-leaf path 1->2->3 which represents the
 *         number 123.
 * 
 *         Find the total sum of all root-to-leaf numbers.
 * 
 *         Note: A leaf is a node with no children.
 *         </p>
 */
public class Problem_129_SumRootToLeafNumbers {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public int sumNumbers(TreeNode root) {
		return sum(root, 0);
	}

	// s:上一个节点的结果
	public int sum(TreeNode n, int s) {
		if (n == null)
			return 0;
		if (n.right == null && n.left == null)
			return s * 10 + n.val;
		return sum(n.left, s * 10 + n.val) + sum(n.right, s * 10 + n.val);
	}
}
