package leetCode;

import java.util.Stack;

/**
 * 
 * @author louis 2018��11��2��
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

	// �ݹ�
	public boolean hasPathSumRecursion(TreeNode root, int sum) {
		if (root == null)
			return false;
		// �Ѿ�����Ҷ�ӽڵ㣬��sum�ټ�ȥ�ýڵ�ֵΪ0��˵���Ӹ���Ҷ����ôһ��·��
		if (root.left == null && root.right == null && sum - root.val == 0)
			return true;
		// �ֱ�����������ݹ���ã�ע���ȥ���ڵ��ֵ
		return hasPathSumRecursion(root.left, sum - root.val) || hasPathSumRecursion(root.right, sum - root.val);
	}

	// ����,�Ӹ���Ҷ���θ���
	public boolean hasPathSum(TreeNode root, int sum) {
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);
		while (!stack.isEmpty() && root != null) {
			TreeNode cur = stack.pop();
			// ���cur��Ҷ�ӽڵ�
			if (cur.left == null && cur.right == null)
				// 
				if (cur.val == sum)
					return true;
			if (cur.right != null) {// �����������Ϊ��,�������ӽڵ��ֵ,ͬʱ���ӽڵ���ջ
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
