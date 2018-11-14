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
		// �����ǰ�ڵ��������
		if (root.left != null) {
			// �ҵ�ǰ�ڵ���Ҷ�ӽڵ�
			if (root.left.left == null && root.left.right == null)
				// �������ӵ�ֵ
				res += root.left.val;
			else// ���Ӳ���Ҷ�ӽڵ�,�͵ݹ����һ��
				res += sumOfLeftLeaves(root.left);
		}

		// ���������ݹ�һ��.
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
			// ��ǰ�ڵ�������
			if (node.left != null) {
				// ��ǰ�ڵ��������Ҷ�ڵ�
				if (node.left.left == null && node.left.right == null)
					// ֵ����ans
					ans += node.left.val;
				else
					// ��ǰ�ڵ�����Ӳ���Ҷ�ڵ�,����ջ
					stack.push(node.left);
			}
			// ��ǰ�ڵ����Һ���
			if(node.right != null) {
				// �Һ��Ӳ���Ҷ�ڵ�
				if (node.right.left != null || node.right.right != null) {
					// ��ջ
					stack.push(node.right);
				}
			}
		}
		return ans;
	}
}
