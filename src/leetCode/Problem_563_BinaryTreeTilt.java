package leetCode;

/**
 * 
 * @author louis 2018Äê11ÔÂ14ÈÕ
 *         <p>
 * 		Description:Given a binary tree, return the tilt of the whole tree.
 * 
 *         The tilt of a tree node is defined as the absolute difference between
 *         the sum of
 * 
 *         all left subtree node values and the sum of all right subtree node
 *         values. Null node has tilt 0.
 * 
 *         The tilt of the whole tree is defined as the sum of all nodes' tilt.
 *         </p>
 */
public class Problem_563_BinaryTreeTilt {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	int tilt = 0;
	public int findTilt(TreeNode root) {
		if(root == null)
			return 0;
		int curVal = 0;
		curVal = Math.abs(sumSubTree(root.left) - sumSubTree(root.right));
		return curVal + findTilt(root.left) + findTilt(root.right);
	}
	
	public static int sumSubTree(TreeNode root) {
		if(root == null)
			return 0;
		return root.val + sumSubTree(root.left) + sumSubTree(root.right);
	}
	
	public int traverse(TreeNode root) {
		if(root == null)
			return 0;
		int left = traverse(root.left);
		int right = traverse(root.right);
		tilt += Math.abs(left - right);
		return left + right + root.val;
	}
}
