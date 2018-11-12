package leetCode;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Problem_589_NaryTreePreorderTraversal {

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

	public List<Integer> preorder(Node root) {
		LinkedList<Node> stack = new LinkedList<>();
		List<Integer> output = new LinkedList<>();

		if (root == null)
			return output;

		// 根节点入栈
		stack.add(root);
		while (!stack.isEmpty()) {
			// 当前节点出栈
			Node node = stack.pollLast();
			// 当前节点的值存入List
			output.add(node.val);
			// 将当前节点的孩子节点置逆, 因为输出顺序是从左往右, 所以入栈就要从右往左, 
			// 与二叉树相似, 入栈顺序是先右后左
			Collections.reverse(node.children);
			// 将子节点从右往左依次入栈.
			for (Node item : node.children)
				stack.add(item);
		}
		return output;
	}
}
