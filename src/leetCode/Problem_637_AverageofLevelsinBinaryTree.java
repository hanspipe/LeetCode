package leetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Problem_637_AverageofLevelsinBinaryTree {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public List<Double> averageOfLevels(TreeNode root) {
		List<Double> res = new ArrayList<>();
		if(root == null)
			return res;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.offer(root);
		while(!queue.isEmpty()) {
			long sum = 0;
			int size = queue.size();
			for(int i =0; i < size; i++) {
				TreeNode node = queue.poll();
				sum += node.val;
				if(node.left != null)
					queue.offer(node.left);
				if(node.right != null)
					queue.offer(node.right);
			}
			res.add(sum * 1.0 / size);
		}
		return res;
	}
}
