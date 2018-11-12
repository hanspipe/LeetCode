package leetCode;

/**
 * 
 * @author louis
 * 2018年11月12日
 * <p>Description: Given two non-empty binary trees s and t, 
 * 
 * check whether tree t has exactly the same structure and node values with a subtree of s. 
 * 
 * A subtree of s is a tree consists of a node in s and all of this node's descendants.
 * 
 * The tree s could also be considered as a subtree of itself.</p>
 */
public class Problem_572_SubTreeOfAnotherTree {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public boolean isSubtree(TreeNode s, TreeNode t) {
		return traverse(s, t);
	}
	
	// 判断两个树是否相等
	public boolean equals(TreeNode x, TreeNode y) {
		if(x == null && y == null)
			return true;
		if(x == null || y == null)
			return false;
		return x.val == y.val && equals(x.left, y.left) && equals(x.right, y.right);
	}
	
	// 首先s不为空, 然后判断 t是否与s,s的左子树,s的右子树相等,满足一个条件即可
	public boolean traverse(TreeNode s, TreeNode t) {
		return s!= null && (equals(s, t) || equals(s.left, t) || equals(s.right, t));
	}
}
