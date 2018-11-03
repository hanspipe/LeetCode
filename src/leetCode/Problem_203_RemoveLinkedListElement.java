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
		// �����ǰ�ڵ�ֵ==value, ������һ���ڵ�, ���򷵻ص�ǰ�ڵ�
		return head.val == val ? head.next : head;
	}

	public ListNode removeElements(ListNode head, int val) {
		// ��ʼ��һ��fakeHead
		ListNode fakeHead = new ListNode(-1);
		// ����
		fakeHead.next = head;
		// ͬʱ��¼��ǰ�ڵ�͵�ǰ�ڵ��ǰһ���ڵ�
		ListNode cur = head;
		ListNode prev = fakeHead;
		// ��ǰ��Ϊ�յ�ʱ��
		while (cur != null) {
			if (cur.val == val) {// ��ǰ�ڵ�ֵ���==value
				//
				prev.next = cur.next;
			} else {//
				prev = prev.next;
			}
			// cur������ζ�Ҫ����
			cur = cur.next;
		}
		// ע����󷵻�ֵ
		return fakeHead.next;
	}
}
