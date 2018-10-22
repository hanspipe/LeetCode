package leetCode;

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
		String s = "sfsfs";
		char a = s.charAt(3);
			return root;
			
	}
}
