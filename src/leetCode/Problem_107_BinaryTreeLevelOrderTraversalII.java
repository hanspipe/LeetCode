package leetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * 
 * @author louis
 * 2018年10月27日
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

	//层序遍历，先将根节点入队，根节点出队的同时根节点的左右子节点入队，每次所记录的size就是当前层上的节点个数
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
			// 这个循环，将本层节点加入list，将下层入队
			while(size-- > 0) {
				TreeNode node = queue.poll();
				list.add(node.val);
				if(node.left != null)
					queue.offer(node.left);
				if(node.right != null)
					queue.offer(node.right);
			}
			// 将list入栈
			stack.push(list);
		}
		// 栈弹出的顺序就是从树的底层到上层
		while(!stack.isEmpty())
			res.add(stack.pop());
		return res;
	}
}
