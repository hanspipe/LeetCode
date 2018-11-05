package leetCode;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 
 * @author louis 2018��11��5��
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
			// �����ڵ�ĺ���
			for (Node item : root.children) {
				// �������ĸ߶ȵݹ����height
				heights.add(maxDepth(item));
			}
			// �����ϸ���һ��
			return Collections.max(heights) + 1;
		}
	}
}
