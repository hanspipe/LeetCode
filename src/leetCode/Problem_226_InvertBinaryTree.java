package leetCode;

import java.util.LinkedList;
import java.util.Queue;

public class Problem_226_InvertBinaryTree {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	// recursion
	public TreeNode invertTree(TreeNode root) {
		if(root == null)
			return null;
		TreeNode left = invertTree(root.left);
		TreeNode right = invertTree(root.right);
		root.left = right;
		root.right = left;
		
		return root;
	}
	
	// iteration
	public TreeNode invertTree1(TreeNode root) {
		if(root == null)
			return null;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		while(!queue.isEmpty()) {
			// 对当前节点
			TreeNode node = queue.poll();
			// 交换左右子树
			TreeNode temp = node.left;
			node.left = node.right;
			node.right = temp;
			// 将交换后的左右子树入队
			if(node.left != null)
				queue.add(node.left);
			if(node.right != null)
				queue.add(node.right);
		}
		return root;
	}

}