package leetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Problem_102_BinaryTreeLevelOrderTraversal {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
	public List<List<Integer>> levelOrder(TreeNode root) {
		
		List<List<Integer>> res = new ArrayList<>();
		if(root == null)
			return res;
		// 用一个队列保存当前层的所有节点
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		while(!queue.isEmpty()) {
			// levelNum:当前层的节点个数
			int levelNum = queue.size();
			List<Integer> level = new ArrayList<>();
			// 当前层的所有子节点
			for(int i = 0; i < levelNum; i++) {
				if(queue.peek().left != null)
					queue.offer(queue.peek().left);
				if(queue.peek().right != null)
					queue.offer(queue.peek().right);
				level.add(queue.poll().val);
			}
			res.add(level);
		}
		return res;
	}
}
