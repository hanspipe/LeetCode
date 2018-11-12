package leetCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * 
 * @author louis
 * 2018年11月12日
 * <p>Description: Given an n-ary tree, return the postorder traversal of its nodes' values.</p>
 */
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

	// 递归
	public List<Integer> postorder1(Node root) {
		List<Integer> list = new ArrayList<>();
		if(root == null)
			return list;
		for(Node node : root.children)
			postorder1(node);
		list.add(root.val);
		return list;
	}

	// 非递归
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
	
	
	// Iteration
	public List<Integer> postOrder(Node root){
		Stack<Node> stack = new Stack<>();
		LinkedList<Integer> output = new LinkedList<>();
		if(root == null)
			return output;
		
		stack.push(root);
		while(!stack.isEmpty()) {
			Node node = stack.pop();
			output.addFirst(node.val);
			for(Node item : node.children) {
				if(item != null)
					stack.push(item);
			}
		}
		return output;
	}
}
