package leetCode;

//Given a linked list, determine if it has a cycle in it.
public class Problem_141_LinkedListCycle {
	class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public boolean hasCycle(ListNode head) {
		if (head == null || head.next == null)
			return false;
		ListNode slow = head;
		ListNode fast = head.next;
		while (slow != fast) {
			if (fast == null || fast.next == null)
				return false;
			slow = slow.next;
			fast = fast.next.next;
		}
		return true;
	}
}
