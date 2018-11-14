package leetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author louis 2018年11月14日
 *         <p>
 * 		Description: The thief has found himself a new place for his thievery
 *         again.
 * 
 *         There is only one entrance to this area, called the "root."
 * 
 *         Besides the root, each house has one and only one parent house.
 * 
 *         After a tour, the smart thief realized that "all houses in this place
 *         forms a binary tree".
 * 
 *         It will automatically contact the police if two directly-linked
 *         houses were broken into on the same night.
 * 
 *         DetDetermine the maximum amount of money the thief can rob tonight
 *         without alerting the police.
 *         </p>
 */
public class Problem_337_HouseRobberIII {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public int rob(TreeNode root) {
		return robSub(root, new HashMap<>());
	}
	
	private static int robSub(TreeNode root, Map<TreeNode , Integer> map) {
		if(root == null)
			return 0;
		if(map.containsKey(root))
			return map.get(root);
		 int val = 0;
		 
		 if(root.left != null) {
			 val += robSub(root.left.left, map) + robSub(root.left.right, map);
		 }
		 
		 if(root.right != null) {
			 val += robSub(root.right.left, map) + robSub(root.right.right, map);
		 }
		 
		 val = Math.max(val + root.val, robSub(root.left, map) + robSub(root.right, map));
		 map.put(root, val);
		 
		 return val;
	}
	
	public int rob1(TreeNode root) {
		int[] res = robSub1(root);
		// res[0]:当前节点不抢, res[1]:当前节点抢
		return Math.max(res[0], res[1]);
	}
	
	public static int[] robSub1(TreeNode root) {
		if(root == null)
			return new int[2];
		
		int[] left = robSub1(root.left);
		int[] right = robSub1(root.right);
		int[] res = new int[2];
		
		// 如果当前节点不抢,子节点可以选择强或不抢, 就选择最大的
		res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
		// 当前节点抢了,那么子节点就不能抢
		res[1] = root.val + left[0] + right[0];
		
		return res;
	}
	
	

}
