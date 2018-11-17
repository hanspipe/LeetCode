package leetCode;

/**
 * 
 * @author louis
 * 2018Äê11ÔÂ4ÈÕ
 * <p>Description: You are given a binary tree in which each node contains an integer value.

	Find the number of paths that sum to a given value.

	The path does not need to start or end at the root or a leaf,

 	but it must go downwards (traveling only from parent nodes to child nodes).</p>
 */
public class Problem_437_PathSumIII {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	// DFS
	public int pathSum(TreeNode root, int sum) {
		if (root == null)
			return 0;
		return pathSumFrom(root, sum) + pathSumFrom(root.left, sum) + pathSumFrom(root.right, sum);
	}
	private static int pathSumFrom(TreeNode node, int sum) {
		if (node == null)
			return 0;
		int res = 0;
		if(sum == node.val)
			res++;
		res += pathSumFrom(node.left, sum - node.val);
		res += pathSumFrom(node.right, sum - node.val);
		return res;
	}
}
