package leetCode;

import java.util.Stack;

/**
 * 
 * @author louis
 * 2018年11月12日
 * <p>Description:Given two binary trees and imagine that when you put one of them to cover the other, 
 * 
 * some nodes of the two trees are overlapped while the others are not.

	You need to merge them into a new binary tree. The merge rule is that if two nodes overlap,

 	then sum node values up as the new value of the merged node. Otherwise, the NOT null node will be used as the node of new tree. </p>
 */
public class Problem_617_MergeTwoBinaryTrees {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
	
	public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
		// 主要是边界条件
		if(t1 == null)
			return t2;
		if(t2 != null) {
			t1.val += t2.val;
			t1.left = mergeTrees(t1.left, t2.left);
			t1.right = mergeTrees(t1.right, t2.right);
		}
		return t1;
	}
	
	// Iteration
	public TreeNode merge(TreeNode t1, TreeNode t2) {
		if(t1 == null)
			return t2;
		Stack<TreeNode[]> stack = new Stack<>();
		// 每次push一个TreeNode数组
		stack.push(new TreeNode[] {t1, t2});
		while(!stack.isEmpty()) {
			TreeNode[] t = stack.pop();
			if(t[0] == null || t[1] == null)
				continue;
			t[0].val += t[1].val;
			if(t[0].left == null)
				t[0].left = t[1].left;
			else
				stack.push(new TreeNode[] {t[0].left, t[1].left});
			if(t[0].right == null)
				t[0].right = t[1].right;
			else
				stack.push(new TreeNode[] {t[0].right, t[1].right});
		}
		return t1;
	}
}
