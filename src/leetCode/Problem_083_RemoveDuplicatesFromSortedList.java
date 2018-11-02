package leetCode;
//Given a sorted linked list, delete all duplicates such that each element appear only once
public class Problem_083_RemoveDuplicatesFromSortedList {
	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public ListNode deleteDuplicates(ListNode head) {
		
		ListNode cur = head;
		//当前节点不为空且当前节点的下一个节点不为空
		while (cur != null && cur.next != null) {
			if (cur.val == cur.next.val) {//如果当前节点值=下一个节点值
				//只用改变cur.next
				cur.next = cur.next.next;
			}else {//否则就往后
				cur = cur.next;
			}
		}
		return head;

	}
}
