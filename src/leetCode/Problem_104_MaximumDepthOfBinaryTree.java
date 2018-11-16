package leetCode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
// ���������
public class Problem_104_MaximumDepthOfBinaryTree {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	// �ݹ�
	public int maxDepth1(TreeNode root) {
		if (root == null)
			return 0;
		else {
			// �ֱ�������������ĸ߶�
			int left_h = maxDepth1(root.left);
			int right_h = maxDepth1(root.right);
			// +1�Ǽ��ϸ��ڵ�
			return Math.max(left_h, right_h) + 1;
		}
	}

	// ������ȷ���
	public int maxDepthBFS(TreeNode root) {
		if (root == null)
			return 0;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		int count = 0;
		while (!queue.isEmpty()) {
			// size��ֵ�������ڵ�ĸ���
			int size = queue.size();
			while (size-- > 0) {
				// ���ڵ�ȫ�����ӣ�Ȼ�������һ��ȫ���ڵ�
				TreeNode node = queue.poll();
				if (node.left != null)
					queue.offer(node.left);
				if (node.right != null)
					queue.offer(node.right);
			}
			// ����+1
			count++;
		}
		return count;
	}

	public int maxDepthDFS(TreeNode root) {
		if (root == null)
			return 0;
		Stack<TreeNode> stack = new Stack<>();
		Stack<Integer> value = new Stack<>();
		stack.push(root);
		value.push(1);
		int max = 0;
		while (!stack.isEmpty()) {
			TreeNode node = stack.pop();
			int tmp = value.pop();
			max = Math.max(tmp, max);
			if (node.left != null) {
				stack.push(node.left);
				value.push(tmp + 1);
			}
			if (node.right != null) {
				stack.push(node.right);
				value.push(tmp + 1);
			}
		}
		return max;
	}
}
