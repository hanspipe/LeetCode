package leetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 
 * @author louis 2018Äê11ÔÂ15ÈÕ
 *         <p>
 * 		Description: Given a tree,
 * 
 *         rearrange the tree in in-order so that the leftmost node in the tree
 *         is now the root of the tree,
 * 
 *         and every node has no left child and only 1 right child.
 *         </p>
 */
public class Problem_897_IncreasingOrderSearchTree {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public TreeNode increasingBST(TreeNode root) {
		Stack<TreeNode> stack = new Stack<>();
		List<Integer> list = new ArrayList<>();
		if(root == null)
			return null;
		TreeNode node = root;
		TreeNode newRoot = new TreeNode(-1);
		while(node != null || !stack.isEmpty()) {
			while(node != null) {
				stack.push(node);
				node = node.left;
			}
			
			node = stack.pop();
			list.add(node.val);
			node = node.right;
		}
		
		TreeNode cur = newRoot;
		for(Integer v : list) {
			cur.right = new TreeNode(v);
			cur = cur.right;
		}
		return newRoot.right;
	}
}
