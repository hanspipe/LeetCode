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
			// �ڵ����,��ѹջ
			while(node != null) {
				stack.push(node);
				//һ·��������, ��Ϊ�Һ��ӱȵ�ǰ�ڵ��
				node = node.right;
			}
			
			node = stack.pop();
			// ���µ�ǰ�ڵ��ֵ
			sum += node.val;
			node.val = sum;
			// �ٴ�������
			node = node.left;
		}
		
		return root;
	}
}
