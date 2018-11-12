package leetCode;
/**
 * 
 * @author louis
 * 2018年11月12日
 * <p>Description: Given the root node of a binary search tree (BST) and a value to be inserted into the tree, 
 * 
 * insert the value into the BST. Return the root node of the BST after the insertion. 
 * 
 * It is guaranteed that the new value does not exist in the original BST.

	Note that there may exist multiple valid ways for the insertion, 

	as long as the tree remains a BST after insertion. You can return any of them.</p>
 */
public class Problem_701_InsertintoaBinarySearchTree {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public TreeNode insertIntoBST(TreeNode root, int val) {
		if(root == null)
			// 如果树空, new一个节点
			return new TreeNode(val);
		TreeNode cur = root;
		while(true) {
			// 如果当前节点值小于等于val 
			if(cur.val <= val) {
				// 右子树不空就移动到右子树
				if(cur.right != null)
					cur = cur.right;
				else {// 右子树空就新建右子树
					cur.right = new TreeNode(val);
					break;
				}
			}else {
				if(cur.left != null)
					cur = cur.left;
				else {
					cur.left = new TreeNode(val);
					break;
				}
			}
		}
		return root;
	}
}
