package leetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Problem_872_LeafSimilarTrees {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public boolean leafSimilar(TreeNode root1, TreeNode root2) {
		Stack<TreeNode> s1 = new Stack<>();
		Stack<TreeNode> s2 = new Stack<>();
		s1.push(root1);
		s2.push(root2);
		while(!s1.isEmpty() && !s2.isEmpty())
			if(dfs(s1) != dfs(s2)) return false;
		return s1.empty() && s2.empty();
		
		

	}
	
	public static int dfs(Stack<TreeNode> s) {
		while(true) {
			TreeNode node = s.pop();
			if(node.right != null) s.push(node.right);
			if(node.left != null) s.push(node.left);
			if(node.left == null && node.right == null) return node.val;
		}
	}
}
