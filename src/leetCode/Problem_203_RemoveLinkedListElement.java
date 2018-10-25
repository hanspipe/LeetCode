package leetCode;

public class Problem_203_RemoveLinkedListElement {
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	//recursion
	public ListNode removeElementsRecursion(ListNode head, int val) {
		if(head == null)
			return head;
		head.next = removeElementsRecursion(head.next, val);
		return head.val == val ? head.next : head;
	}
	
	public ListNode removeElements(ListNode head, int val) {
		ListNode fakeHead = new ListNode(-1);
		fakeHead.next = head;
		ListNode cur = head;
		ListNode prev = fakeHead;
		while(cur != null) {
			if(cur.val == val) {
				prev.next = cur.next;
			}else {
				prev = prev.next;
			}
			cur = cur.next;
		}
		return fakeHead.next;
	}
}
