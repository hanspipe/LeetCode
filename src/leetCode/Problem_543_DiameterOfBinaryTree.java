package leetCode;

/**
 * 
 * @author louis 2018Äê11ÔÂ13ÈÕ
 *         <p>
 *         Description: Given a binary tree,
 * 
 *         you need to compute the length of the diameter of the tree.
 * 
 *         The diameter of a binary tree is the length of the longest path
 * 
 *         between any two nodes in a tree.
 * 
 *         This path may or may not pass through the root.
 *         </p>
 */
public class Problem_543_DiameterOfBinaryTree {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	// Depth-First Search

	public int diameterOfBinaryTree(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int dia = depth(root.left) + depth(root.right);
		int ldia = diameterOfBinaryTree(root.left);
		int rdia = diameterOfBinaryTree(root.right);
		return Math.max(dia, Math.max(ldia, rdia));

	}

	public int depth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return 1 + Math.max(depth(root.left), depth(root.right));
	}
}
