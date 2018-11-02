package leetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * 
 * @author louis
 * 2018��10��27��
 * <p>Description: Given a binary tree, return the bottom-up level order traversal of its nodes' values. 
 * (ie, from left to right, level by level from leaf to root).</p>
 */
public class Problem_107_BinaryTreeLevelOrderTraversalII {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	//����������Ƚ����ڵ���ӣ����ڵ���ӵ�ͬʱ���ڵ�������ӽڵ���ӣ�ÿ������¼��size���ǵ�ǰ���ϵĽڵ����
	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		List<List<Integer>> res = new ArrayList<>();
		Stack<List<Integer>> stack = new Stack<>();
		Queue<TreeNode> queue = new LinkedList<>();
		if(root == null)
			return res;
		queue.add(root);
		while(!queue.isEmpty()) {
			int size = queue.size();
			List<Integer> list = new ArrayList<>();
			// ���ѭ����������ڵ����list�����²����
			while(size-- > 0) {
				TreeNode node = queue.poll();
				list.add(node.val);
				if(node.left != null)
					queue.offer(node.left);
				if(node.right != null)
					queue.offer(node.right);
			}
			// ��list��ջ
			stack.push(list);
		}
		// ջ������˳����Ǵ����ĵײ㵽�ϲ�
		while(!stack.isEmpty())
			res.add(stack.pop());
		return res;
	}
}
