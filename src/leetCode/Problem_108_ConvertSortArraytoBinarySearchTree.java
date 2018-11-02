package leetCode;

/**
 * 
 * @author louis
 * 2018年10月27日
 * <p>Description: Given an array where elements are sorted in ascending order, convert it to a height balanced BST.</p>
 */
public class Problem_108_ConvertSortArraytoBinarySearchTree {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public TreeNode sortedArrayToBST(int[] nums) {
		//数组长度为0时直接返回null
		if(nums.length ==0)
			return null;
		TreeNode root = this.helper(nums, 0, nums.length-1);
		return root;
	}

	public  TreeNode helper(int[] nums, int lo, int hi) {
		if (lo > hi)
			return null;

		//找中点
		int mid = lo + (hi - lo) / 2;
		TreeNode node = new TreeNode(nums[mid]);
		node.left = helper(nums, lo, mid - 1);
		node.right = helper(nums, mid + 1, hi);
		return node;
	}
}
