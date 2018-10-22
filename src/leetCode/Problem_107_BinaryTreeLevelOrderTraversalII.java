package leetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Problem_107_BinaryTreeLevelOrderTraversalII {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		List<List<Integer>> res = new ArrayList<>();
		Stack<List<Integer>> stack = new Stack<>();
		Queue<TreeNode> queue = new LinkedList<>();
		if(root == null)
			return res;
		queue.add(root);
		while(!queue.isEmpty()) {
			int size = queue.size();
			List<Integer> list = new ArrayList<>();
			while(size-- > 0) {
				TreeNode node = queue.poll();
				list.add(node.val);
				if(node.left != null)
					queue.offer(node.left);
				if(node.right != null)
					queue.offer(node.right);
			}
			stack.push(list);
		}
		while(!stack.isEmpty())
			res.add(stack.pop());
		return res;
	}
}
