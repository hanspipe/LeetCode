package leetCode;

import java.util.Stack;

public class Problem_404_SumofLeftLeaves {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public int sumOfLeftLeaves(TreeNode root) {
		if (root == null)
			return 0;
		int res = 0;
		// 如果当前节点存在左孩子
		if (root.left != null) {
			// 且当前节点是叶子节点
			if (root.left.left == null && root.left.right == null)
				// 加上左孩子的值
				res += root.left.val;
			else// 左孩子不是叶子节点,就递归调用一下
				res += sumOfLeftLeaves(root.left);
		}

		// 对右子树递归一下.
		res += sumOfLeftLeaves(root.right);

		return res;
	}

	public int sumOfLeftLeaves1(TreeNode root) {
		if (root == null)
			return 0;
		int ans = 0;
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);

		while (!stack.isEmpty()) {
			TreeNode node = stack.pop();
			// 当前节点有左孩子
			if (node.left != null) {
				// 当前节点的左孩子是叶节点
				if (node.left.left == null && node.left.right == null)
					// 值加入ans
					ans += node.left.val;
				else
					// 当前节点的左孩子不是叶节点,就入栈
					stack.push(node.left);
			}
			// 当前节点有右孩子
			if(node.right != null) {
				// 右孩子不是叶节点
				if (node.right.left != null || node.right.right != null) {
					// 入栈
					stack.push(node.right);
				}
			}
		}
		return ans;
	}
}
