package leetCode;

import java.util.Stack;

public class Problem_538_ConvertBSTtoGreaterTree {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	// recursion
	public TreeNode convertBST(TreeNode root) {
		int sum = 0;
		if (root != null) {
			convertBST(root.right);
			sum += root.val;
			root.val = sum;
			convertBST(root.left);
		}
		return root;
	}

	// iteration
	public TreeNode convertBST1(TreeNode root) {
		int sum = 0;
		TreeNode node = root;
		Stack<TreeNode> stack = new Stack<>();
		
		while(!stack.isEmpty() || node != null)
		{
			// 节点存在,则压栈
			while(node != null) {
				stack.push(node);
				//一路向右向右, 因为右孩子比当前节点大
				node = node.right;
			}
			
			node = stack.pop();
			// 更新当前节点的值
			sum += node.val;
			node.val = sum;
			// 再处理左孩子
			node = node.left;
		}
		
		return root;
	}
}
