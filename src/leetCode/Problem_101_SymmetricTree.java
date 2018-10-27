package leetCode;
import java.util.LinkedList;
import java.util.Queue;
/**
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 */

public class Problem_101_SymmetricTree {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	//递归
	public boolean isSymmetric1(TreeNode root) {
		return isMirror(root, root);
	}
	
	//递归
	private static boolean isMirror(TreeNode t1, TreeNode t2) {
		if(t1 == null && t2 == null)
			return true;
		if(t1 == null || t2 == null)
			return false;
		//是镜像的条件：1、两棵数根节点的值相同；2、一棵树的左子树也是另一个数的右子树镜像
		return (t1.val == t2.val) && isMirror(t1.left, t2.right) && isMirror(t1.right, t2.left);
	}
	
	//迭代
	public boolean isSymmetric2(TreeNode root) {
		Queue<TreeNode> q = new LinkedList<>();
		q.add(root);
		q.add(root);
		while(!q.isEmpty()) {
			// 依出队顺序比较
			TreeNode t1 = q.poll();
			TreeNode t2 = q.poll();
			if(t1 == null && t2 == null)
				continue;
			if(t1 == null || t2 == null)
				return false;
			if(t1.val != t2.val)
				return false;
			// 入队顺序：t1左t2右，t1右t2左
			q.add(t1.left);
			q.add(t2.right);
			q.add(t1.right);
			q.add(t2.left);
		}
		return true;
	}
}
