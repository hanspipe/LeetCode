package leetCode;

import java.util.LinkedList;
import java.util.List;

/**
 * 
 * @author louis 2018��11��17��
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
		
		// Ҷ�ڵ�
		if(root.left == null && root.right == null)
		{
			paths.add(root.val + "");
			return paths;
		}
		
		// �Ե�ǰ�ڵ��������, Ҫ���ϵ�ǰ�ڵ��ֵ
		for(String path : binaryTreePaths(root.left))
			paths.add(root.val + "->" + path);
		
		for(String path : binaryTreePaths(root.right))
			paths.add(root.val + "->" + path);
		
		return paths;
		
	}
}
