package leetCode;

import leetCode.Problem_889_ConstructBinaryTreefromPreorderandPostorderTraversal.TreeNode;

/**
 * 
 * @author louis
 * 2018Äê11ÔÂ15ÈÕ
 * <p>Description:Given a binary tree rooted at root, the depth of each node is the shortest distance to the root.

A node is deepest if it has the largest depth possible among any node in the entire tree.

The subtree of a node is that node, plus the set of all descendants of that node.

Return the node with the largest depth such that it contains all the deepest nodes in its subtree. </p>
 */
public class Problem_865_SmallestSubtreewithalltheDeepestNodes {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
public TreeNode subtreeWithAllDeepest(TreeNode root) {
	return root;
        
    }
}
