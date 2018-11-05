package leetCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class Problem_590_NaryTreePostorderTraversal {
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

	// µÝ¹é
	public List<Integer> postorder1(Node root) {
		List<Integer> list = new ArrayList<>();
		if(root == null)
			return list;
		for(Node node : root.children)
			postorder1(node);
		list.add(root.val);
		return list;
	}

	// ·ÇµÝ¹é
	public List<Integer> postorder(Node root) {
		List<Integer> list = new ArrayList<>();
		if(root == null)
			return list;
		
		Stack<Node> stack = new Stack<>();
		stack.add(root);
		
		while(!stack.isEmpty()) {
			root = stack.pop();
			list.add(root.val);
			for(Node node : root.children)
				stack.add(node);
		}
		Collections.reverse(list);
		return list;
	}
}
