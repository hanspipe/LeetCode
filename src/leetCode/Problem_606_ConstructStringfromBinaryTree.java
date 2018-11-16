package leetCode;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;
/**
 * 
 * @author louis
 * 2018��11��15��
 * <p>Description: You need to construct a string consists of parenthesis and integers from a binary tree with the preorder traversing way.

	The null node needs to be represented by empty parenthesis pair "()". 
	
	And you need to omit all the empty parenthesis pairs that don't affect the one-to-one mapping 
	
	relationship between the string and the original binary tree.</p>
 */
public class Problem_606_ConstructStringfromBinaryTree {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	// recursion
	public String tree2str(TreeNode t) {
		if(t == null)
			return  "";
		// ����������Ϊ�յ����
		if(t.left == null && t.right == null)
			return t.val + "";
		// ֻ�������������
		if(t.right == null)
			// �ýڵ�ֵ ���� �������Ľ�� ������������
			return t.val + "(" + tree2str(t.left) + ")";
		// ���Ҷ����ջ���ֻ�������������
		// �ýڵ�ֵ ���� ���������������������Ľ�� ���� ���������������������Ľ��
		return t.val + "(" + tree2str(t.left) + ")(" + tree2str(t.right) + ")"; 
	}
	
	// iteration
	public String tree2str1(TreeNode t) {
		if(t == null)
			return "";
		Stack<TreeNode> stack = new Stack<>();
		stack.push(t);
		Set<TreeNode> visited = new HashSet<>();
		StringBuilder sb = new StringBuilder();
		while(!stack.isEmpty()) {
			t = stack.peek();
			if(visited.contains(t)) {
				stack.pop();
				sb.append(")");
			}else {
				visited.add(t);
				sb.append("(" + t.val);
				if(t.left ==null && t.right != null)
					sb.append("()");
				if(t.right != null)
					stack.push(t.right);
				if(t.left != null)
					stack.push(t.left);
			}
		}
		return sb.substring(1, sb.length() - 1);
	}
}
