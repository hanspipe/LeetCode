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

		// ���ڵ���ջ
		stack.add(root);
		while (!stack.isEmpty()) {
			// ��ǰ�ڵ��ջ
			Node node = stack.pollLast();
			// ��ǰ�ڵ��ֵ����List
			output.add(node.val);
			// ����ǰ�ڵ�ĺ��ӽڵ�����, ��Ϊ���˳���Ǵ�������, ������ջ��Ҫ��������, 
			// �����������, ��ջ˳�������Һ���
			Collections.reverse(node.children);
			// ���ӽڵ��������������ջ.
			for (Node item : node.children)
				stack.add(item);
		}
		return output;
	}
}
