package leetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
/**
 * 
 * @author louis
 * 2018��11��15��
 * <p>Description: N����������� ʹ�ö���</p>
 */
public class Problem_429_NaryTreeLevelOrderTraversal {

	class Node {
		public int val;
		public List<Node> children;

		public Node() {
		}

		public Node(int _val, List<Node> _children) {
			val = _val;
			children = _children;
		}
	}

	public List<List<Integer>> levelOrder(Node root) {
		List<List<Integer>> res = new ArrayList<>();
		if (root == null)
			return res;
		Queue<Node> queue = new LinkedList<>();
		// �ȰѸ��ڵ�������
		queue.add(root);
		while (!queue.isEmpty()) {
			// ����ÿһ��Ľڵ�ֵ
			List<Integer> currLevel = new ArrayList<>();
			// ��ǰ��Ľڵ����
			int size = queue.size();
			// �ڶ����б�����ǰ��Ľڵ�
			for (int i = 0; i < size; i++) {
				Node node = queue.poll();
				// �ڵ�ֵ����currLevel
				currLevel.add(node.val);
				// ÿ���ڵ�����к��Ӷ����
				for (Node n : node.children)
					queue.offer(n);
			}
			// ���ѵ�ǰ�����нڵ�ֵ����res
			res.add(currLevel);
		}
		return res;
	}
}
