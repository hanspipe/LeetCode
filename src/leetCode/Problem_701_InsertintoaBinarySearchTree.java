package leetCode;
/**
 * 
 * @author louis
 * 2018��11��12��
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
			// �������, newһ���ڵ�
			return new TreeNode(val);
		TreeNode cur = root;
		while(true) {
			// �����ǰ�ڵ�ֵС�ڵ���val 
			if(cur.val <= val) {
				// ���������վ��ƶ���������
				if(cur.right != null)
					cur = cur.right;
				else {// �������վ��½�������
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
