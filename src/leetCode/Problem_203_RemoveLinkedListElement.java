package leetCode;

//Remove all elements from a linked list of integers that have value val.
public class Problem_203_RemoveLinkedListElement {
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	// recursion
	public ListNode removeElementsRecursion(ListNode head, int val) {
		if (head == null)
			return head;
		head.next = removeElementsRecursion(head.next, val);
		// 如果当前节点值==value, 返回下一个节点, 否则返回当前节点
		return head.val == val ? head.next : head;
	}

	public ListNode removeElements(ListNode head, int val) {
		// 初始化一个fakeHead
		ListNode fakeHead = new ListNode(-1);
		// 连上
		fakeHead.next = head;
		// 同时记录当前节点和当前节点的前一个节点
		ListNode cur = head;
		ListNode prev = fakeHead;
		// 当前不为空的时候
		while (cur != null) {
			if (cur.val == val) {// 当前节点值如果==value
				//
				prev.next = cur.next;
			} else {//
				prev = prev.next;
			}
			// cur无论如何都要更新
			cur = cur.next;
		}
		// 注意最后返回值
		return fakeHead.next;
	}
}
