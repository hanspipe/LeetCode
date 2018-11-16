package leetCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

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
		  List<Integer> list = new ArrayList<>();
	        Stack<Node> stack = new Stack<>();
	        if(root == null)
	            return null;
	        stack.push(root);
	        while(!stack.isEmpty()){
	            Node node = stack.pop();
	            list.add(node.val);
	            for(int i = node.children.size() -1 ; i >= 0; i--)
	                stack.push(node.children.get(i));
	        }
	        return list;
	}
}
