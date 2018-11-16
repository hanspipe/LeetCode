package leetCode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class Problem_653_TwoSumIVInputisaBST {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	// Using HashSet
	public boolean findTarget1(TreeNode root, int k) {
		Set<Integer> set = new HashSet<>();
		return find(root, k, set);
	}

	public static boolean find(TreeNode root, int k, Set<Integer> set) {
		if (root == null)
			return false;
		if (set.contains(k - root.val))
			return true;
		set.add(root.val);
		return find(root.left, k, set) || find(root.right, k, set);
	}

	// Using BFS and HashSet
	public boolean findTarget2(TreeNode root, int k) {
		Set<Integer> set = new HashSet<>();
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		while (!queue.isEmpty()) {
			if (queue.peek() != null) {
				TreeNode node = queue.remove();
				if (set.contains(k - node.val))
					return true;
				set.add(node.val);
				queue.add(node.right);
				queue.add(node.left);
			} else {
				queue.remove();
			}
		}
		return false;
	}

	// Using BST
	public boolean findTarget3(TreeNode root, int k) {
		List<Integer> list = new ArrayList<>();
		inorder(root, list);
		int l = 0;
		int r = list.size() - 1;
		while (l < r) {
			int sum = list.get(l) + list.get(r);
			if (sum == k)
				return true;
			else if (sum < k)
				l++;
			else
				r--;
		}
		return false;
	}

	public static void inorder(TreeNode root, List<Integer> list) {
		if (root == null)
			return;
		inorder(root.left, list);
		list.add(root.val);
		inorder(root.right, list);
	}
}
