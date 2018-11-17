package leetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import org.w3c.dom.Node;

/**
 * 
 * @author louis 2018年11月17日
 *         <p>
 *         Description: We are given a binary tree (with root node root), a
 *         target node, and an integer value K.
 * 
 *         Return a list of the values of all nodes that have a distance K from
 *         the target node. The answer can be returned in any order.
 *         </p>
 */
public class Problem_863_AllNodesDistanceKinBinaryTree {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	// 保存每个节点的父节点
	Map<TreeNode, TreeNode> parent;

	public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
		parent = new HashMap<>();
		// 保存了每个节点及其父节点
		dfs(root, null);

		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(null);
		queue.add(target);

		// 已经遍历过的节点
		Set<TreeNode> seen = new HashSet<>();
		seen.add(target);
		seen.add(null);

		int dist = 0;
		while (!queue.isEmpty()) {
			TreeNode cur = queue.poll();
			if (cur == null) {
				if (dist == K) {
					List<Integer> ans = new ArrayList<>();
					for (TreeNode n : queue)
						ans.add(n.val);
					return ans;
				}
				queue.offer(null);
				dist++;
			}else {
				if(!seen.contains(cur.left)) {
					seen.add(cur.left);
					queue.offer(cur.left);
				}
				if(!seen.contains(cur.right)) {
					seen.add(cur.right);
					queue.offer(cur.right);
				}
				TreeNode par = parent.get(cur);
				if(!seen.contains(par)) {
					seen.add(par);
					queue.offer(par);
				}
			}
		}
		return new ArrayList<Integer>();
	}

	public void dfs(TreeNode node, TreeNode par) {
		if (node != null) {
			parent.put(node, par);
			dfs(node.left, node);
			dfs(node.right, node);
		}
	}
}
