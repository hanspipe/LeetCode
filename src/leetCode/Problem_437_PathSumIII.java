package leetCode;

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
