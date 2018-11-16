package leetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
/**
 * 
 * @author louis
 * 2018年11月15日
 * <p>Description: N叉树层序遍历 使用队列</p>
 */
public class Problem_429_NaryTreeLevelOrderTraversal {

	class Node {
		public int val;
		public List<Node> children;

		public Node() {
		}

		public Node(int _val, List<Node> _children) {
			val = _val;
			children = _children;
		}
	}

	public List<List<Integer>> levelOrder(Node root) {
		List<List<Integer>> res = new ArrayList<>();
		if (root == null)
			return res;
		Queue<Node> queue = new LinkedList<>();
		// 先把根节点加入队列
		queue.add(root);
		while (!queue.isEmpty()) {
			// 保存每一层的节点值
			List<Integer> currLevel = new ArrayList<>();
			// 当前层的节点个数
			int size = queue.size();
			// 在队列中遍历当前层的节点
			for (int i = 0; i < size; i++) {
				Node node = queue.poll();
				// 节点值加入currLevel
				currLevel.add(node.val);
				// 每个节点的所有孩子都入队
				for (Node n : node.children)
					queue.offer(n);
			}
			// 最后把当前层所有节点值加入res
			res.add(currLevel);
		}
		return res;
	}
}
