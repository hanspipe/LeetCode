package leetCode;

import java.util.LinkedList;
import java.util.List;

/**
 * 
 * @author louis 2018年11月17日
 *         <p>
 *         Description:Given a binary tree, return all root-to-leaf paths.
 *         </p>
 */
public class Problem_257_BinaryTreePaths {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public List<String> binaryTreePaths(TreeNode root) {
		List<String> paths = new LinkedList<>();
		if(root == null)
			return paths;
		
		// 叶节点
		if(root.left == null && root.right == null)
		{
			paths.add(root.val + "");
			return paths;
		}
		
		// 对当前节点的左子树, 要加上当前节点的值
		for(String path : binaryTreePaths(root.left))
			paths.add(root.val + "->" + path);
		
		for(String path : binaryTreePaths(root.right))
			paths.add(root.val + "->" + path);
		
		return paths;
		
	}
}
