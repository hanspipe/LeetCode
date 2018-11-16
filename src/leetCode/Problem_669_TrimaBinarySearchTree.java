package leetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 
 * @author louis 2018年11月15日
 *         <p>
 *         Description: Given a binary search tree and the lowest and highest
 *         boundaries as L and R,
 * 
 *         trim the tree so that all its elements lies in [L, R] (R >= L).
 * 
 *         You might need to change the root of the tree,
 * 
 *         so the result should return the new root of the trimmed binary search
 *         tree.
 *         </p>
 */
public class Problem_669_TrimaBinarySearchTree {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	// recursion
	public TreeNode trimBST1(TreeNode root, int L, int R) {
		if (root == null)
			return root;
		root.left = trimBST1(root.left, L, R);
		root.right = trimBST1(root.right, L, R);
		if (root.val > R)
			return trimBST1(root.left, L, R);
		if (root.val < L)
			return trimBST1(root.right, L, R);

		return root;
	}
	
	// iteration
	public TreeNode trimBST2(TreeNode root, int L, int R) {
		if(root == null)
			return null;
		
		// find a valid root which is used to return
		while(root.val < L || root.val > R) {
			if(root.val <L)
				root = root.right;
			if(root.val > R)
				root = root.left;
		}
		
		// 哑结点
		TreeNode dummy = root;
		// remove the invalid nodes from left subtree
		while(dummy != null) {
			while(dummy.left != null && dummy.left.val < L)
				dummy.left = dummy.left.right;
			// if the left child is smaller than L, then we keep the right subtree of it
			dummy = dummy.left;
		}
		
		dummy = root;
		// remove the invalid nodes from right subtree
		while(dummy != null) {
			while(dummy.right != null && dummy.right.val >R) {
				dummy.right = dummy.right.left;
			}
			dummy = dummy.right;
		}
		
		return root;
	}

	public TreeNode trimBST(TreeNode root, int L, int R) {
		if (root == null)
			return null;
		List<Integer> list = treeToArray(root, L, R);
		if(list.size() == 0)
			return null;
		int l = 0;
		int r = list.size() - 1;
		return constructBST(list, l, r);

	}

	public static List<Integer> treeToArray(TreeNode root, int L, int R) {
		List<Integer> res = new ArrayList<>();
		if (root == null)
			return res;
		Stack<TreeNode> stack = new Stack<>();
		TreeNode cur = root;
		while (cur != null || !stack.isEmpty()) {
			while (cur != null) {
				stack.push(cur);
				cur = cur.left;
			}

			cur = stack.pop();
			if (cur.val >= L && cur.val <= R)
				res.add(cur.val);
			cur = cur.right;
		}
		return res;
	}

	public TreeNode constructBST(List<Integer> list, int l, int r) {
		if (l > r)
			return null;
		int mid = l + (r - l) / 2;
		TreeNode root = new TreeNode(list.get(mid));
		root.left = constructBST(list, l, mid - 1);
		root.right = constructBST(list, mid + 1, r);
		return root;
	}
}
