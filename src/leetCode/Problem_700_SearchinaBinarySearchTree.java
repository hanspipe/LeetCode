package leetCode;
/**
 * 
 * @author louis
 * 2018Äê11ÔÂ12ÈÕ
 * <p>Description: Given the root node of a binary search tree (BST) and a value. 
 * 
 * 	You need to find the node in the BST that the node's value equals the given value. 
 * 
 * 	Return the subtree rooted with that node. If such node doesn't exist, you should return NULL.</p>
 */
public class Problem_700_SearchinaBinarySearchTree {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public TreeNode searchBST(TreeNode root, int val) {
		if(root == null)
			return null;
		while(root != null) {
			if(root.val > val)
				root = root.left;
			else if(root.val < val)
				root = root.right;
			else
				break;			
		}
			return root;
	}
}
