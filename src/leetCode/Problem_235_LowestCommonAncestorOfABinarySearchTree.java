package leetCode;

/**
 * 
 * @author louis
 * 2018年11月4日
 * <p>Description: Given a binary search tree (BST), 
 * 
 * find the lowest common ancestor (LCA) of two given nodes in the BST.

According to the definition of LCA on Wikipedia:

 “The lowest common ancestor is defined between two nodes p and q as the lowest node in T 
 
 that has both p and q as descendants (where we allow a node to be a descendant of itself).”</p>
 */
public class Problem_235_LowestCommonAncestorOfABinarySearchTree {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	// 这个递归看着很好理解啊...但是记不住
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (p.val > root.val && q.val > root.val)
			return lowestCommonAncestor(root.right, p, q);
		else if (p.val < root.val && q.val < root.val)
			return lowestCommonAncestor(root.left, p, q);

		return root;
	}
}
