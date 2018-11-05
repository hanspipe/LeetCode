package leetCode;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 
 * @author louis 2018年11月5日
 *         <p>
 * 		Description: Given a n-ary tree, find its maximum depth.
 * 
 *         The maximum depth is the number of nodes along the longest path from
 *         the root node down to the farthest leaf node.
 *         </p>
 */
public class Problem_559_MaximumDepthofNaryTree {
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

	public int maxDepth(Node root) {
		if (root == null) {
			return 0;
		} else if (root.children.isEmpty()) {
			return 1;
		} else {
			// 
			List<Integer> heights = new LinkedList<>();
			// 遍历节点的孩子
			for (Node item : root.children) {
				// 将子树的高度递归加入height
				heights.add(maxDepth(item));
			}
			// 最后加上根那一层
			return Collections.max(heights) + 1;
		}
	}
}
